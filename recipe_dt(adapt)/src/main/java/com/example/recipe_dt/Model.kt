package com.example.recipe_dt

data class Model (val type:Int, val text: String, val data: Int, val contentString: String?) {
    companion object {
        const val REP_MENU: Int = 0
        const val RECIP_INGRE: Int = 1
        const val EXPLAIN_RECIPE: Int = 2
//        const val EXPLAIN_RECIPE: Int = R.layout.explain_recipe
    }
}