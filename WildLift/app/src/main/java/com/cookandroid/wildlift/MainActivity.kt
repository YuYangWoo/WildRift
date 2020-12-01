package com.cookandroid.wildlift

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.wildlift.Lotation.LotationAdapter
import com.cookandroid.wildlift.Patch.DialogDevelopment
import com.cookandroid.wildlift.Patch.DialogNote
import com.cookandroid.wildlift.Patch.PatchAdapter
import com.cookandroid.wildlift.Patch.WildNoteAdapter
import com.cookandroid.wildlift.Video.VideoAdapter
import com.cookandroid.wildlift.champion.ChampionActivity
import com.cookandroid.wildlift.item.ItemActivity
import com.cookandroid.wildlift.rune.RunesActivity
import com.cookandroid.wildlift.singleton.FirebaseSingleton
import com.cookandroid.wildlift.spell.SpellActivity
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {

    // 패치 리사이클러뷰
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var layoutManagerLotation:RecyclerView.LayoutManager
    private lateinit var layoutManagerVideo:RecyclerView.LayoutManager
    private lateinit var layoutManagerNote: RecyclerView.LayoutManager

    private var recyclerViewPatchAdapter = PatchAdapter()
    private var recyclerViewLotationAdapter = LotationAdapter()
    private var recyclerViewVideoAdapter = VideoAdapter()
    private var recyclerViewNoteAdapter = WildNoteAdapter()


    private var splash = SplashActivity()
    private var lotationList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)

        // 파이어베이스 정보들 불러오기
        FirebaseSingleton.init()

        // 툴바, 네비게이션바 init
        initBar()

        // 버튼 클릭 이벤트
        goActivity()

        // 패치 리스트 만들기
        setPatchNote()

        // 로테이션 만들기
        setLotation()

        // 비디오 만들기
        setVideo()

        // 왈백 패치노트
        setWildNote()
    }

    private fun initBar() {
        title = resources.getString(R.string.app_name)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)

        // 왼쪽 상단에 네비게이션바 만들기
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )

        drawer.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        // 아이템 선택 이벤트 호출
        navigationView.setNavigationItemSelectedListener(this)
    }

    // 패치 리스트 만들기
    private fun setPatchNote() {
        recyclerPatch.setHasFixedSize(true) // LinearLayoutManager 객체 생성 후 layoutManager에 대입 및 recyclerView 고정크기 On
        layoutManager = LinearLayoutManager(this)
        (layoutManager as LinearLayoutManager).reverseLayout = true // 거꾸로 대입
        (layoutManager as LinearLayoutManager).stackFromEnd = true // 처음부터 끝까지
        recyclerPatch.layoutManager = layoutManager
        recyclerPatch.adapter = recyclerViewPatchAdapter
    }

    private fun setLotation() {
        recyclerLotation.setHasFixedSize(true)
        layoutManagerLotation = GridLayoutManager(this@MainActivity, 5)
        recyclerLotation.layoutManager = layoutManagerLotation

        for(i in splash.lotationList) {
            for(j in splash.championList) {
                if(i.name == j.name) {
                    lotationList.add(j.image.toString())
                }
            }
        }
        recyclerViewLotationAdapter = LotationAdapter(lotationList)
        recyclerLotation.adapter = recyclerViewLotationAdapter
    }

    // 유튜브 영상 리스트
    private fun setVideo() {
        recyclerVideo.setHasFixedSize(true)
        layoutManagerVideo = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerVideo.layoutManager = layoutManagerVideo
        recyclerVideo.adapter = recyclerViewVideoAdapter
    }

    private fun setWildNote() {
        recyclerNote.setHasFixedSize(true)
        layoutManagerNote = LinearLayoutManager(this)
        (layoutManagerNote as LinearLayoutManager).reverseLayout = true // 거꾸로 대입
        (layoutManagerNote as LinearLayoutManager).stackFromEnd = true // 처음부터 끝까지
        recyclerNote.layoutManager = layoutManagerNote
        recyclerNote.adapter = recyclerViewNoteAdapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.championInformation -> {
                startActivity(Intent(this, ChampionActivity::class.java))
            }
            R.id.itemInformation -> {
                startActivity(Intent(this, ItemActivity::class.java))
            }
            R.id.runes -> {
                startActivity(Intent(this, RunesActivity::class.java))
            }
            R.id.spell -> {
                startActivity(Intent(this, SpellActivity::class.java))
            }
            R.id.freeBoard -> {
                Toast.makeText(this,"현재 탭은 개발 중입니다. 다음버전에서 확인하세요 !",Toast.LENGTH_LONG).show()
            }
            R.id.tipBoard -> {
                Toast.makeText(this,"현재 탭은 개발 중입니다. 다음버전에서 확인하세요 !",Toast.LENGTH_LONG).show()
            }
            R.id.videoBoard -> {
                Toast.makeText(this,"현재 탭은 개발 중입니다. 다음버전에서 확인하세요 !",Toast.LENGTH_LONG).show()
            }
            R.id.developerInfo -> {
              DialogDevelopment(this).show()
            }
        }

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    private fun goActivity() {
        btnChamp.setOnClickListener { startActivity(Intent(this, ChampionActivity::class.java)) }
        btnItem.setOnClickListener { startActivity(Intent(this, ItemActivity::class.java)) }
        btnSpell.setOnClickListener {  startActivity(Intent(this, SpellActivity::class.java))}
        btnRune.setOnClickListener {  startActivity(Intent(this, RunesActivity::class.java))}
    }
}
