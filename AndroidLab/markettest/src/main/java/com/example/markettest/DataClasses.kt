package com.example.markettest

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
        val EXAMIN_NM: String,

        val STD_PRDLST_NM: String,

        val EXAMIN_PRDLST_CODE: String,

        val EXAMIN_PRDLST_NM: String,

        val STD_UNIT_NM: String?,

        val EXAMIN_UNIT_NM: String,

        val TODAY_PRIC: Int,

        val BFRT_PRIC: Int,

        val AREA_NM: String,

        val STD_MRKT_NM:String,

        val EXAMIN_MRKT_NM: String,
    )
}