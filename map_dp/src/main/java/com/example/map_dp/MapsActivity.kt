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
import android.annotation.SuppressLint
import android.location.Geocoder
import android.os.Build
import android.text.TextUtils.replace
import android.view.View
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
import kotlinx.android.synthetic.main.dialog_loading.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class MapsActivity : AppCompatActivity(), ConnectionCallbacks,
    OnConnectionFailedListener, OnMapReadyCallback {

    lateinit var providerClient: FusedLocationProviderClient
    lateinit var apiClient: GoogleApiClient
    var googleMap: GoogleMap? = null
    var itemname: String = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        itemname = "사과" //itemname 여기서 넣어주기

        //지도 출력
        mapfun()

        Mylocbtn.setOnClickListener {
            onConnected(Bundle())
        } //플로팅 버튼으로 현위치로 지도 옮기기

        mapSearch.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener,
                androidx.appcompat.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextChange(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextSubmit(newText: String?): Boolean {
                    val geocoder = Geocoder(this@MapsActivity)
                    val cor = geocoder.getFromLocationName(newText, 1)
                    try {
                        moveMap(cor[0].latitude, cor[0].longitude, itemname)
                    } catch (e: IndexOutOfBoundsException) {
                        Log.d("Map_location", "오류")
                        Toast.makeText(this@MapsActivity, "검색 결과가 없습니다.", Toast.LENGTH_LONG).show()
                    }
                    return true
                }
            }) //검색해서 지도 옮기기
    }

    //지도
    fun mapfun() {
        val requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            if (it.all { permission -> permission.value == true }) {
                apiClient.connect()
            } else {
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

        if (checkSelfPermission(this, ACCESS_FINE_LOCATION) !== PackageManager.PERMISSION_GRANTED ||
            checkSelfPermission(this, WRITE_EXTERNAL_STORAGE) !== PackageManager.PERMISSION_GRANTED ||
            checkSelfPermission(this, ACCESS_NETWORK_STATE) !== PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissionLauncher.launch(
                arrayOf(
                    ACCESS_FINE_LOCATION,
                    WRITE_EXTERNAL_STORAGE,
                    ACCESS_NETWORK_STATE
                )
            )
        } else {
            apiClient.connect()
        }
    }

    private fun moveMap(latitude: Double, longitude: Double, itemname: String) {
        Log.d("Map_location", "$latitude, $longitude")

        val dist_list = Marketlist().marketdist(this@MapsActivity, latitude, longitude).first
        val for_addr = Marketlist().marketdist(this@MapsActivity, latitude, longitude).second
        val address_list : List<TextView> = listOf(address1,address2,address3,address4,address5)
        val geocoder = Geocoder(this@MapsActivity)

        for (i in dist_list.indices){
            checkEnd(dist_list[i], itemname, "2022-05", i)
            address_list[i].text = geocoder.getFromLocation(for_addr[i].lati.toDouble(), for_addr[i].longi.toDouble(), 10)
                .get(0).getAddressLine(0).toString()
        }

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
        if (checkSelfPermission(this, ACCESS_FINE_LOCATION) === PackageManager.PERMISSION_GRANTED) {
            providerClient.lastLocation.addOnSuccessListener(
                this,
                object : OnSuccessListener<Location> {
                    override fun onSuccess(p0: Location?) {
                        p0?.let {
                            val latitude = p0.latitude
                            val longitude = p0.longitude
                            Log.d("map_location", "$latitude, $longitude")
                            moveMap(latitude, longitude, itemname)
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

    //API 출력 할 날짜 받아오는 함수
    fun now_day(): String {
        //오늘날짜
        val calendar = Calendar.getInstance()
        val date = calendar.get(Calendar.DAY_OF_WEEK)
        val time = calendar.get(Calendar.HOUR_OF_DAY)
        val Strnow: String
        if (date == 1){ //일요일이면 이틀 빼기
            calendar.add(Calendar.DAY_OF_YEAR, -2)
            val TimeToDate = calendar.time
            val formatter  = SimpleDateFormat("yyyyMMdd")
            Strnow = formatter.format(TimeToDate)
        }
        else if(date == 7){ //토요일이면 하루 빼기
            calendar.add(Calendar.DAY_OF_YEAR, -1)
            val TimeToDate = calendar.time
            val formatter  = SimpleDateFormat("yyyyMMdd")
            Strnow = formatter.format(TimeToDate)
        }
        else if(date in (3 .. 6) && time < 18){ //화~금 & 18시 이전이면 전날(몇시 업데이트인지 확인하고 고치기)
            calendar.add(Calendar.DAY_OF_YEAR, -1)
            val TimeToDate = calendar.time
            val formatter  = SimpleDateFormat("yyyyMMdd")
            Strnow = formatter.format(TimeToDate)
        }
        else if(date == 2 && time < 18){ //월요일 & 18시 이전이면 3일전
            calendar.add(Calendar.DAY_OF_YEAR, -3)
            val TimeToDate = calendar.time
            val formatter  = SimpleDateFormat("yyyyMMdd")
            Strnow = formatter.format(TimeToDate)
        }
        else{
            calendar.add(Calendar.DAY_OF_YEAR, 0)
            val TimeToDate = calendar.time
            val formatter  = SimpleDateFormat("yyyyMMdd")
            Strnow = formatter.format(TimeToDate)
        }
        return Strnow
    }

    ///API///
    fun checkEnd(marketname: String, itemname: String, searchday: String, idx:Int) {
        val tmp_name = marketname.replace(" ", "") //띄어쓰기 없애기
        val call = ApiObject.retrofitService.GetPrice(1, 1, tmp_name, itemname, searchday)
        call.enqueue(object : retrofit2.Callback<DataClass.market> { //맨 끝 찾아서 맨 끝 값 callapi함수에 넣어주기
            override fun onResponse(
                call: Call<DataClass.market>,
                response: Response<DataClass.market>
            ) {
                if (response.isSuccessful) {
                    val end_row = response.body()?.ListNecessariesPricesService?.list_total_count!!.toInt()

                    callApi(1, end_row, marketname, itemname, searchday, idx)

                    val ex_day = response.body()?.ListNecessariesPricesService?.row!![0].P_DATE //날짜
                    val printyear = ex_day.substring(0 until 4)
                    val printmonth = ex_day.substring(5 until 7)
                    val printday = ex_day.substring(8 until 10)

                    info.text = """${printyear}년 ${printmonth}월 ${printday}일 기준 내 주변 ${itemname}의 가격은?"""
//                    Log.d("된다", response.body().toString())
                }
            }

            override fun onFailure(call: Call<DataClass.market>, t: Throwable) {
                Log.d("안된다", t.message.toString())
            }
        })

    }

    fun callApi(start: Int, end: Int, marketname: String, itemname: String, searchday: String, idx:Int){
        val dialog = LoadingDialog(this@MapsActivity)
        dialog.show()

        val tmp_name = marketname.replace(" ", "") //띄어쓰기 없애기

        val marketname_list :List<TextView> = listOf(marketname1,marketname2,marketname3,marketname4,marketname5)
        val price_list :List<TextView> = listOf(price1,price2,price3,price4,price5)
        val weight_list :List<TextView> = listOf(weight1,weight2,weight3,weight4,weight5)

            val call = ApiObject.retrofitService.GetPrice(start, end, tmp_name, itemname, searchday)
            call.enqueue(object : retrofit2.Callback<DataClass.market> {
                override fun onResponse(
                    call: Call<DataClass.market>,
                    response: Response<DataClass.market>
                ) {
                    if (response.isSuccessful) {
                        marketname_list[idx].text = response.body()!!.ListNecessariesPricesService.row[0].M_NAME
                        price_list[idx].text = response.body()!!.ListNecessariesPricesService.row[0].A_PRICE + " 원"
                        weight_list[idx].text = response.body()!!.ListNecessariesPricesService.row[0].A_UNIT
//                        Log.d("된다", response.body().toString())
                    }
                    dialog.dismiss()
                }
                override fun onFailure(call: Call<DataClass.market>, t: Throwable) {
                    Log.d("안된다", t.message.toString())
                }
            })
    }

    ///API///
    interface ApiInterface {
        @GET("61514f6b616d6a6d37354141456f4d/" //api인증키
                    + "json/ListNecessariesPricesService/{startRow}/{endRow}/{Mname}/{Pname}/{yearmonth}")
        //http://openapi.seoul.go.kr:8088/61514f6b616d6a6d37354141456f4d/xml/ListNecessariesPricesService/1/1000/{가게이름}/{품목이름}/2022-05
        fun GetPrice(
            @Path("startRow", encoded = true) startRow: Int,
            @Path("endRow", encoded = true) endRow: Int,
            @Path("Mname", encoded = true) Mname: String,
            @Path("Pname", encoded = true) Pname: String,
            @Path("yearmonth", encoded = true) yearmonth: String
        ): Call<DataClass.market>
    }
}

val retrofit = Retrofit.Builder()
    .baseUrl("http://openapi.seoul.go.kr:8088/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object ApiObject {
    val retrofitService: MapsActivity.ApiInterface by lazy {
        retrofit.create(MapsActivity.ApiInterface::class.java)
    }
}