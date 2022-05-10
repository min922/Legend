package com.example.recipe_dt

data class Model (val type:Int, val text: String, val data: Int, val contentString: String?) {
    companion object {
        const val RECIP_INGRE = 0
        const val REP_MENU = 1
        const val EXPLAIN_RECIPE = 2
    }
}
