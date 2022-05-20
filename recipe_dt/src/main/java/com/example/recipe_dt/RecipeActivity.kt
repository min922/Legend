package com.example.recipe_dt

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.recipe_main.*

class RecipeActivity : AppCompatActivity() {
    val explainlist = arrayListOf<Recipe>() //상세레시피 사진,설명 리스트


//    @SuppressLint("LongLogTag")
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_main)


        //화면꺼짐방지
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

//        val backBtn = findViewById<Button>(R.id.moveBack)
//        //버튼 클릭시 상세페이지에서 다시 원래 화면으로 돌아감
//        backBtn.setOnClickListener {
//            finish()
//        }

        val rAdapter = RecipeAdapter(this, explainlist)
        recyclerView_explain.adapter = rAdapter

        val gm = GridLayoutManager(this, 1)
        recyclerView_explain.layoutManager = gm
        recyclerView_explain.setHasFixedSize(true)

        ////////////////// SQLite 데이터 받기
        val db_sqlite = DataBaseHelper(this).readableDatabase //sql 인스턴스 선언

        // 1차 추천으로 나온 메뉴 + 해당 메뉴 상세레시피 (RECIPE_ID로 예시 몇개 뽑아서 테스트 중)
        val filtermenu = "select RECIPE_ID, COOKING_DC, stre_step_image_url from recipe_description where RECIPE_ID in ('3');"
//    select RECIPE_ID, COOKING_DC, stre_step_image_url from recipe_description where RECIPE_ID in ('9');

//        "select RECIPE_ID, COOKING_DC from recipe_description where RECIPE_ID in ('4', '9');"

        val courseImg = findViewById<ImageView>(R.id.courseImg)
        val defaultImage = R.drawable.icon_carrot
        val errorImage = R.drawable.icon_bacon
        val fallimage = R.drawable.icon_cabbage
        val url = "https://cdn-icons-png.flaticon.com/512/649/649395.png"

        val cursor = db_sqlite.rawQuery(filtermenu, null)
        cursor.run{
            while(moveToNext()) {
                val RECIPE_ID = cursor.getString(0)
                val COOKING_DC = cursor.getString(1)
//                val stre_step_image_url = cursor.getString(2)
                var stre_step_image_url :String
               if (cursor.getString(2) != null ){
                    stre_step_image_url = cursor.getString(2)
                }
                else{
                    stre_step_image_url = url
                }



                Log.w("레시피_RECIPE_ID : ", RECIPE_ID)
                Log.w("레시피_COOKING_DC : ", COOKING_DC)
//                Log.w("레시피_image_url : ", stre_step_image_url)


                val available_explain = Recipe(stre_step_image_url, COOKING_DC, RECIPE_ID)
                explainlist.add(available_explain)

//                Glide.with(this@RecipeActivity)
//                    .load("tteokbokki")
//                    .placeholder(defaultImage)  //이미지 로딩 시작하기 전 표시할 이미지
//                    .error(errorImage)     // 로딩 에러 발생 시 보여줄 이미지
//                    .fallback(fallimage)   //로드할 url(이미지)이 비어있으면 나오는 이미지
//                    .into(courseImg)


                rAdapter.notifyDataSetChanged() //리사이클러뷰 갱신

            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId){
            android.R.id.home -> {
                finish()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

}