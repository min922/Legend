package com.example.home_dp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.home_dp.Bookmark.BookmarkTab
import com.example.home_dp.MyRef.RefTab
import com.example.home_dp.R.id.logoutbtn
import com.example.home_dp.R.layout.activity_main_ref
import com.example.main_dp.SelectMainActivity
import com.example.show_recipes.MainActivityShow
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.Tab
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main_ref.*
import kotlin.system.exitProcess
import com.example.home_dp.R.id.tabContent as refTabcontent

class RefMainActivity : AppCompatActivity() {
    private lateinit var refTab: RefTab
    private lateinit var bookmarkTab: BookmarkTab

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main_ref)

        val user = FirebaseAuth.getInstance().currentUser //현재 로그인된 사용자 정보
        val username = user?.displayName //사용자 이름
        UserName.text = username

        refTab = RefTab()
        bookmarkTab = BookmarkTab()

        supportFragmentManager.beginTransaction().add(refTabcontent, refTab).commit()
        //시작할때 내 냉장고탭을 기본으로 보여줌

        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: Tab?) {
                val transaction = supportFragmentManager.beginTransaction()
                when (tab?.text){
                    "내 냉장고"-> {
                        transaction.replace(refTabcontent, refTab)
                    }
                    "북마크"->transaction.replace(refTabcontent, bookmarkTab)
                }
                transaction.commit()
            }

            override fun onTabReselected(tab: Tab?) {
                val transaction = supportFragmentManager.beginTransaction()
                when (tab?.text){
                    "내 냉장고"-> {
                        transaction.replace(refTabcontent, refTab)
                    }
                    "북마크"->transaction.replace(refTabcontent, bookmarkTab)
                }
                transaction.commit()
            }

            override fun onTabUnselected(tab: Tab?) {
                val transaction = supportFragmentManager.beginTransaction()
                when (tab?.text){
                    "내 냉장고"-> {
                        transaction.replace(refTabcontent, refTab)
                    }
                    "북마크"->transaction.replace(refTabcontent, bookmarkTab)
                }
                transaction.commit()
            }
        })

        plus.setOnClickListener {
            val intent = Intent(this, SelectMainActivity::class.java)
            startActivity(intent)
        }

        RecommandButton.setOnClickListener {
            val intent = Intent(this, MainActivityShow::class.java)
            startActivity(intent)
        }
    }


    /// 뒤로가기버튼으로 앱 종료 ///
    private var waitTime = 0L

    override fun onBackPressed() {
        if (System.currentTimeMillis() - waitTime >= 2000){
            waitTime = System.currentTimeMillis()
            Toast.makeText(this, "뒤로가기 버튼을 한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show()
        }
        else{
            // 앱 완전히 종료허가
            finishAffinity() //루트 액티비티를 종료
            System.runFinalization() // 현재 작업중인 쓰레드가 다 종료되면 종료시키기
            exitProcess(0) // 현재 액티비티를 종료
        }
    }


    /// 액션바 로그아웃 버튼 ///
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            logoutbtn -> {
                // 구글 계정 로그아웃
                val opt = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build()
                val client = GoogleSignIn.getClient(this, opt)
                client.signOut()

                Toast.makeText(this,  "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show()

                finish() // 첫 화면으로 돌아가기
            }
        }
        return super.onOptionsItemSelected(item)
    }

//    fun refresh_frag(fragment: Fragment){
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.tabContent, fragment)
//        transaction.commit()
//        transaction.detach(fragment)
//            .attach(fragment)
//            .commit()
//    }
}