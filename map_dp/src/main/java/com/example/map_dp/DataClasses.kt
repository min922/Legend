package com.example.map_dp

import com.google.gson.annotations.SerializedName

class DataClasses {
    data class MarketInfo(
        @SerializedName("Grid_20151128000000000315_1")
        val wrap: Set
    )

    data class Set (
        val totalCnt: Int,
        val startRow: Int,
        val endRow: Int,
        val result: Result,
        val row: List<Row>
    )

    data class Result (
        val code: String,
        val message: String
    )

    data class Row (
        val ROW_NUM:String,

        val EXAMIN_DE:String, //조사일자

        val EXAMIN_NM: String, //조사이름(소비자가격...)

        val STD_PRDLST_NM: String, //표준품목명(건가공류)

        val EXAMIN_PRDLST_CODE: String, //조사가격품목코드

        val EXAMIN_PRDLST_NM: String, //조사가격품목명(오징어포)

        val STD_UNIT_NM: String?, //표준단위명(마리)

        val EXAMIN_UNIT_NM: String, //조사단위명(10마리)

        val TODAY_PRIC: Int, //당일조사가격

        val BFRT_PRIC: Int, //전일조사가격

        val AREA_NM: String, //조사지역명(서울서부)

        val STD_MRKT_NM:String, //표준시장명 (경동시장)

        val EXAMIN_MRKT_NM: String, //조사가격시장명(A-유통...)
    )
}