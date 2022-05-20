package com.example.map_dp

import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.location.*
import android.Manifest.permission.*
import android.location.Geocoder
import android.os.Build
import android.widget.Button
import android.widget.SearchView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.checkSelfPermission
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.GoogleApiClient.*
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.tasks.OnSuccessListener
import kotlinx.android.synthetic.main.activity_maps.*
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import javax.xml.parsers.DocumentBuilderFactory
import kotlin.collections.ArrayList


class MapsActivity : AppCompatActivity(), ConnectionCallbacks,
    OnConnectionFailedListener, OnMapReadyCallback {

    lateinit var providerClient: FusedLocationProviderClient
    lateinit var apiClient: GoogleApiClient
    var googleMap: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        //지도 출력
        mapfun()

        Mylocbtn.setOnClickListener {
            onConnected(Bundle())
        } //플로팅 버튼으로 현위치로 지도 옮기기

        mapSearch.setOnQueryTextListener(object :SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextChange(query: String?): Boolean {
                return false
            }
            override fun onQueryTextSubmit(newText: String?): Boolean {
                val geocoder = Geocoder(this@MapsActivity)
                val cor = geocoder.getFromLocationName(newText, 1)
                try{
                    moveMap(cor[0].latitude, cor[0].longitude)
                } catch (e: IndexOutOfBoundsException){
                    Log.d("Map_location","오류")
                    Toast.makeText(this@MapsActivity, "검색 결과가 없습니다.", Toast.LENGTH_LONG).show()
                }
                return false
            }
        }) //검색해서 지도 옮기기
    }

    //지도
    fun mapfun(){
        val requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            if (it.all { permission -> permission.value == true }){
                apiClient.connect()
            }else {
                Toast.makeText(this, "권한이 거부되었습니다.", Toast.LENGTH_SHORT).show()
            }
        }
        (supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment).getMapAsync(this)

        providerClient = LocationServices.getFusedLocationProviderClient(this)
        apiClient = Builder(this)
            .addApi(LocationServices.API)
            .addConnectionCallbacks(this)
            .addOnConnectionFailedListener(this)
            .build()

        if(checkSelfPermission(this, ACCESS_FINE_LOCATION) !== PackageManager.PERMISSION_GRANTED ||
            checkSelfPermission(this, WRITE_EXTERNAL_STORAGE) !== PackageManager.PERMISSION_GRANTED ||
            checkSelfPermission(this, ACCESS_NETWORK_STATE) !== PackageManager.PERMISSION_GRANTED) {
            requestPermissionLauncher.launch(
                arrayOf(
                    ACCESS_FINE_LOCATION,
                    WRITE_EXTERNAL_STORAGE,
                    ACCESS_NETWORK_STATE
                )
            )
        }else {
            apiClient.connect()
        }
    }

    private fun moveMap(latitude: Double, longitude: Double){
        Log.d("Map_location","$latitude, $longitude")

        //오늘날짜
        var calendar = Calendar.getInstance()
        var date = calendar.get(Calendar.DAY_OF_WEEK)
        var Strnow: String
        if (date == 1){
            calendar.add(Calendar.DAY_OF_YEAR, -2)
            var TimeToDate = calendar.time
            var formatter  = SimpleDateFormat("yyyyMMdd")
            Strnow = formatter.format(TimeToDate)
        } //일요일이면 이틀 빼기
        else if(date == 7){
            calendar.add(Calendar.DAY_OF_YEAR, -1)
            var TimeToDate = calendar.time
            var formatter  = SimpleDateFormat("yyyyMMdd")
            Strnow = formatter.format(TimeToDate)
        } //토요일이면 하루 빼기
        else{
            calendar.add(Calendar.DAY_OF_YEAR, 0)
            var TimeToDate = calendar.time
            var formatter  = SimpleDateFormat("yyyyMMdd")
            Strnow = formatter.format(TimeToDate)
        }

        checkEnd(Strnow, "654", latitude,  longitude)

        val latLng = LatLng(latitude, longitude)
        val position: CameraPosition = CameraPosition.Builder()
            .target(latLng)
            .zoom(17f)
            .build()

        googleMap!!.moveCamera(CameraUpdateFactory.newCameraPosition(position))

        val markerOptions = MarkerOptions()
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
        markerOptions.position(latLng)
        markerOptions.title("지금 나는 여기에")

        googleMap?.addMarker(markerOptions)
    }

    override fun onConnected(p0: Bundle?) {
        if(checkSelfPermission(this, ACCESS_FINE_LOCATION) === PackageManager.PERMISSION_GRANTED){
            providerClient.lastLocation.addOnSuccessListener(
                this,
                object: OnSuccessListener<Location>{
                    override fun onSuccess(p0: Location?) {
                        p0?.let {
                            val latitude = p0.latitude
                            val longitude = p0.longitude
                            Log.d("map_location","$latitude, $longitude")
                            moveMap(latitude, longitude)
                        }
                    }
                }
            )
            apiClient.disconnect()
        }
    }

    override fun onConnectionSuspended(p0: Int) {

    }

    override fun onConnectionFailed(p0: ConnectionResult) {

    }

    override fun onMapReady(p0: GoogleMap) {
        googleMap = p0
    }


    ///API///
    data class loca(
        var idx : Int = -1,
        var name : String="",
        var lati :String ="",
        var longi :String ="",
        var dist :Float = 0.0F
    )
    fun checkEnd(searchday: String, itemcode: String, search_lati: Double, search_logi: Double){
        val call = ApiObject.retrofitService.GetPrice(1, 1, searchday, itemcode)
        call.enqueue(object :retrofit2.Callback<DataClasses.MarketInfo>{
            override fun onResponse(call: Call<DataClasses.MarketInfo>, response: Response<DataClasses.MarketInfo>) {
                if (response.isSuccessful){
                    val end_row = response.body()?.wrap!!.totalCnt.toInt()
                    callApi(1, end_row, searchday, itemcode, search_lati, search_logi)
                }
            }
            override fun onFailure(call: Call<DataClasses.MarketInfo>, t: Throwable) {
                Log.d("안된다", t.message.toString())
            }
        })
    }
    fun callApi(
        start: Int,
        end: Int,
        searchday: String,
        itemcode: String,
        search_lati: Double,
        search_logi: Double
    ){
        val market_loc_lati = ArrayList<loca>()
        val call = ApiObject.retrofitService.GetPrice(start, end, searchday, itemcode)
        call.enqueue(object :retrofit2.Callback<DataClasses.MarketInfo>{
            override fun onResponse(call: Call<DataClasses.MarketInfo>, response: Response<DataClasses.MarketInfo>) {
                if (response.isSuccessful){
                    val market_location = ArrayList<String>() //표준시장명
                    val market_location_sub = ArrayList<String>() //조사가격시장명
                    for (i in 0 until end){
                        if(response.body()?.wrap?.row!![i].EXAMIN_NM != "도매가격"){
                            val market_name = response.body()?.wrap?.row!![i].STD_MRKT_NM
                            market_location.add(market_name)
                            val market_name_sub = response.body()?.wrap?.row!![i].EXAMIN_MRKT_NM
                            market_location_sub.add(market_name_sub)
                        } else{
                            market_location.add("0")
                            market_location_sub.add("0")
                        }
                    } //시장명 리스트에 저장
                    val geocoder = Geocoder(this@MapsActivity)
                    for (i in market_location.indices){
                        try{ //표준시장명으로 먼저 넣어보고 오류나면 조사가격시장명으로 넣어봄
                            val cor = geocoder.getFromLocationName(market_location[i], 1)
                            val item = loca()
                            item.idx = i
                            item.name = market_location[i]
                            item.lati = cor[0].latitude.toString()
                            item.longi = cor[0].longitude.toString()
                            market_loc_lati.add(item)
//                            Log.d("efklanrg","$i 번째 : $item")
                        } catch (e: IndexOutOfBoundsException){
                            try{
                                val cor = geocoder.getFromLocationName(market_location_sub[i], 1)
                                val item = loca()
                                item.idx = i
                                item.name = market_location_sub[i]
                                item.lati = cor[0].latitude.toString()
                                item.longi = cor[0].longitude.toString()
                                market_loc_lati.add(item)
//                                Log.d("efklanrg","$i 번째 : $item")
                            }catch (e: IndexOutOfBoundsException){
                                Log.d("efklanrg","오류!!!")
                            }
                        }
                    } //조사한 시장들 경, 위도 저장
//                    Marketlist().marketldist()
//                    Log.d("qrekjfrf", market_loc_lati.toString())
                }

                val ex_day = response.body()?.wrap?.row!![0].EXAMIN_DE
                val ex_item = response.body()?.wrap?.row!![0].EXAMIN_PRDLST_NM
                info.text = "${ex_day.substring(0 until 4)}년 ${ex_day.substring(4 until 6)}월 ${ex_day.substring(6 until 8)}일에 내 주변 ${ex_item}의 가격은?"

//                tmp_list = Marketlist().marketdist(market_loc_lati, 37.5444, 126.9645)
                var tmp_list = Marketlist().marketdist(market_loc_lati, search_lati, search_logi)
                //거리순으로 정렬된 리스트 받음
                val geocoder = Geocoder(this@MapsActivity)

//                Log.d("wefjn", market_loc_lati.toString())
                Log.d("wefjn", tmp_list.toString())
//                Log.d("wefjn", response.body()?.wrap?.row.toString())

                val marketname_list :List<TextView> = listOf(marketname1,marketname2,marketname3,marketname4,marketname5)
                val address_list : List<TextView> = listOf(address1,address2,address3,address4,address5)
                val price_list :List<TextView> = listOf(price1,price2,price3,price4,price5)
                val weight_list :List<TextView> = listOf(weight1,weight2,weight3,weight4,weight5)
                for (i in 0 until 5){
                    val tmp_idx = tmp_list[i].idx
                    marketname_list[i].text = response.body()?.wrap?.row!![tmp_idx].STD_MRKT_NM
                    address_list[i].text = geocoder.getFromLocation(tmp_list[i].lati.toDouble(), tmp_list[i].longi.toDouble(), 10)
                        .get(0).getAddressLine(0).toString()
                    price_list[i].text = response.body()?.wrap?.row!![tmp_idx].TODAY_PRIC.toString() + "원"
                    weight_list[i].text = response.body()?.wrap?.row!![tmp_idx].EXAMIN_UNIT_NM
                }

//                Log.d("qoweifhnqowe", tmp_list.toString())
            }
            override fun onFailure(call: Call<DataClasses.MarketInfo>, t: Throwable) {
                Log.d("안된다", t.message.toString())
            }
        })

    }
}


///API///
interface ApiInterface{
    @GET("c41ba7a35737e92228906457385f7542b47a6f0549b1b90cfeabaf363c070e9e/" //api인증키
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