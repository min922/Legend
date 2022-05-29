package com.example.recipe_dt

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
//    var list = arrayListOf<Ingre>() //상세레시피 재료 리스트

//    list 만들어서 Activity에 보이는지 처음 테스트용
    val list = arrayListOf<Ingre>(
    Ingre("vegetable", "실파"),
    Ingre("fish", "굴"),
    Ingre("fish", "홍합"),
    Ingre("fish", "조갯살"),
    Ingre("rice", "밀가루"),
    Ingre("milk", "계란"),
    Ingre("oil", "식용유"),
    Ingre("salt", "소금"),
    Ingre("rice", "멥쌀"),

    )



        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val starbutton = findViewById<ImageButton>(R.id.starbutton)

            starbutton.setOnClickListener(View.OnClickListener {
                Toast.makeText(this, "Toast Start", Toast.LENGTH_LONG).show()

            })





            //////////STEP1. Firestore 사용자 데이터 받기///////////////////////////////////////////////////////////
            val db_firestore = FirebaseFirestore.getInstance() //Firestore 인스턴스 선언

            //UserSelect컬렉션(사용자 냉장고 재료 데이터)
            var user_refrigerator_name = ArrayList<Ingre>() //사용자 냉장고 재료 이름

            //UserSelect 데이터 받기
            db_firestore.collection("UserSelect") //작업할 컬렉션
                .get() //문서 가져오기
                .addOnSuccessListener { result_UserSelect -> //성공할 경우

                    //Step1. 식재료 유통기한 & 이름 받기
                    for (document_ref in result_UserSelect) {

                        //user_refrigerator_name 채우기(id & 재료 이름)
                        if ("menuname" in document_ref) {
                            val user_refrigerator_name_list =
                                Ingre("icon_ricecake", document_ref.data["menuname"].toString())
                            user_refrigerator_name.add(user_refrigerator_name_list)
                        }


                        println("user_refrigerator_name.size : ${user_refrigerator_name.size}")
                        //println("user_refrigerator_name : ${user_refrigerator_name}")

                    for (ing_cnt : Int in 0..user_refrigerator_name.size-1){
                        println("user_refrigerator_name : ${user_refrigerator_name[ing_cnt].photo}")

                    }
                        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                        //intent 이용해서 레시피 상세페이지로 이동
                        val intent = Intent(this, RecipeActivity::class.java)

                        //버튼 지정
                        val buttonView = findViewById<Button>(R.id.viewmove)
                        //클릭리스너
                        buttonView.setOnClickListener {
                            //액티비티 이동
                            startActivity(intent)
                        }

                        val mAdapter = MyAdapter(this, list)
                        recyclerView_ingre.adapter = mAdapter

                        val gm = GridLayoutManager(this, 3)
                        recyclerView_ingre.layoutManager = gm
                        recyclerView_ingre.setHasFixedSize(true)


                        ////////////////// SQLite 데이터 받기
                        val db_sqlite = DataBaseHelper(this).readableDatabase //sql 인스턴스 선언

                        // RECIPE_ID예시로 선택한다음 레시피에 들어가는 재료 받기 & 메뉴 대표 사진 받기
                        val choiceingre =
                            "select RECIPE_ID, IRDNT_NM from recipe_ingredient where RECIPE_ID in ('94');"
                        val repremenu =
                            "select RECIPE_ID, IMG_URL, RECIPE_NM_KO, NATION_NM, COOKING_TIME, QNT, LEVEL_NM from recipe_information where RECIPE_ID in ('94');"

                        //재료받기
                        val carrot = R.drawable.icon_carrot
                        val cursor = db_sqlite.rawQuery(choiceingre, null)
                        cursor.run {
                            while (moveToNext()) {
                                val RECIPE_ID = cursor.getString(0)
                                val IRDNT_NM = cursor.getString(1)
                                Log.w("레시피_RECIPE_ID : ", RECIPE_ID)
                                Log.w("레시피_IRDNT_NM : ", IRDNT_NM)

                                // Log 제대로 찍힘 but 추가한 이미지 재료가 안 보임
//                                when ("청피망") {
//                                    in IRDNT_NM -> {
//                                        Log.w("피망있다아아악", IRDNT_NM)
//
//                                        val available_list = Ingre("tteokbokki", "떡볶이")
//                                        list.add(available_list)
//
////                                        list.add(Ingre(R.drawable.icon_carrot.toString()))
////                                        list.add(Ingre(R.drawable.icon_carrot.toString()))
////                                        mAdapter.notifyDataSetChanged() //리사이클러뷰 갱신
//                                    }
//                                    else -> {
//                                        Log.w("피망없다", IRDNT_NM)
//
//                                        list.add(Ingre(R.drawable.icon_cabbage.toString(), "양배추"))
//                                    }
//                                }
                                mAdapter.notifyDataSetChanged() //리사이클러뷰 갱신
                            }
                        }


//        메뉴 대표 사진 받기
                        val menuImage = findViewById<ImageView>(R.id.menuImage)
                        val defaultImage = R.drawable.icon_carrot
                        val errorImage = R.drawable.icon_bacon
                        val fallimage = R.drawable.icon_cabbage
//        val url = "http://file.okdab.com/UserFiles/searching/recipe/001800.jpg"
//        val url = "https://www.wholesomeyum.com/wp-content/uploads/2017/03/wholesomeyum-Low-Carb-Keto-Pancakes-Recipe-21.jpg"

//
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

//                mAdapter.notifyDataSetChanged() //리사이클러뷰 갱신



                            }
                        }
                    }
                }
        }

}






