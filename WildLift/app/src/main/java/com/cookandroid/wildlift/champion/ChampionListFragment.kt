package com.cookandroid.wildlift.champion

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.wildlift.R
import kotlinx.android.synthetic.main.fragment_champion_list.*

class ChampionListFragment(val tabTitle: Int) : Fragment() {

    private lateinit var championAdapter: RecyclerView.Adapter<*>
    private lateinit var layoutManager: RecyclerView.LayoutManager
    var abc = R.drawable.moga
    var championList = arrayListOf(
       ChampionItem("씨발","미드나가",abc.toString(),"빠끄","qwe")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view          = inflater.inflate(R.layout.fragment_champion_list, container, false)
        when(tabTitle) {
            R.string.champion_list_All -> {Log.d("test","쿠쿠링뽕")}
            R.string.champion_list_TOP -> {Log.d("test","쿠쿠")}
        }

        var recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
//        championList = ArrayList()

        // LinearLayoutManager 객체 생성 후 layoutManager에 대입 및 recyclerView 고정크기 On
        recyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        (layoutManager as LinearLayoutManager).stackFromEnd = true // 처음부터 끝까지
        recyclerView.layoutManager = layoutManager

        championAdapter = CustomAdapter(championList,context!!)
        recyclerView.adapter = championAdapter
        return view
    }
}