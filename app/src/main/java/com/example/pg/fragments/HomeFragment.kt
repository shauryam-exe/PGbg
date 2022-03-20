package com.example.pg.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        val videoViewPager = view.findViewById<ViewPager2>(R.id.videoViewPager)

        var videoItems = arrayListOf<VideoItem>()
        val videoItem1 = VideoItem()
        videoItem1.videoURL = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"
        videoItem1.ideaName = "Just Testing ViewPager2"
        videoItem1.userName = "Osama Bin Laden"
        videoItems.add(videoItem1)

        val videoItem2 = VideoItem()
        videoItem2.videoURL = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4"
        videoItem2.ideaName = "Boooom"
        videoItem2.userName = "Dawood Ibrahim"
        videoItems.add(videoItem2)

        val videoItem3 = VideoItem()
        videoItem3.videoURL = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4"
        videoItem3.ideaName = "26/11"
        videoItem3.userName = "Jihadi"
        videoItems.add(videoItem3)



        videoViewPager.adapter = VideoAdapter(videoItems)

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}