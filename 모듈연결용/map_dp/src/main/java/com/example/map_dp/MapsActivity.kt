package com.example.map_dp

import android.Manifest.permission.*
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.checkSelfPermission
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.GoogleApiClient.*
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.tasks.OnSuccessListener
import kotlinx.android.synthetic.main.activity_maps.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.text.SimpleDateFormat
import java.util.*


class MapsActivity : AppCompatActivity(), ConnectionCallbacks,
    OnConnectionFailedListener, OnMapReadyCallback {
    lateinit var providerClient: FusedLocationProviderClient
    lateinit var apiClient: GoogleApiClient
    var googleMap: GoogleMap? = null
    var itemname: String = "0"
    var searchday: String = "0"
    lateinit var dialog: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        dialog = LoadingDialog(this@MapsActivity)

        //val itemname = intent.getStringExtra("key1")
        itemname = "고등어" //itemname 여기서 넣어주기

        searchday = getMonth()

        //지도 출력
        mapfun()

        Mylocbtn.setOnClickListener {
//            dialog = LoadingDialog(this@MapsActivity)
//            dialog.show()
            onConnected(Bundle())
        } //플로팅 버튼으로 현위치로 지도 옮기기

        mapSearch.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener,
                androidx.appcompat.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextChange(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextSubmit(newText: String?): Boolean {
//                    dialog = LoadingDialog(this@MapsActivity)
//                    dialog.show()

                    mapSearch.setQuery("", false) //검색창 초기화
                    mapSearch.clearFocus() //키보드 내리기

                    val geocoder = Geocoder(this@MapsActivity)
                    val cor = geocoder.getFromLocationName(newText, 1)
                    try {
//                        dialog = LoadingDialog(this@MapsActivity)
//                        dialog.show()
                        moveMap(cor[0].latitude, cor[0].longitude, itemname)
                    } catch (e: IndexOutOfBoundsException) {
                        Log.d("Map_location", "오류")
//                        dialog.dismiss()
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

        val distance_list = Marketlist().marketdist(this@MapsActivity, latitude, longitude)

        val dist_list = distance_list.first
        val for_addr = distance_list.second
        val address_list : List<TextView> = listOf(address1, address2, address3, address4, address5)
        val geocoder = Geocoder(this@MapsActivity)

        for (i in dist_list.indices){
            checkEnd(dist_list[i], itemname, searchday, i)
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

//        dialog.dismiss()
    }

    override fun onConnected(p0: Bundle?) {
        if (checkSelfPermission(this, ACCESS_FINE_LOCATION) === PackageManager.PERMISSION_GRANTED) {
            providerClient.lastLocation.addOnSuccessListener(
                this,
                object : OnSuccessListener<Location> {
                    override fun onSuccess(p0: Location?) {
//                        dialog = LoadingDialog(this@MapsActivity)
//                        dialog.show()
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

    ///API///
    fun getMonth(): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_WEEK, -1)
        calendar.firstDayOfWeek = Calendar.SATURDAY
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY)
        val TimeToDate = calendar.time
        val formatter  = SimpleDateFormat("yyyy-MM")
        val Strnow = formatter.format(TimeToDate)
        Log.d("날짜확인", SimpleDateFormat("yyyyMMdd").format(TimeToDate))

        return Strnow
    }

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
                }
                override fun onFailure(call: Call<DataClass.market>, t: Throwable) {
                    Log.d("안된다", t.message.toString())
                }
            })
    }

    ///API///
    interface ApiInterface {
        @GET("API키/" //api인증키
                    + "json/ListNecessariesPricesService/{startRow}/{endRow}/{Mname}/{Pname}/{yearmonth}")
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
