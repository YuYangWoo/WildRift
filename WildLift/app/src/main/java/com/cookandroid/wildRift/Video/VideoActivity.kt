package com.cookandroid.wildRift.Video

import android.os.Bundle
import android.util.Log
import com.cookandroid.wildRift.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import kotlinx.android.synthetic.main.activity_youtube.*

class VideoActivity: YouTubeBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube)

        var videoId = intent.getStringExtra("videoId")
        var videoTxt = intent.getStringExtra("videoTxt")
        Log.d("beforeid", videoId.toString())
        var youtubeView = findViewById<YouTubePlayerView>(R.id.youtubeView)

        txtVideoTopic.text = videoTxt
        // 유튜브 뷰
        youtubeView.initialize("develop", object : YouTubePlayer.OnInitializedListener
        { override fun onInitializationSuccess(provider: YouTubePlayer.Provider, player: YouTubePlayer, wasRestored: Boolean )
        {
            if (!wasRestored)
            {
                player.cueVideo(videoId)
            }
        }
            override fun onInitializationFailure(provider: YouTubePlayer.Provider?, result: YouTubeInitializationResult? )
            { } })
    }
}