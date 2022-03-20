package com.example.pg.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.pg.R
import com.example.pg.model.VideoItem


class VideoAdapter(val videoItems: List<VideoItem>) :
    RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.video_view,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.setVideoData(videoItems[position])
    }

    override fun getItemCount(): Int {
        return videoItems.size
    }

    class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val videoView = itemView.findViewById<VideoView>(R.id.videoView)
        val progressBar = itemView.findViewById<ProgressBar>(R.id.videoProgressBar)
        val userNameTextView = itemView.findViewById<TextView>(R.id.nameOnVideoTextView)
        val ideaNameTextView = itemView.findViewById<TextView>(R.id.ideaNameVideoTextView)
        val askTextView = itemView.findViewById<TextView>(R.id.askOnVideoTextView)

        fun setVideoData(videoData: VideoItem) {
            userNameTextView.text = videoData.userName
            ideaNameTextView.text = videoData.ideaName
            askTextView.text = videoData.ask

            videoView.setVideoPath(videoData.videoURL)

            videoView.setOnPreparedListener() {
                progressBar.visibility = View.GONE
                it.start()

                val videoRatio: Float = it.videoWidth / it.videoHeight.toFloat()
                val screenRatio: Float = videoView.width / videoView.height.toFloat()

                val scale: Float = screenRatio / videoRatio
                if (scale >= 1) {
                    videoView.scaleX = scale
                } else {
                    videoView.scaleY = 1 / scale
                }

            }

            videoView.setOnCompletionListener {
                it.start()
            }
        }
    }

}