package com.example.pg.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ToggleButton
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.pg.R
import com.example.pg.adapter.VideoAdapter
import com.example.pg.model.VideoItem

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var videoViewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        videoViewPager = view.findViewById(R.id.videoViewPager)

        var videoItems = arrayListOf<VideoItem>()
        val videoItem1 = VideoItem()
        videoItem1.videoURL = "https://res.cloudinary.com/dz9lxwqgj/video/upload/v1647809475/WhatsApp_Video_2022-03-21_at_1.56.14_AM_qwnrg7.mp4"
        videoItem1.ideaName = "JobZ"
        videoItem1.userName = "Howard Stark"
        videoItem1.ask = "45 Lacs"
        videoItems.add(videoItem1)

        val videoItem2 = VideoItem()
        videoItem2.videoURL = "https://res.cloudinary.com/dz9lxwqgj/video/upload/v1647809456/WhatsApp_Video_2022-03-21_at_1.56.28_AM_y0mydf.mp4"
        videoItem2.ideaName = "Timberly"
        videoItem2.userName = "Sarah Baker"
        videoItem2.ask = "80Lacs"
        videoItems.add(videoItem2)

        val videoItem3 = VideoItem()
        videoItem3.videoURL = "https://res.cloudinary.com/dz9lxwqgj/video/upload/v1647809422/WhatsApp_Video_2022-03-21_at_1.56.29_AM_qywt94.mp4"
        videoItem3.ideaName = "FurSpace"
        videoItem3.userName = "Tom Holland"
        videoItem3.ask = "1.75 Crore"
        videoItems.add(videoItem3)


        videoViewPager.adapter = VideoAdapter(videoItems)

    }

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}