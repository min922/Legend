package com.example.map_dp

import android.location.Location

class Marketlist {
    //btn_input에 사용자가 누른 재료버튼의 이름을 메인페이지에서 받아서 입력 받고 경도위도도 입력받기
    lateinit var location2 : Location
    lateinit var location3 : Location
    var btn_input = "-"

    fun marketlist(btn_input: String, latitude: Double, longitude: Double){
        location2.latitude = 37.56553
        location2.longitude = 126.97801
        location3.latitude = 37.66166
        location3.longitude = 126.27801


    }
}