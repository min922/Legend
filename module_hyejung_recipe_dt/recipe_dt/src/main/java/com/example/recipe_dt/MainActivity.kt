package com.example.recipe_dt

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.ingre_main.*
import kotlinx.android.synthetic.main.recip_ingre.*


class MainActivity : AppCompatActivity() {

    //    list 만들어서 Activity에 보이는지 처음 테스트용
    var list = arrayListOf<Ingre>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ingre_main)


        val mAdapter = MyAdapter(this, list)
        recyclerView_ingre.adapter = mAdapter

        val gm = GridLayoutManager(this, 4)
        recyclerView_ingre.layoutManager = gm
        recyclerView_ingre.setHasFixedSize(true)


        ///////////////////////// SQLite 데이터 받기
        val db_sqlite = DataBaseHelper(this).readableDatabase //sql 인스턴스 선언

        // RECIPE_ID예시로 선택한다음 레시피에 들어가는 재료 받기 & 메뉴 대표 사진 받기
        val choiceingre =
            "select RECIPE_ID, IRDNT_NM from recipe_ingredient where RECIPE_ID in ('97');"
        val repremenu =
            "select RECIPE_ID, IMG_URL, RECIPE_NM_KO, NATION_NM, COOKING_TIME, QNT, LEVEL_NM from recipe_information where RECIPE_ID in ('97');"

        //////////////////////////////////////// 재료받기 ////////////////////////////////////////////////////////
        val carrot = R.drawable.icon_carrot
        val cursor = db_sqlite.rawQuery(choiceingre, null)
        val recipe_ing = arrayListOf<String>()

        cursor.run {
            while (moveToNext()) {
                val RECIPE_ID = cursor.getString(0)
                val IRDNT_NM = cursor.getString(1)
                Log.w("레시피_RECIPE_ID : ", RECIPE_ID)
                Log.w("레시피_IRDNT_NM : ", IRDNT_NM)
                recipe_ing.add(IRDNT_NM)

            }
        }


        /////////////////2.Firestore IngPhoto 데이터 받기////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        val db_firestore = FirebaseFirestore.getInstance() //Firestore 인스턴스 선언
//        var ingPhoto_info = arrayListOf<Ingre>()
//        var templist = arrayListOf<Ingre>()

        //IngPhoto 데이터 받기
        db_firestore.collection("IngPhoto") //작업할 컬렉션
            .get() //문서 가져오기
            .addOnSuccessListener { result_IngPhoto -> //성공할 경우

//                    기존 배열리스트가 존재하지 않게 초기화
                list.clear()

                var IngId = "0"

                for (i in recipe_ing) {
                    var IngName = i
                    var IngPhoto = "ingbas"
                    var ingPhoto_list = Ingre(IngPhoto, IngName, IngId)

                    for (document_ing in result_IngPhoto) {
                        Log.w("test_for문", i)

                        if (i == document_ing.data["menuname"]) {
                            Log.w("test_들어왔니..?", i)
                            IngPhoto = document_ing.data["photo"] as String
                            Log.w("test_photo", IngPhoto)
                            IngId = document_ing.data["id"] as String
                            ingPhoto_list = Ingre(IngPhoto, IngName, IngId)
                        }
                    }
                    list.add(ingPhoto_list)
                }
                mAdapter.notifyDataSetChanged()
            }


        /////////////intent 이용해서 레시피 상세페이지로 이동
        val intent = Intent(this, RecipeActivity::class.java)

        //버튼 지정
        val buttonView = findViewById<Button>(R.id.viewmove)
        //클릭리스너
        buttonView.setOnClickListener {
            //액티비티 이동
            startActivity(intent)
        }

/////////////////////////////////////////////  메뉴 대표 사진 받기  //////////////////////////////////////////////////////
        val menuImage = findViewById<ImageView>(R.id.menuImage)
        val defaultImage = R.drawable.icon_carrot
        val errorImage = R.drawable.icon_bacon
        val fallimage = R.drawable.icon_cabbage

        val cursor2 = db_sqlite.rawQuery(repremenu, null)
        cursor2.run {
            while (moveToNext()) {
                val RECIPE_ID = cursor2.getString(0)
                val IMG_URL = cursor2.getString(1)
                val RECIPE_NM_KO = cursor2.getString(2)
                val NATION_NM = cursor2.getString(3)
                val COOKING_TIME = cursor2.getString(4)
                val QNT = cursor2.getString(5)
                val LEVEL_NM = cursor2.getString(6)

                Log.w("레시피_RECIPE_ID : ", RECIPE_ID)
                Log.w("레시피_IMG_URL : ", IMG_URL)
                Log.w("레시피_RECIPE_NM_KO : ", RECIPE_NM_KO)

                menuName.text = RECIPE_NM_KO
                country.text = NATION_NM
                time.text = COOKING_TIME
                level.text = LEVEL_NM
                people.text = QNT

                ///대표 메뉴 사진 (이 부분 url이 오류였는데 http url 허용 범위 설정 해주니까 실행 됨)
                Glide.with(this@MainActivity)
                    .load(IMG_URL)
                    .placeholder(defaultImage)  //이미지 로딩 시작하기 전 표시할 이미지
                    .error(errorImage)     // 로딩 에러 발생 시 보여줄 이미지
                    .fallback(fallimage)   //로드할 url(이미지)이 비어있으면 나오는 이미지
                    .into(menuImage)    //이미지를 넣을 뷰


            }
        }   //메뉴받기 끝


        //////////////////////////////북마크 기능(별 클릭시 별 UI가 바뀌면서 파이어스토어에서 RECIPE_ID 삭제)
        val starbutton = findViewById<ImageButton>(R.id.starbutton)

        var receiveId: String

        db_firestore.collection("UserBookmark")
            .get()
            .addOnSuccessListener { result ->
                for (id in result) {
                    if (id.data["RECIPE_ID"].toString() != "") {
                        receiveId = id.data["RECIPE_ID"].toString()
                        println("id : ${receiveId}")

                        val sql =
                            "SELECT info.RECIPE_ID, info.IMG_URL, info.RECIPE_NM_KO, info.COOKING_TIME\n" +
                                    "FROM recipe_information info\n" +
                                    "WHERE info.RECIPE_ID in ('97')"


                        val bookmarkImg = findViewById<ImageView>(R.id.menuImage)
                        val foodName = findViewById<TextView>(R.id.menuName)
                        val foodTime = findViewById<TextView>(R.id.time)

                        val cursor = db_sqlite.rawQuery(sql, null)
                        cursor.run {
                            while (moveToNext()) {
                                val RECIPE_ID = cursor.getString(0)
                                val IMG_URL = cursor.getString(1)
                                val RECIPE_NM_KO = cursor.getString(2)
                                val COOKING_TIME = cursor.getString(3)


                                Log.w("레시피_RECIPE_ID : ", RECIPE_ID)
                                Log.w("레시피_IMG_URL : ", IMG_URL)
                                Log.w("레시피_RECIPE_NM_KO : ", RECIPE_NM_KO)
                                Log.w("레시피_COOKING_TIME : ", COOKING_TIME)



                                starbutton.setOnClickListener(View.OnClickListener {
                                    Toast.makeText(
                                        this@MainActivity,
                                        "Toast Start",
                                        Toast.LENGTH_LONG
                                    ).show()
                                    starbutton?.isSelected =
                                        starbutton?.isSelected != true //북마크 별 클릭시 모양 변환


                                    if (starbutton?.isSelected == true) {
                                        Log.w("dkdk_11", RECIPE_ID)

                                        //북마크 클릭 시 파이어스토어 "UserBookmark" 컬렉션에 레시피 id 삭제함
                                        val recipes_id_star = foodId?.text.toString()//파이어스토어에 올릴 값

                                        db_firestore.collection("UserBookmark")
                                            .get()
                                            .addOnSuccessListener { bookmark_id ->
                                                for (document_id in bookmark_id) {
                                                    Log.w("dkdk_222555", RECIPE_ID)
                                                    Log.w("document_id", document_id.data["RECIPE_ID"].toString())
                                                    if (RECIPE_ID in document_id.data["RECIPE_ID"].toString() && RECIPE_ID == document_id.data["RECIPE_ID"].toString()) {
                                                        Log.w("dkdk3333", RECIPE_ID)
                                                        var edit_bookmark =
                                                            document_id.id //파이어스토어 문서 ID명
                                                        db_firestore.collection("UserBookmark")
                                                            .document(edit_bookmark).delete()
                                                    }
                                                }
                                                Toast.makeText(
                                                    this@MainActivity,
                                                    "북마크에서 해제되었습니다:)",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }
                                            .addOnFailureListener {
                                                Toast.makeText(
                                                    this@MainActivity,
                                                    ":(",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }
                                    }
//                                    else {
//                                        val recipes_id_star = foodId?.text.toString()
//                                        val star_menu_id =
//                                            hashMapOf("RECIPE_ID" to recipes_id_star) //파이어스토어에 올리기
//
//                                        db_firestore.collection("UserBookmark")
//                                            .add(star_menu_id)
//                                            .addOnSuccessListener {
//                                                Toast.makeText(
//                                                    this@MainActivity,
//                                                    "북마크에 추가되었습니다:)",
//                                                    Toast.LENGTH_SHORT
//                                                ).show()
//                                            }
//                                            .addOnFailureListener {
//                                                Toast.makeText(
//                                                    this@MainActivity,
//                                                    ":(",
//                                                    Toast.LENGTH_SHORT
//                                                ).show()
//                                            }
//                                    }


                                })

                            }
                        }
                    }
                }
            }
    }
}











