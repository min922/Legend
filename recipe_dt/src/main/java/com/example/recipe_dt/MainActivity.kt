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
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recip_ingre.*


class MainActivity : AppCompatActivity() {
//    var list = arrayListOf<Ingre>() //상세레시피 재료 리스트

    //    list 만들어서 Activity에 보이는지 처음 테스트용
    val list = arrayListOf<Ingre>()
//    Ingre("vegetable", "실파", "id"),
//    Ingre("fish", "굴", "id"),
//    Ingre("fish", "홍합", "id"),
//    Ingre("fish", "조갯살", "id"),
//    Ingre("rice", "밀가루", "id"),
//    Ingre("milk", "계란", "id"),
//    Ingre("oil", "식용유", "id"),
//    Ingre("salt", "소금", "id"),
//    Ingre("rice", "멥쌀", "id"),
//
//    )

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
                            Ingre(
                                document_ref.data["photo"].toString(),
                                document_ref.data["menuname"].toString(),
                                document_ref.data["id"].toString(),
//                                document_ref.data["display"].toString()
                            )
                        user_refrigerator_name.add(user_refrigerator_name_list)
                    }

                    println("user_refrigerator_name.size : ${user_refrigerator_name.size}")
                    //println("user_refrigerator_name : ${user_refrigerator_name}")

                    for (ing_cnt: Int in 0..user_refrigerator_name.size - 1) {
                        println("user_refrigerator_name : ${user_refrigerator_name[ing_cnt].photo}")
                    }
                    /////////2.Firestore IngPhoto 데이터 받기////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                    var ingPhoto_info = arrayListOf<Ingre>()

                    //IngPhoto 데이터 받기
                    db_firestore.collection("IngPhoto") //작업할 컬렉션
                        .get() //문서 가져오기
                        .addOnSuccessListener { result_IngPhoto -> //성공할 경우

//                    기존 배열리스트가 존재하지 않게 초기화
                            ingPhoto_info.clear()

                            for (document_ing in result_IngPhoto) {

//                        photo, menuname 받기
                                if ("menuname" in document_ing) {
                                    val IngPhoto = document_ing.data["photo"] as String
                                    val IngName = document_ing.data["menuname"] as String
                                    val IngId = document_ing.data["id"] as String
//                                    val IngDis = document_ing.data["display"] as String

                                    val ingPhoto_list =
                                        Ingre(IngPhoto, IngName, IngId)
                                    ingPhoto_info.add(ingPhoto_list)
                                }
                            }
                            ///데이터 받기 성공 & 로그 찍어보기 테스트. 배열 3번째 photo:milk, name: 슈레드치즈(모짜렐라치즈) 확인
//                            println("ingPhoto_info.size: ${ingPhoto_info.size}")
//                            println("ingPhoto_info_photo, ingPhoto_info_name: ${ingPhoto_info[3].photo} + ${ingPhoto_info[3].name}")
//                    println("ingPhoto_info_name: ${ingPhoto_info[3].name}")
                            for (ing_cnt2: Int in 0..ingPhoto_info.size - 1) {
                                println("ingPhoto_info : ${ingPhoto_info[ing_cnt2].photo}, ${ingPhoto_info[ing_cnt2].name}, " +
                                        "${ingPhoto_info[ing_cnt2].id}")
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


                            val mAdapter = MyAdapter(this, list)
                            recyclerView_ingre.adapter = mAdapter

                            val gm = GridLayoutManager(this, 3)
                            recyclerView_ingre.layoutManager = gm
                            recyclerView_ingre.setHasFixedSize(true)


                            ///////////////////////// SQLite 데이터 받기
                            val db_sqlite = DataBaseHelper(this).readableDatabase //sql 인스턴스 선언

                            // RECIPE_ID예시로 선택한다음 레시피에 들어가는 재료 받기 & 메뉴 대표 사진 받기
                            val choiceingre =
                                "select RECIPE_ID, IRDNT_NM from recipe_ingredient where RECIPE_ID in ('3');"
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


                                    ////여기 추가되면서 Main이랑 adapter 오류나고 튕김 -> MyAdapter에서 북마크 기능 지우니까 해결됨
                                    for (ing_photo: Int in 0..ingPhoto_info.size - 1) {
                                        //전체 IngPhoto 재료 리스트 받아지는지 출력 확인용
//                                        println("ingPhoto_info : ${ingPhoto_info[ing_photo].photo}, ${ingPhoto_info[ing_photo].name}, ${ingPhoto_info[ing_photo].id}")
                                        val photo = ingPhoto_info[ing_photo].photo
                                        var name = ingPhoto_info[ing_photo].name
                                        val etcPhoto = "icon_rice"


                                            if (IRDNT_NM in name && IRDNT_NM == name) {
                                                var available_print_list =
                                                    Ingre(photo, IRDNT_NM, RECIPE_ID)
                                                list.add(available_print_list)
                                            } else if (IRDNT_NM != name) {
                                                continue
                                            }
//                                            } else if (IRDNT_NM in name && IRDNT_NM != name) {
//                                                continue
//                                            } else {
//                                                val available_print_list =
//                                                    Ingre(etcPhoto, IRDNT_NM, RECIPE_ID)
//                                                list.add(available_print_list)
//                                            }

                                        println("ingPhoto_info : ${ingPhoto_info[ing_photo].photo}, ${ingPhoto_info[ing_photo].name}, ${ingPhoto_info[ing_photo].id}")
                                    }
                                    ///// 여기까지이이이


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

                                }  //UserSelect 끝나는 지점
                            }
                        }
                }
            }
    }
}










