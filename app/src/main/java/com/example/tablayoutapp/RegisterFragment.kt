
package com.example.tablayoutapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.tablayoutapp.RegisterFragment.Register.EXTRA_EMAIL
import com.example.tablayoutapp.RegisterFragment.Register.EXTRA_PASSWORD
import com.example.tablayoutapp.RegisterFragment.Register.EXTRA_PHONE
import com.example.tablayoutapp.RegisterFragment.Register.EXTRA_USERNAME
import com.example.tablayoutapp.databinding.FragmentRegisterBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
    private lateinit var binding : FragmentRegisterBinding
    object Register {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHONE = "extra_phone"
        const val EXTRA_PASSWORD = "extra_password"
    }

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
        binding = FragmentRegisterBinding.inflate(inflater, container, false)

        with(binding){
            btnRegister.setOnClickListener{
                val username = txtUsn.text.toString()
                val email = txtEmail.text.toString()
                val phone = txtPhone.text.toString()
                val password = txtPsw.text.toString()
                if(username.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty() && password.isNotEmpty() && termsAndCondition.isChecked) {
                    val intentToHomePage = Intent(requireActivity(), HomeActivity::class.java)
                    intentToHomePage.putExtra(EXTRA_USERNAME, username)
                    intentToHomePage.putExtra(EXTRA_EMAIL, email)
                    intentToHomePage.putExtra(EXTRA_PHONE, phone)
                    intentToHomePage.putExtra(EXTRA_PASSWORD, password)
                    startActivity(intentToHomePage)
                }else{
                    Toast.makeText(requireActivity(), "Semua kolom harus diisi", Toast.LENGTH_SHORT).show()
                }
            }
            login.setOnClickListener {
                val viewPager = requireActivity().findViewById<ViewPager2>(R.id.view_pager)
                viewPager.currentItem = 1
            }
        }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegisterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}