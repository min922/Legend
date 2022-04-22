package com.example.show_recipes

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance() //Firestore 인스턴스 선언

    var recipes_List = arrayListOf<menu>(    //리사이클러뷰에 들어갈 메뉴 클래스 recipes_List
    )

    lateinit var recyclerView_recipes_list : RecyclerView //메뉴 리사이클러뷰(가로 슬라이드)

    var user_refrigerator = arrayListOf<String>() //괄호 안에 냉장고 재료 받기
    val ingredients = mutableListOf<String>("국수" , "소면", "사과", "청포묵")

//    val ingredients1 = mutableListOf<String>("쌀" , "안심", "콩나물", "청포묵", "미나리", "소금")
//    val ingredients2 = mutableListOf<String>("찹쌀" , "수수", "차조", "소금", "콩", "팥")
//    val ingredients4 = mutableListOf<String>("호박" , "당근", "쌀")
//        val ingredients3 = mutableListOf<String>("당면" , "쌀", "돼지고기", "소금")
//        val ingredients5 = mutableListOf<String>("파" , "마늘", "호박", "콩나물")

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView_recipes_list = findViewById(R.id.recyclerView_recipes_list) //메뉴 리사이클러뷰

        val recipes_list_Adatper = RecipesListAdapter(this,recipes_List )
        recyclerView_recipes_list.adapter = recipes_list_Adatper

        val recipes_linear_manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView_recipes_list.layoutManager = recipes_linear_manager
        recyclerView_recipes_list.setHasFixedSize(true)


        firestore_data_read() //데이터 읽고 메뉴 1차 필터링
    }


    private fun firestore_data_read(){
        db.collection("UserSelect") //작업할 컬렉션
            .get() //문서 가져오기
            .addOnSuccessListener { result ->
                //성공할 경우
                user_refrigerator.clear()
                for (document in result){ //가져온 문서들은 result에 들어감
                    //Log.w("아이템", "${document.data["menuname"]}") //menuname만 읽어들어짐!!
                    val user_ingredients = document.data["menuname"] as String
                    // println("user_ingredients : $user_ingredients") //user_ingredients 입력 잘 받아지는 거 확인,,!
                    user_refrigerator = user_refrigerator.plus(user_ingredients) as ArrayList<String>
                    //println("user_refrigerator : $user_refrigerator") //user_refrigerator 입력 잘 받아지는 거 확인,,!
                }
                filter_menu(user_refrigerator, ingredients) //메뉴 1차 필터링
            } //success 바깥으로 나올 경우 user_refrigerator 안에 받아놓은 재료들이 다 사라져서 함수를 사용 못함 -> 위 문장에서 함수 호출함!
            .addOnFailureListener{exception ->
                //실패할 경우
                Log.w("MainActivity_Error", "Error getting documents: $exception")
            }

    }


    private fun filter_menu(input_user_refrigerator: ArrayList<String>, input_ingredients:MutableList<String>) {

//        println("****************함수 들어왔당*****************")
//        println("input_user_refrigerator : $input_user_refrigerator")
//        println("input_ingredients : $input_ingredients")

        //Algorithm. while문으로 레시피 처음부터 끝까지 훑기

        //Problem. available_materials 변수에 user_refrigerator가 안 받아와짐 -> db문 안에 넣어서 해결 완료
        val available_materials = input_user_refrigerator.filter{it in ingredients}
//        val available_menu_id :String //id에 맞는 레시피 이미지, 이름, 시간 "recipe_information"파일에서 찾기

        println("available_materials : $available_materials")
        println("available_materials.size : ${available_materials.size}")
        println("input_ingredients : ${input_ingredients.size}")
        println("input_ingredients : ${input_ingredients.size/2}")

        if (available_materials.size >= input_ingredients.size/2){
            recipes_List = recipes_List.plus(menu("bibimbap", "비빔밥","1시간")) as ArrayList<menu>
            //recipes_List.add(menu("bibimbap", "비빔밥","1시간"))

            //Problem. recipes_List : [com.example.show_recipes.menu@78efa3b] 이런 식으로 출력이 된다,, 왜지,,ㅠ
            println("recipes_List : $recipes_List")
        }
    }
//        val available_materials1 = user_refrigerator.filter{it in ingredients1}
//        val available_materials2 = user_refrigerator.filter{it in ingredients2}
//        val available_materials4 = user_refrigerator.filter{it in ingredients4}

//        if (available_materials1.size >= ingredients1.size/2){
//            recipes_List.add(menu("bibimbap", "비빔밥","1시간"))
//        }
//        if (available_materials2.size >= ingredients2.size/2){
//            recipes_List.add(menu("bulgogi", "불고기","1시간"))
//        }
//        if (available_materials4.size >= ingredients4.size/2){
//            recipes_List.add(menu("japchae", "잡채","1시간 반"))
//        }
//    }
}