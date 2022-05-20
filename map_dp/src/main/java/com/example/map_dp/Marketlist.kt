package com.example.map_dp

import android.location.Location


class Marketlist {
    //btn_input에 사용자가 누른 재료버튼의 이름을 메인페이지에서 받아서 입력 받고 검색 원하는 위치의 경도위도도 입력받기
    var btn_input = "-"

    fun marketdist(
        main_list: ArrayList<MapsActivity.loca>,
        search_lati: Double,
        search_logi: Double
    ): ArrayList<MapsActivity.loca> {
        val now_loc = Location("")
        now_loc.latitude = search_lati
        now_loc.longitude = search_logi

        for (i in main_list.indices){
            if(main_list[i].name != "0"){
                val tmp_loc = Location("")
                tmp_loc.latitude = main_list[i].lati.toDouble()
                tmp_loc.longitude = main_list[i].longi.toDouble()
                val tmp_dist = now_loc.distanceTo(tmp_loc) / 1000 //km로 변환
                main_list[i].dist = tmp_dist
            }
        }

        main_list.sortBy { it.dist }
        return main_list
    }
}
