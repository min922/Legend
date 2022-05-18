package com.example.markettest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.annotations.SerializedName
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface{
    @GET("인증키/" //api인증키
            + "json/Grid_20151128000000000315_1/{startRow}/{endRow}")
    fun GetPrice(
        @Path("startRow", encoded = true) startRow:Int,
        @Path("endRow", encoded = true) endRow:Int,
        @Query("EXAMIN_DE", encoded = true) EXAMIN_DE: String,
        @Query("EXAMIN_PRDLST_CODE", encoded = true) EXAMIN_PRDLST_CODE: String
    ): Call<DataClasses.MarketInfo>
}

val retrofit = Retrofit.Builder()
    .baseUrl("http://211.237.50.150:7080/openapi/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
object ApiObject {
    val retrofitService: ApiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callApi(1, 5, "20220517", "640")
    }
    fun callApi(start:Int, end:Int, searchday:String, itemcode:String){
        val call = ApiObject.retrofitService.GetPrice(start, end, searchday, itemcode)
        call.enqueue(object :retrofit2.Callback<DataClasses.MarketInfo>{
            override fun onResponse(call: Call<DataClasses.MarketInfo>, response: Response<DataClasses.MarketInfo>) {
                if (response.isSuccessful){
                    Log.d("된다", response.body().toString())
                    val test_text1 = response.body()?.wrap?.row!![0].STD_MRKT_NM
                    testyoung1.text = test_text1
                    val test_text2 = response.body()?.wrap?.row!![1].STD_MRKT_NM
                    testyoung2.text = test_text2
                    val test_text3 = response.body()?.wrap?.row!![2].STD_MRKT_NM
                    testyoung3.text = test_text3
                    val test_text4 = response.body()?.wrap?.row!![3].STD_MRKT_NM
                    testyoung4.text = test_text4
                    val test_text5 = response.body()?.wrap?.row!![4].STD_MRKT_NM
                    testyoung5.text = test_text5
                }
            }
            override fun onFailure(call: Call<DataClasses.MarketInfo>, t: Throwable) {
                Log.d("안된다", t.message.toString())
            }
        })
    }
}