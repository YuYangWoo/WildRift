package com.cookandroid.wildlift.Video

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.SplashActivity
import com.cookandroid.wildlift.Video.VideoFactory.videoList
import com.cookandroid.wildlift.champion.championInfo.ChampionInfo

class VideoAdapter :RecyclerView.Adapter<VideoAdapter.CustomViewHolder>(){
    var splash = SplashActivity()
    var videoList = splash.videoList
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_video, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        Log.d("test", splash.videoList[0].videoImage.toString())
        Glide.with(holder.itemView) // 띄어줄 뷰를 명시
            .load(splash.videoList[position].videoImage) // 이미지 주소
            .into(holder.videoImage) // list_log의 imageView에 띄우기
        holder.videoTxt.text = splash.videoList[position].videoTxt
    }

    class CustomViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var videoImage = itemView.findViewById<ImageView>(R.id.imgVideo)
        var videoTxt = itemView.findViewById<TextView>(R.id.txtVideoTitle)

        init {
            itemView.setOnClickListener {
                var pos = adapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    var item = videoList[pos]
                    var intent = Intent(itemView.context, VideoActivity::class.java)
                    intent.putExtra("videoId", item.id)
                    Log.d("idbefore",item.id.toString() )
                    ContextCompat.startActivity(itemView.context, intent, null)
                }
            }
        }

    }
    override fun getItemCount(): Int {
        return splash.videoList.size
    }
}