package com.example.tablayoutapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.tablayoutapp.LoginFragment.Login.EXTRA_PASSWORD
import com.example.tablayoutapp.LoginFragment.Login.EXTRA_USERNAME
import com.example.tablayoutapp.databinding.FragmentLoginBinding
import com.example.tablayoutapp.databinding.FragmentRegisterBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    private lateinit var binding : FragmentLoginBinding
    object Login {
        const val EXTRA_USERNAME = "extra_username"
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
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        with(binding){
            btnLogin.setOnClickListener{
                val username = logUsn.text.toString()
                val password = logPsw.text.toString()
                if(username.isNotEmpty() && password.isNotEmpty()) {
                    val intentToHomePage = Intent(requireActivity(), HomeActivity::class.java)
                    intentToHomePage.putExtra(EXTRA_USERNAME, username)
                    intentToHomePage.putExtra(EXTRA_PASSWORD, password)
                    startActivity(intentToHomePage)
                }else{
                    Toast.makeText(requireActivity(), "Semua kolom harus diisi", Toast.LENGTH_SHORT).show()
                }
            }

            register.setOnClickListener {
                // Akses ViewPager dari MainActivity
                val viewPager = requireActivity().findViewById<ViewPager2>(R.id.view_pager)
                viewPager.currentItem = 0 // Pindah ke halaman Register (index 0)
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
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}