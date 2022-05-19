package com.example.show_recipes

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    var recipes_List = ArrayList<menu>() //리사이클러뷰에 들어갈 menu클라스 변수
    val recipes_list_Adatper = RecipesListAdapter(this,recipes_List ) //리사이클러뷰 어뎁터
    lateinit var recyclerView_recipes_list : RecyclerView //메뉴 리사이클러뷰(가로 슬라이드)


    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//////////리사이클러뷰/////////////////////////////////////////////////////////////////////////////
        recyclerView_recipes_list = findViewById(R.id.recyclerView_recipes_list) //메뉴 리사이클러뷰

        val recipes_linear_manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView_recipes_list.layoutManager = recipes_linear_manager
        recyclerView_recipes_list.setHasFixedSize(true)

        recyclerView_recipes_list.adapter = recipes_list_Adatper
///////////////////////////////////////////////////////////////////////////////////////////////

//////////STEP1. Firestore 사용자 데이터 받기///////////////////////////////////////////////////////////
        val db_firestore = FirebaseFirestore.getInstance() //Firestore 인스턴스 선언

        //UserSelect컬렉션(사용자 냉장고 재료 데이터)
        var user_refrigerator = ArrayList<ing_id_name_date>() //사용자 냉장고 재료&유통기한 받기
        var user_refrigerator_id_name = ArrayList<ing_id_name>() //사용자 냉장고 재료 id & 이름 받기
        var user_refrigerator_id_date = ArrayList<ing_id_date>() //사용자 냉장고 재료 id & 유통기한 받기
        var user_refrigerator_name = ArrayList<String>() //사용자 냉장고 재료 이름
        var ing_date : String

        //UserSelect 데이터 받기
        db_firestore.collection("UserSelect") //작업할 컬렉션
            .get() //문서 가져오기
            .addOnSuccessListener { result_UserSelect -> //성공할 경우

                //firebase로부터 사용자 냉장고 재료  받기
                user_refrigerator.clear()

                //Step1. 식재료 유통기한 & 이름 받기
                for (document_ref in result_UserSelect){
                    //user_refrigerator_date 채우기(id & 유통기한)
                    if ("year" in document_ref){
                        println("ing_id : ${document_ref.data["id"]}")
                        //ing_date : 유통기한 변수
                        //Cal_Date_len1 : '5'를 '05'로 받아서 날짜 형식에 맞게 해주는 함수
                        ing_date = Cal_Date_len1(document_ref.data["year"].toString()) +
                                Cal_Date_len1(document_ref.data["month"].toString()) +
                                Cal_Date_len1(document_ref.data["day"].toString())
                        //println("ing_date : $ing_date")

                        if (ing_date != "nullnullnull") {
                            ing_date = Cat_ing_editdate(Cal_Date(ing_date)) //유통기한 계산 함수, 카테고리화
                        }
                        println("Cat_ing_date : $ing_date")

                        val user_refrigerator_id_date_list = ing_id_date(document_ref.data["id"].toString(), ing_date)
                        user_refrigerator_id_date.add(user_refrigerator_id_date_list)

                    }
                    //user_refrigerator_name 채우기(id & 재료 이름)
                    else if ("menuname" in document_ref){
                        val user_refrigerator_id_name_list = ing_id_name(document_ref.data["id"].toString(),
                            document_ref.data["menuname"].toString())
                        //val user_refrigerator_name_list = document_ref_2.data["menuname"].toString()
                        user_refrigerator_id_name.add(user_refrigerator_id_name_list)
                        //user_refrigerator_name.add(user_refrigerator_name_list)
                    }

                }
/////////////////잘 받아졌는지 확인 용도 ////////////////////////////////////
//                for (ref_cnt : Int in 0..(user_refrigerator_date.size-1)){
//                    println("user_refrigerator_date_id[ref_cnt] : ${user_refrigerator_date[ref_cnt].id}")
//                    println("user_refrigerator_date_date[ref_cnt] : ${user_refrigerator_date[ref_cnt].date}")
//
//                }
//                println("user_refrigerator_date_date 크기 : ${user_refrigerator_date.size}")
//
//                for (ref_cnt : Int in 0..(user_refrigerator_name.size-1)){
//                    println("user_refrigerator_name_id[ref_cnt] : ${user_refrigerator_name[ref_cnt].id}")
//                    println("user_refrigerator_name_menuname[ref_cnt] : ${user_refrigerator_name[ref_cnt].menuname}")
//
//                }
//                println("user_refrigerator_name_id 크기 : ${user_refrigerator_name.size}")
//////////////////////////////////////////////////////////////////////

                //최종 user_refrigerator : 같은 id끼리 (id,재료 이름,유통기한) 받아옴
                for (date_cnt : Int in 0..(user_refrigerator_id_date.size-1)){
                    for(name_cnt : Int in 0..(user_refrigerator_id_name.size-1)){
                        if (user_refrigerator_id_name[name_cnt].id == user_refrigerator_id_date[date_cnt].id){
                            var ing_list = ing_id_name_date(
                                user_refrigerator_id_name[name_cnt].id,
                                user_refrigerator_id_name[name_cnt].menuname,
                                user_refrigerator_id_date[date_cnt].date
                            )
//                            println("재료  id  : ${user_refrigerator_id_name[name_cnt].id}")
//                            println("재료  name  : ${user_refrigerator_id_name[name_cnt].menuname}")
//                            println("재료  date  : ${user_refrigerator_id_date[date_cnt].date}")

                            user_refrigerator.add(ing_list)

                        }
                        else{
                            continue
                        }
                    }
                }

                //sql에 들어갈 재료 이름들 받아옴
                for (ref_cnt : Int in 0..(user_refrigerator.size-1)){
                    val user_refrigerator_name_list = user_refrigerator[ref_cnt].menuname
                    user_refrigerator_name.add(user_refrigerator_name_list)
                }

                println("user_refrigerator.size : ${user_refrigerator.size}")
                println("user_refrigerator_name.size : ${user_refrigerator_name.size}")

////////////////////STEP2.SQLite 레시피 데이터//////////////////////////////////////////////////////////////////////////

                ///////////SQL 문 안에 집어넣기 위해 변수 조정
                var sql_user_refrigerator_name = "\"" + user_refrigerator_name[0] //처음 재료는 먼저 넣어주기
                if(user_refrigerator_name.size > 0){ //사용자 냉장고에 재료가 있으면 레시피 추천 시작
                    //user_refrigerator_name를 sql로 넣기 위해 스트링 변수로 만들어주기
                    //in ()안에 넣기 위해서 ","로 엮어줌
                    for (name_cnt: Int in 1..(user_refrigerator_name.size - 2)){
                        sql_user_refrigerator_name += "\",\"" + user_refrigerator_name[name_cnt]
                    }
                    sql_user_refrigerator_name +=  "\",\"" + user_refrigerator_name[user_refrigerator_name.size - 1] + "\"" //마지막 재료 넣어주기
                    println("sql_user_refrigerator_name : $sql_user_refrigerator_name")
                ///////////


                    val db_sqlite = DataBaseHelper(this).readableDatabase //sql 인스턴스 선언

                    //Step2-1. 1차 추천(식재료 50프로 이상 보유시 추천 & 유통기한 빠른 순으로 제공)
                    //Step2-1-1. 레시피 식재료 50프로 이상 보유시 추천하는 레시피 id 받기
                    val sql_1_id = "SELECT info.RECIPE_NM_KO, info.COOKING_TIME, info.RECIPE_ID\n" +
                            "FROM recipe_information info, \n" +
                            "(SELECT ing.RECIPE_ID, count(ing.IRDNT_NM) AS RECIPE_ING_COUNT ,\n" +
                            "count(CASE WHEN ing.IRDNT_NM in (" + sql_user_refrigerator_name +") THEN 1 END) AS ABLE_ING_COUNT\n" +
                            "FROM recipe_ingredient ing\n" +
                            "GROUP BY ing.RECIPE_ID\n" +
                            "ORDER BY count(ing.IRDNT_NM)) user\n" +
                            "WHERE user.RECIPE_ID=info.RECIPE_ID\n" +
                            "and user.ABLE_ING_COUNT >= (user.RECIPE_ING_COUNT)*0.5\n"

                    val cursor_id = db_sqlite.rawQuery(sql_1_id,null)
                    var recipe_id_list = mutableSetOf<String>() //고유 recipe id

                    cursor_id.run{

                        while(moveToNext()){

//                            val RECIPE_NM_KO = cursor_id.getString(0)
//                            val COOKING_TIME = cursor_id.getString(1)
//                            Log.w("레시피_RECIPE_NM_KO : ", RECIPE_NM_KO)
//                            Log.w("레시피_COOKING_TIME : ", COOKING_TIME)

                            val RECIPE_ID_info = cursor_id.getString(2)

                            recipe_id_list.add(RECIPE_ID_info)
                            println("recipe_id_list : ${recipe_id_list}")

//                            val available_recipes_List = menu("bibimbap",RECIPE_NM_KO , COOKING_TIME)
//                            recipes_List.add(available_recipes_List)
//                            recipes_list_Adatper.notifyDataSetChanged() //리사이클러뷰 갱신
                        }
                    }

                    //Step2-1-2. Firebase의 식재료 유통기한과 DB의 레시피 재료를 비교하여 유통기한 빠른 순으로 정렬
                    val sql_1_irdnt_date = "SELECT ing.RECIPE_ID, ing.IRDNT_NM, user.RECIPE_ING_COUNT, info.RECIPE_NM_KO, user.ABLE_ING_COUNT, info.COOKING_TIME, info.IMG_URL\n" +
                            "FROM recipe_information info, recipe_ingredient ing,\n" +
                            "(SELECT ing.RECIPE_ID, count(ing.IRDNT_NM) AS RECIPE_ING_COUNT ,\n" +
                            "count(CASE WHEN ing.IRDNT_NM in (" + sql_user_refrigerator_name +") THEN 1 END) AS ABLE_ING_COUNT\n" +
                            "FROM recipe_ingredient ing\n" +
                            "GROUP BY ing.RECIPE_ID\n" +
                            "ORDER BY count(ing.IRDNT_NM)) user\n" +
                            "WHERE user.RECIPE_ID=info.RECIPE_ID and info.RECIPE_ID=ing.RECIPE_ID\n" +
                            "and user.ABLE_ING_COUNT >= (user.RECIPE_ING_COUNT)*0.5\n"

                    //유통기한 조건
                    val cursor_irdnt_date_list = db_sqlite.rawQuery(sql_1_irdnt_date,null)
                    var IRDNT_NM_ing_list = arrayListOf<String>()
                    val menu_image = findViewById<ImageButton>(R.id.menu_image)


                    cursor_irdnt_date_list.run{

                        while(moveToNext()){

                            recipe_id_list.forEach{

                                if (cursor_irdnt_date_list.getString(0) == it){ //id가 같을때
                                    val irdnt_nm_ing_list = cursor_irdnt_date_list.getString(1) //재료를 받아오는데
                                    IRDNT_NM_ing_list.add(irdnt_nm_ing_list)
                                    if(IRDNT_NM_ing_list.size.toString() == cursor_irdnt_date_list.getString(2)){ //해당 id의 레시피 재료 개수랑 같아지면
                                        val REAL_IRDNT_NM_ing_list = IRDNT_NM_ing_list //해당 id의 레시피 재료를 다 받았움!
                                        println("RECIPE_NM_KO : ${cursor_irdnt_date_list.getString(3)}")
                                        println("REAL_IRDNT_NM_ing_list : ${REAL_IRDNT_NM_ing_list}")
                                        println("user_refrigerator_name : ${user_refrigerator_name}")
                                        println("user.ABLE_ING_COUNT : ${cursor_irdnt_date_list.getString(4)}")
                                        println("user_refrigerator_name.size-1 : ${user_refrigerator_name.size-1}")

                                        var ing_editdate_hurry_cnt = 0
                                        var ing_editdate_good_cnt = 0
                                        var ing_editdate_enough_cnt = 0

                                        for (index:Int in 0..(user_refrigerator.size-1)){

                                            if (user_refrigerator[index].menuname in REAL_IRDNT_NM_ing_list){
                                                println("user_refrigerator[index].menuname : ${user_refrigerator[index].menuname}")
                                                println("user_refrigerator[index].date : ${user_refrigerator[index].date}")

                                                if(user_refrigerator[index].date == "급함"){
                                                    ing_editdate_hurry_cnt += 1
                                                }
                                                else if (user_refrigerator[index].date == "보통"){
                                                    ing_editdate_good_cnt += 1

                                                }
                                                else if (user_refrigerator[index].date == "여유"){
                                                    ing_editdate_enough_cnt += 1
                                                }
//                                                println("ing_editdate_hurry_cnt : ${ing_editdate_hurry_cnt}")
//                                                println("ing_editdate_good_cnt : ${ing_editdate_good_cnt}")
//                                                println("ing_editdate_enough_cnt : ${ing_editdate_enough_cnt}")
                                            }
                                        }
                                        println("ing_editdate_hurry_cnt : ${ing_editdate_hurry_cnt}")
                                        println("ing_editdate_good_cnt : ${ing_editdate_good_cnt}")
                                        println("ing_editdate_enough_cnt : ${ing_editdate_enough_cnt}")

                                        val RECIPE_NM_KO = cursor_irdnt_date_list.getString(3)
                                        val COOKING_TIME = cursor_irdnt_date_list.getString(5)
                                        val IMG_URL = cursor_irdnt_date_list.getString(6)
                                        //println("IMG_URL : ${IMG_URL}")
//                                        Glide.with(this@MainActivity)
//                                            .load(IMG_URL)
//                                            .into(menu_image)


                                        val available_recipes_List = menu(IMG_URL,RECIPE_NM_KO , COOKING_TIME,
                                            ing_editdate_hurry_cnt, ing_editdate_good_cnt, ing_editdate_enough_cnt)





                                        recipes_List.add(available_recipes_List)
                                        IRDNT_NM_ing_list = arrayListOf<String>() //초기화(다른 레시피 재료 받으러 가자~

                                    }
                                }
                            }
                        }
                    }
                    recipes_List.sortWith(compareBy ({ -it.hurry_cnt }, {-it.good_cnt}, {-it.enough_cnt}))

                    //잘 정렬되었는지 확인하는 용도
                    for (List_cnt : Int in 0..(recipes_List.size -1)){
                        println("recipes_List[menu_name] : ${recipes_List[List_cnt].menu_name}")
                        println("recipes_List[hurry_cnt] : ${recipes_List[List_cnt].hurry_cnt}")
                        println("recipes_List[good_cnt] : ${recipes_List[List_cnt].good_cnt}")
                        println("recipes_List[enough_cnt] : ${recipes_List[List_cnt].enough_cnt}")
                    }

                    recipes_list_Adatper.notifyDataSetChanged() //리사이클러뷰 갱신


                    //만들 수 있는 총 레시피 개수 출력 기능
                    val total_recipe_cnt = recipes_List.size.toString()
                    Log.w("레시피_total_recipe_cnt", total_recipe_cnt)
                    val TOTAL_RECIPE_CNT : TextView = findViewById(R.id.total_recipe_cnt_id)
                    TOTAL_RECIPE_CNT.text = "총 " + total_recipe_cnt + "개의 레시피가 검색되었습니다."

                    db_sqlite.close()
                }
////////////////////////////////////////////////////////////////////////////////////////////////////

            }
            .addOnFailureListener{exception ->
            //실패할 경우
            Log.w("MainActivity_Error", "UserSelect Error: $exception")
            }




////////////////////////////////////////////////////////////////////////////////////////////////////////


//        //2차 추천(체크박스)
//
//        val sql_2Btn : Button = findViewById(R.id.rec_2_Btn)
//        sql_2Btn.setOnClickListener{
//
//                val cursor = db_sqlite.rawQuery(sql_2,null)
//                cursor.run{
//                    while(moveToNext()){
//                        val RECIPE_NM_KO = cursor.getString(0)
//                        val COOKING_TIME = cursor.getString(1)
//                        Log.w("레시피_RECIPE_NM_KO : ", RECIPE_NM_KO)
//                        Log.w("레시피_COOKING_TIME : ", COOKING_TIME)
//
//                        val available_recipes_List = menu("bibimbap",RECIPE_NM_KO , COOKING_TIME)
//                        recipes_List.add(available_recipes_List)
//                        recipes_list_Adatper.notifyDataSetChanged() //리사이클러뷰 갱신
//                    }
//                }
//            }




    }
    ////////OnCreate 함수 끝/////////


    //유통기한 계산 함수

    //https://ykkdev.tistory.com/8
    private fun Cal_Date(input_enddate: String): Long {

        val dateFormat = SimpleDateFormat("yyyyMMdd")

        val endDate = dateFormat.parse(input_enddate).time
        val today = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.time.time

        val ing_editdate = (endDate - today) / (24 * 60 * 60 * 1000)

        println("식재료 남은 기간 : ${ing_editdate}")

        return ing_editdate
    }

    //Cal_Date함수에 들어가기 위해서 5 -> 05로 받음
    private fun Cal_Date_len1(input_size1_date : String):String{

        val output_size2_date : String

        if (input_size1_date.length == 1){
            output_size2_date = "0" + input_size1_date
        }
        else {
            output_size2_date = input_size1_date
        }
        return output_size2_date
    }

    //유통기한 기한별로 나누기(0~3일 : 급함, 4~7일 : 보통, 8일~ : 여유)
    private fun Cat_ing_editdate(input_ing_editdate: Long):String{

        val output_ing_editdate : String

        if (input_ing_editdate >= 0 && input_ing_editdate <= 3){ //0,1,2,3일
            output_ing_editdate = "급함"
        }
        else if (input_ing_editdate >= 4 && input_ing_editdate <= 7){//4,5,6,7일
            output_ing_editdate = "보통"
        }
        else if (input_ing_editdate >= 8){ //8일 이상
            output_ing_editdate = "여유"
        }
        else {
            output_ing_editdate = "고려 안 함"
        }

        return output_ing_editdate
    }


    //    //2차추천 체크박스 setOnCheckedChangedListener() 클래스
//    inner class CheckboxListener : CompoundButton.OnCheckedChangeListener{
//        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
//            when (buttonView?.id){
//                R.id.korea ->
//                    if (isChecked)
//                        sql_1 = sql_1 + "and info.NATION_NM in (\"한식\")"
//
//
//
//
//            }
//        }
//
//
//    }






}




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    val db = FirebaseFirestore.getInstance() //Firestore 인스턴스 선언

//    //UserSelect컬렉션(사용자 냉장고 재료 데이터)
//    var recipes_List = ArrayList<menu>() //리사이클러뷰에 들어갈 menu클라스 변수
//    val recipes_list_Adatper = RecipesListAdapter(this,recipes_List ) //리사이클러뷰 어뎁터
//    lateinit var recyclerView_recipes_list : RecyclerView //메뉴 리사이클러뷰(가로 슬라이드)
//    var user_refrigerator = arrayListOf<String>() //사용자 냉장고 재료 받기
//
//    //레시피 데이터
//    val ingredients = mutableListOf<String>() //레시피 재료 데이터 받기
//    //var recipes_ID_Recipe_ingredient = arrayListOf<String>() //Recipe_ingredient의 레시피 번호 데이터 받기
//
//    //Recipe_information컬렉션
//    var Recipe_information = arrayListOf<recipe_information>()//Recipe_information의 데이터 받기
//
//    //Recipe_ingredient컬렉션
//    var Recipe_ingredient = ArrayList<String>() //Recipe_ingredient_row의 데이터 받기
//    var Recipe_ingredient_row = ArrayList<String>()
//    var recipes_ingredient_len_list = ArrayList<String>()



//    override fun onCreate(savedInstanceState: Bundle?) {

//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//         //UserSelect 데이터 받기
//        db.collection("UserSelect") //작업할 컬렉션
//            .get() //문서 가져오기
//            .addOnSuccessListener { result_UserSelect ->
//                //성공할 경우
//
//                //firebase로부터 사용자 냉장고 재료  받기
//                user_refrigerator.clear()
//                for (document_ref in result_UserSelect){ //가져온 문서들은 result_UserSelect에 들어감
////                    Log.w("아이템", "${document.data["menuname"]}") //menuname만 읽어들어짐!!
//                    if ("menuname" in document_ref){
//                        val user_ingredients = document_ref.data["menuname"] as String
////                    println("user_ingredients : $user_ingredients") //user_ingredients 입력 잘 받아지는 거 확인,,!
//                        user_refrigerator = user_refrigerator.plus(user_ingredients) as ArrayList<String>
//                        println("user_refrigerator : $user_refrigerator") //user_refrigerator 입력 잘 받아지는 거 확인,,!
//                    }
//                }
//
//                //메뉴 1차 필터링
//
//                //Recipe_information 데이터 받기
//                db.collection("Recipe_information")
//                    .get()
//                    .addOnSuccessListener { result_Recipe_information ->
//
//                        Recipe_information.clear()
//                        //Recipe_ingredient로부터 레시피 데이터 재료 받기
//                        db.collection("Recipe_ingredient")
//                            .get()
//                            .addOnSuccessListener { result_Recipe_ingredient ->
//                                Recipe_ingredient.clear()
//
//                                for (document_info in result_Recipe_information) {
//                                    var recipes_ingredient_len = 0
//                                    for (document_ing in result_Recipe_ingredient) {
//
//                                        //Recipe_ingredient의 RECIPE_ID 와 Recipe_information의 RECIPE_ID가 같으면 재료 데이터 읽기
//                                        //위와 같은 조건문을 모두 다 읽으려면 데이터를 너무 많이 비교해야되니깐,,
//                                        //user_refrigerator에 있는 값들이 있는 레시피들만 데이터를 읽고 싶음
//
////                                        val Recipe_ingredient_row = document_ing.data.toObject(recipe_ingredient::class.java)
////                                        Log.w("Recipe_ingredient_row", "${Recipe_ingredient_row}")
////                                        Recipe_ingredient.add(Recipe_ingredient_row)
////                                        Log.w("Recipe_ingredient", "${Recipe_ingredient}")
//                                        if (document_ing.data["RECIPE_ID"].toString() == document_info.data["RECIPE_ID"].toString()) {
//                                            Log.w("레시피id_ing", "${document_ing.data["RECIPE_ID"]}")
//                                            Log.w("레시피id_info", "${document_info.data["RECIPE_ID"]}")
//                                            Log.w("레시피id_NM_info", "${document_info.data["RECIPE_NM_KO"]}")
//
//                                            recipes_ingredient_len = recipes_ingredient_len + 1
//                                        }
//                                    }
//                                    recipes_ingredient_len_list.add(recipes_ingredient_len.toString())
//                                    Log.w("레시피id_ing_재료 개수", "${recipes_ingredient_len_list}") //잘 받아짐
//                                }
//
//                                var ing_len_list_cnt = 0
//                                for (document_info in result_Recipe_information){
//                                    for (document_ing in result_Recipe_ingredient){
//                                        if (document_ing.data["RECIPE_ID"].toString() == document_info.data["RECIPE_ID"].toString()) {
//
//                                            Log.w("레시피id_ing_2", "${document_ing.data["RECIPE_ID"]}")
//                                            Log.w("레시피id_IRDNT_ing_2", "${document_ing.data["IRDNT_SN"]}")
//
//                                            Log.w("레시피id_info_2", "${document_info.data["RECIPE_ID"]}")
//                                            Log.w("레시피id_NM_info_2", "${document_info.data["RECIPE_NM_KO"]}")
//
//                                            val Recipe_ingredient_tmp = document_ing.data["IRDNT_NM"].toString() //재료 데이터 받아서
//
//                                            Recipe_ingredient_row = Recipe_ingredient_row.plus(Recipe_ingredient_tmp) as ArrayList<String> //row 변수에 추가
//                                            //(계속 중복되어서 추가된걸 이제까지 봤으니,, 중복된 값 제거(distinct())한 재료 리스트 개수가 레시피 재료 개수랑 같다면
//
//                                            if (Recipe_ingredient_row.distinct().size.toString() == recipes_ingredient_len_list[ing_len_list_cnt]){
//                                                Recipe_ingredient_row =
//                                                    Recipe_ingredient_row.distinct() as ArrayList<String> //그걸 찐 row 변수로 만들기
//                                                Log.w("레시피_Recipe_ingre_row ", "${Recipe_ingredient_row}")
//
//                                                //사용가능한 재료 개수
//                                                val available_materials = user_refrigerator.filter{it in Recipe_ingredient_row}
//                                                //한 행마다 돌아가게끔
//                                                println("available_materials : $available_materials")
//                                                println("available_materials.size : ${available_materials.size}")
//                                                println("input_ingredients : ${Recipe_ingredient_row.size}")
//                                                println("input_ingredients.size : ${Recipe_ingredient_row.size/2}")
//
//                                                //사용자가 레시피의 재료 중 50% 이상의 식자재를 가지고 있으면 추천
//                                                if (available_materials.size >= Recipe_ingredient_row.size/2){
//                                                    val available_recipes_List = menu("bibimbap", document_info.data["RECIPE_NM_KO"].toString(),document_info.data["COOKING_TIME"].toString())
//                                                    recipes_List.add(available_recipes_List)
//                                                    println("recipes_List1 : $recipes_List")
//                                                }
//                                                recipes_list_Adatper.notifyDataSetChanged() //리사이클러뷰 갱신
//
//
//
//                                                Recipe_ingredient_row = ArrayList<String>() //row 변수 초기화
//                                                ing_len_list_cnt = ing_len_list_cnt + 1
//                                                Log.w("레시피_ing_len_list_cnt ", "${ing_len_list_cnt}")
//
//                                            }
//                                        }
//                                    }
//                                }
//
//
//
//
//                            }
//                            .addOnFailureListener{ exception ->
//                                Log.w("MainActivity_Error", "Recipe_ingredient Error: $exception")
//                            }
//                    }
//                    .addOnFailureListener{exception ->
//                        Log.w("MainActivity_Error", "Recipe_information Error: $exception")
//                    }
//            }
//
//            .addOnFailureListener{exception ->
//                //실패할 경우
//                Log.w("MainActivity_Error", "UserSelect Error: $exception")
//            }
//
//        recyclerView_recipes_list = findViewById(R.id.recyclerView_recipes_list) //메뉴 리사이클러뷰
//
//        val recipes_linear_manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        recyclerView_recipes_list.layoutManager = recipes_linear_manager
//        recyclerView_recipes_list.setHasFixedSize(true)
//
//        recyclerView_recipes_list.adapter = recipes_list_Adatper

//    }