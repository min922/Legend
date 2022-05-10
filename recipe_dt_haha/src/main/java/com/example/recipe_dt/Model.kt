package com.example.recipe_dt

data class Model (val type:Int, val text: String, val data: Int, val contentString: String?) {
    companion object {
        const val RECIP_INGRE: Int = R.layout.recip_ingre
        const val REP_MENU: Int = R.layout.activity_main
        const val EXPLAIN_RECIPE: Int = R.layout.explain_recipe
    }
}
