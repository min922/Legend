package com.example.map_dp

class DataClass{
    data class market(
        val ListNecessariesPricesService: ListNecessariesPricesService
    )

    data class ListNecessariesPricesService(
        val RESULT: RESULT,
        val list_total_count: Int, //총 데이터건수
        val row: List<Row>
    )

    data class RESULT(
        val CODE: String,
        val MESSAGE: String
    )

    data class Row(
        val ADD_COL: String,
        val A_NAME: String, //품목이름
        val A_PRICE: String, //가격
        val A_SEQ: Double,
        val A_UNIT: String, //단위
        val M_GU_CODE: String,
        val M_GU_NAME: String, //자치구 이름
        val M_NAME: String, //식료품점 이름
        val M_SEQ: Double,
        val M_TYPE_CODE: String,
        val M_TYPE_NAME: String,
        val P_DATE: String, //점검일자
        val P_SEQ: Double,
        val P_YEAR_MONTH: String //년-월
    )
}