package com.cookandroid.wildlift

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.cookandroid.wildlift.champion.ChampionActivity
import com.cookandroid.wildlift.item.ItemActivity
import com.cookandroid.wildlift.singleton.FirebaseSingleton
import com.google.android.material.navigation.NavigationView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.dialog_rune_spell.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var database: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)
        FirebaseSingleton.init()
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

        //아이템 선택 이벤트 호출
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.championInformation -> {
                startActivity(Intent(this, ChampionActivity::class.java))
            }
            R.id.itemInformation -> {
                startActivity(Intent(this, ItemActivity::class.java))
            }
            R.id.runesSpell -> {
//             var builder = AlertDialog.Builder(this)
//                var dialog = Dialog(applicationContext)
//                builder.setTitle("선택하세요")
//                builder.setView(layoutInflater.inflate(R.layout.dialog_rune_spell, null))
//
//                builder.show()
                val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val view = inflater.inflate(R.layout.dialog_rune_spell, null)
                val rune = view.findViewById<Button>(R.id.btnRune)
                val spell = view.findViewById<Button>(R.id.btnSpell)
                rune.setOnClickListener {
                    startActivity(Intent(this, RunesActivity::class.java))
                }

                spell.setOnClickListener {
                    startActivity(Intent(this,SpellActivity::class.java))
                }
                val alertDialog = AlertDialog.Builder(this)
                    .setTitle("선택하세요")
                    .create()
                alertDialog.setView(view)
                alertDialog.show()
            }
        }

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

}
