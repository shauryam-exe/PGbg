package com.example.pg.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pg.R
import com.example.pg.adapter.ChatAdapter
import com.example.pg.model.Chat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChatFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChatFragment : Fragment() {
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

    private var searchBar : SearchView? = null
    private var recyclerViewChats : RecyclerView? = null
    private var chatList : ArrayList<Chat>? = null
    private var chatAdapter : ChatAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_chat, container, false)

        searchBar = layout.findViewById(R.id.searchBar)
        recyclerViewChats = layout.findViewById(R.id.rvChats)
        chatList = ArrayList()
        chatAdapter = ChatAdapter(requireContext(), chatList!!)
        recyclerViewChats?.setHasFixedSize(true)
        recyclerViewChats?.layoutManager = GridLayoutManager(requireContext(), 1)
        recyclerViewChats?.adapter = chatAdapter

        chatList?.add(Chat("default", "BlaBlaBla", "Aur bhai kaisa hai?", "08 bje"))
        chatList?.add(Chat("default", "BlaBlaBla", "Aur bhai kaisa hai?", "08 bje"))
        chatList?.add(Chat("default", "BlaBlaBla", "Aur bhai kaisa hai?", "08 bje"))
        chatList?.add(Chat("default", "BlaBlaBla", "Aur bhai kaisa hai?", "08 bje"))
        chatList?.add(Chat("default", "BlaBlaBla", "Aur bhai kaisa hai?", "08 bje"))
        chatList?.add(Chat("default", "BlaBlaBla", "Aur bhai kaisa hai?", "08 bje"))
        chatList?.add(Chat("default", "BlaBlaBla", "Aur bhai kaisa hai?", "08 bje"))
        chatList?.add(Chat("default", "BlaBlaBla", "Aur bhai kaisa hai?", "08 bje"))
        chatList?.add(Chat("default", "BlaBlaBla", "Aur bhai kaisa hai?", "08 bje"))
        chatList?.add(Chat("default", "BlaBlaBla", "Aur bhai kaisa hai?", "08 bje"))
        chatList?.add(Chat("default", "BlaBlaBla", "Aur bhai kaisa hai?", "08 bje"))
        chatList?.add(Chat("default", "BlaBlaBla", "Aur bhai kaisa hai?", "08 bje"))
        chatList?.add(Chat("default", "BlaBlaBla", "Aur bhai kaisa hai?", "08 bje"))
        chatList?.add(Chat("default", "BlaBlaBla", "Aur bhai kaisa hai?", "08 bje"))
        chatList?.add(Chat("default", "BlaBlaBla", "Aur bhai kaisa hai?", "08 bje"))
        chatList?.add(Chat("default", "BlaBlaBla", "Aur bhai kaisa hai?", "08 bje"))
        chatList?.add(Chat("default", "BlaBlaBla", "Aur bhai kaisa hai?", "08 bje"))

        return layout
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChatFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChatFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}