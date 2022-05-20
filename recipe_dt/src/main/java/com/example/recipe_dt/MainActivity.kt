package com.example.recipe_dt

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
//    val list = arrayListOf<Ingre>() //상세레시피 재료 리스트

//    list 만들어서 Activity에 보이는지 처음 테스트용
    val list = arrayListOf<Ingre>(
        Ingre("icon_ricecake"),
        Ingre("icon_onion"),
        Ingre("icon_carrot"),
        Ingre("icon_cabbage"),
        Ingre("icon_bacon"),
        Ingre("icon_ricecake"),
        Ingre("icon_onion"),
        Ingre("icon_carrot"),
        Ingre("icon_cabbage"),
        Ingre("icon_bacon"),
        Ingre("icon_bacon"),
        Ingre("icon_ricecake"),
        Ingre("icon_onion"),
        Ingre("icon_carrot"),
        Ingre("icon_cabbage"),
        Ingre("icon_bacon"),
        Ingre("icon_bacon"),
        Ingre("icon_ricecake"),
        Ingre("icon_onion"),
        Ingre("icon_carrot"),
        Ingre("icon_cabbage"),
        Ingre("icon_bacon"),

    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
            "select RECIPE_ID, IRDNT_NM from recipe_ingredient where RECIPE_ID in ('9');"
        val repremenu =
            "select RECIPE_ID, IMG_URL from recipe_information where RECIPE_ID in ('9');"

        //재료받기
        val cursor = db_sqlite.rawQuery(choiceingre, null)
        cursor.run {
            while (moveToNext()) {
                val RECIPE_ID = cursor.getString(0)
                val IRDNT_NM = cursor.getString(1)
                Log.w("레시피_RECIPE_ID : ", RECIPE_ID)
                Log.w("레시피_IRDNT_NM : ", IRDNT_NM)


                ///레시피에 들어가는 재료에 따라 해당 이미지 icon을 받아야 함
//                val available_list = Ingre("tteokbokki")
//                list.add(available_list)
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
                Log.w("레시피_RECIPE_ID : ", RECIPE_ID)
                Log.w("레시피_IMG_URL : ", IMG_URL)

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







