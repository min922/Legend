package com.example.map_dp

import android.content.Context
import android.location.Geocoder
import android.location.Location
import android.util.Log

class Marketlist() {
    val unionmarket = listOf("홈플러스 면목점", "이마트 상봉점", "방학동도깨비시장", "하나로클럽 양재점",
        "이마트 성수점", "서울중앙시장", "롯데백화점 잠실점", "청량리종합시장", "홈플러스 월드컵점", "홈플러스 독산점",
        "망원시장", "통인시장", "NC백화점 불광점", "롯데마트 서울역점", "송화시장", "대림시장", "현대백화점 미아점",
        "고척근린시장", "홈플러스 영등포점", "우림시장", "농협 하나로마트 용산점", "대림중앙시장", "신세계백화점", "신영시장",
        "이마트 가양점", "롯데백화점 관악점", "공릉동 도깨비시장", "상계중앙시장", "하나로클럽 미아점", "뉴코아아울렛 강남점",
        "이마트 이수점", "방이시장", "신창시장", "현대시장", "광장시장", "마천중앙시장", "이마트 여의도점", "관악신사시장(신림4동)",
        "금남시장", "수유재래시장", "농협하나로마트 신촌점", "인왕시장", "신원시장(신림1동)", "롯데백화점 노원점", "돈암제일시장",
        "동원시장", "남성시장", "둔촌역전통시장", "마포농수산물시장", "암사종합시장", "롯데백화점 미아점", "롯데백화점 영등포점",
        "남구로시장", "이마트 청계점", "롯데슈퍼", "이마트 목동점", "이마트 창동점", "홈플러스 시흥점", "화곡본동시장", "이마트 미아점",
        "홈플러스 강동점", "영천시장", "목3동시장", "숭인시장", "신세계백화점 강남점", "롯데백화점 강남점", "원당종합시장", "현대백화점 신촌점",
        "용문시장", "롯데백화점 청량리점", "NC백화점 신구로점", "청담삼익시장", "노룬산골목시장", "뚝도시장", "이마트 용산점", "세이브 마트",
        "대조시장", "롯데마트 강변점", "남대문시장", "방배종합시장", "영등포전통시장", "이마트 명일점", "홈플러스 등촌점", "이마트 역삼점",
        "남문시장", "홈플러스 잠실점", "후암시장", "이마트 신도림점", "홈플러스 동대문점", "홈플러스 목동점", "자양골목시장", "이마트 왕십리점",
        "이마트 은평점", "홈플러스 방학점", "장위골목시장", "이마트 자양점", "도곡시장", "홈플러스 중계점", "경동시장", "롯데백화점")

    data class tmp_lati_logi(
        var lati :String ="",
        var longi :String =""
    ) //상위 5개 위, 경도 저장
    var tmp_fifth = arrayListOf<tmp_lati_logi>()

    data class loca(
        var idx: Int = -1,
        var lati :String ="",
        var longi :String ="",
        var dist :Float = 0.0F
    ) //시장 위, 경도, 거리 저장할 class
    val market_loc_lati = ArrayList<loca>()

    fun marketdist(
        context: Context,
        search_lati: Double,
        search_logi: Double
    ): Pair<ArrayList<String>, ArrayList<tmp_lati_logi>> {
        val geocoder = Geocoder(context)
        var secname =""
        for(i in unionmarket.indices){
            try {
                val geo_cor = geocoder.getFromLocationName(unionmarket[i], 10)
                val item = loca()
                val cor = geo_cor.get(0)
                item.idx = i
                item.lati = cor.latitude.toString()
                item.longi = cor.longitude.toString()
                market_loc_lati.add(item)
            } catch (e: IndexOutOfBoundsException){
                if (unionmarket[i] == "신세계백화점"){
                    secname = "신세계백화점 본점"
                } //안되는거 오류처리
                else if (unionmarket[i] == "농협하나로마트 신촌점"){
                    secname = "농협하나로클럽 신촌점"
                }
                else if (unionmarket[i] == "남구로시장"){
                    secname = "남구로 시장"
                }
//                else if (unionmarket[i] == "원당종합시장"){
//                    secname = "원당 종합시장"
//                }
                else if (unionmarket[i] == "노룬산골목시장"){
                    secname = "노룬산시장"
                }
//                else if (unionmarket[i] == "롯데백화점"){
//                    secname = "롯데백화점 본점"
//                }
                try {
                    val geo_cor = geocoder.getFromLocationName(secname, 10)
                    val item = loca()
                    val cor = geo_cor.get(0)
                    item.idx = i
                    item.lati = cor.latitude.toString()
                    item.longi = cor.longitude.toString()
                    market_loc_lati.add(item)
                }catch (e: IndexOutOfBoundsException){
                    Log.d("efklanrg","${unionmarket[i]} 오류!!!")
                }
            }
        } //시장 경위도 저장

        val now_loc = Location("")
        now_loc.latitude = search_lati
        now_loc.longitude = search_logi //현위치 위, 경도

        for (i in market_loc_lati.indices){
            val tmp_loc = Location("")
            tmp_loc.latitude = market_loc_lati[i].lati.toDouble()
            tmp_loc.longitude = market_loc_lati[i].longi.toDouble()
            val tmp_dist = now_loc.distanceTo(tmp_loc)
            market_loc_lati[i].dist = tmp_dist
        }

        market_loc_lati.sortBy { it.dist }

        val result_list = ArrayList<String>()

        for (i in 0..4){
            result_list.add(unionmarket[market_loc_lati[i].idx])
            tmp_fifth.add(tmp_lati_logi(market_loc_lati[i].lati, market_loc_lati[i].longi))
        }

//        dialog.dismiss()
        return Pair(result_list, tmp_fifth)
    }
}