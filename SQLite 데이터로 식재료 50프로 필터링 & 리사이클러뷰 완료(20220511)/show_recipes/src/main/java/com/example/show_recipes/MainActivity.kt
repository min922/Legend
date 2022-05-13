package com.example.show_recipes

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore


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

//////////Firestore 사용자 데이터 받기///////////////////////////////////////////////////////////
        val db_firestore = FirebaseFirestore.getInstance() //Firestore 인스턴스 선언


        //UserSelect컬렉션(사용자 냉장고 재료 데이터)
        var user_refrigerator = arrayListOf<String>() //사용자 냉장고 재료 받기
         //UserSelect 데이터 받기
        db_firestore.collection("UserSelect") //작업할 컬렉션
            .get() //문서 가져오기
            .addOnSuccessListener { result_UserSelect ->
                //성공할 경우

                //firebase로부터 사용자 냉장고 재료  받기
                user_refrigerator.clear()
                for (document_ref in result_UserSelect){ //가져온 문서들은 result_UserSelect에 들어감

                    if ("menuname" in document_ref){
                        val user_ingredients = document_ref.data["menuname"] as String
                        user_refrigerator = user_refrigerator.plus(user_ingredients) as ArrayList<String>
                        println("user_refrigerator : $user_refrigerator") //user_refrigerator 입력 잘 받아지는 거 확인,,!
                    }
                }
            }
            .addOnFailureListener{exception ->
                //실패할 경우
                Log.w("MainActivity_Error", "UserSelect Error: $exception")
            }
////////////////////////////////////////////////////////////////////////////////////////////////////////
/////firestore에서 읽은 데이터들을 쿼리문에서 사용하려면 얘네들을 sqlite insert문을 이용해 데베에 집어넣어야하는쥐,,,
        ///찾아본걸론 firestore에서 실시간으로 데이터를 받을 수 있는 방법은 없어보임(특정 시간?에 한번씩 업로드해서 하는 BIGQUERY?는 있던 것,,같,,


//////////SQLite 레시피 데이터//////////////////////////////////////////////////////////////////////////
        //뭐가 묶여서 출력되는데 이유를 모르겠움~~
        val db = DataBaseHelper(this).readableDatabase //sql 인스턴스 선언

        val sql = "SELECT info.RECIPE_NM_KO, info.COOKING_TIME\n" +
                "FROM recipe_information info,\n" +
                "(SELECT ing.RECIPE_ID, count(ing.IRDNT_NM) AS RECIPE_ING_COUNT ,\n" +
                "count(CASE WHEN ing.IRDNT_NM in (\"호박\", \"당근\", \"부추\", \"진간장\", \"참기름\", \"소금\", \"밥\", \"통후추\")THEN 1 END) AS ABLE_ING_COUNT\n" +
                "FROM recipe_ingredient ing\n" +
                "GROUP BY ing.RECIPE_ID\n" +
                "ORDER BY count(ing.IRDNT_NM)) user\n" +
                "WHERE user.RECIPE_ID=info.RECIPE_ID and user.ABLE_ING_COUNT >= (user.RECIPE_ING_COUNT)*0.5\n"



        val cursor = db.rawQuery(sql,null)
        cursor.run{
            while(moveToNext()){
                val RECIPE_NM_KO = cursor.getString(0)
                val COOKING_TIME = cursor.getString(1)
                Log.w("레시피_RECIPE_NM_KO : ", RECIPE_NM_KO)
                Log.w("레시피_COOKING_TIME : ", COOKING_TIME)

                val available_recipes_List = menu("bibimbap",RECIPE_NM_KO , COOKING_TIME)
                recipes_List.add(available_recipes_List)
                recipes_list_Adatper.notifyDataSetChanged() //리사이클러뷰 갱신
            }
        }
        db.close()
    }
}


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
