package com.example.pg.fragments

import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.pg.R
import com.example.pg.model.LoginInfo
import com.example.pg.model.User
import com.google.android.material.floatingactionbutton.FloatingActionButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    lateinit var name: TextView
    lateinit var addBioFAB: FloatingActionButton
    lateinit var bioTextView: TextView
    lateinit var desigantionTextView: TextView

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name = view.findViewById(R.id.nameProfile)
        name.text = User.name

        bioTextView = view.findViewById(R.id.bioTextView)
        bioTextView.text = LoginInfo.getBio(User.name)

        desigantionTextView = view.findViewById(R.id.designationTextView)
        desigantionTextView.text = LoginInfo.getDesignation(User.name)
        addBioFAB = view.findViewById(R.id.addBioFAB)
        addBioFAB.setOnClickListener {
            showBioDialog()
        }
    }

    fun showBioDialog() {
        val dialog = AlertDialog.Builder(activity!!)
        dialog.setTitle("Add Bio")
        val input = EditText(activity!!)
        input.inputType = InputType.TYPE_CLASS_TEXT
        dialog.setView(input)
        dialog.setPositiveButton("Add") { dialog, _->
            User.bio = input.text.toString()
            LoginInfo.addBio(User.name, User.bio)
            bioTextView.text = User.bio
            dialog.dismiss()
            showDesignationDialog()
        }
        dialog.show()
    }

    private fun showDesignationDialog() {
        val dialog = AlertDialog.Builder(activity!!)
        dialog.setTitle("Add Designation")
        val input = EditText(activity!!)
        input.inputType = InputType.TYPE_CLASS_TEXT
        dialog.setView(input)
        dialog.setPositiveButton("Add") { dialog, _->
            User.designation = input.text.toString()
            desigantionTextView.text = User.designation
            LoginInfo.addDesignation(User.name, User.designation)
            dialog.dismiss()
        }
        dialog.show()
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}