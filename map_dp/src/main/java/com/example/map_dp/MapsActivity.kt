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
import android.widget.SearchView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat.checkSelfPermission
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.GoogleApiClient.*
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.tasks.OnSuccessListener
import kotlinx.android.synthetic.main.activity_maps.*

class MapsActivity : AppCompatActivity(), ConnectionCallbacks,
    OnConnectionFailedListener, OnMapReadyCallback {

    lateinit var providerClient: FusedLocationProviderClient
    lateinit var apiClient: GoogleApiClient
    var googleMap: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        mapfun()

        Mylocbtn.setOnClickListener {
            onConnected(Bundle())
        }

        mapSearch.setOnQueryTextListener(object :SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextChange(query: String?): Boolean {
                return false
            }
            override fun onQueryTextSubmit(newText: String?): Boolean {
                val geocoder = Geocoder(this@MapsActivity)
                val cor = geocoder.getFromLocationName(newText, 1)
                moveMap(cor[0].latitude, cor[0].longitude)
                return false
            }
        })
    }

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
        val latLng = LatLng(latitude, longitude)
        val position: CameraPosition = CameraPosition.Builder()
            .target(latLng)
            .zoom(17f)
            .build()

        googleMap!!.moveCamera(CameraUpdateFactory.newCameraPosition(position))

        val markerOptions = MarkerOptions()
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
        markerOptions.position(latLng)
        markerOptions.title("현 위치")

        googleMap?.addMarker(markerOptions)
    }

    override fun onConnected(p0: Bundle?) {
        if(checkSelfPermission(this, ACCESS_FINE_LOCATION) === PackageManager.PERMISSION_GRANTED){
            providerClient.lastLocation.addOnSuccessListener(
                this,
                object: OnSuccessListener<Location> {
                    override fun onSuccess(p0: Location?) {
                        p0?.let {
                            val latitude = p0.latitude
                            val longitude = p0.longitude
                            Log.d("Map","$latitude, $longitude")
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
}