package com.arkapp.bookstore.ui.splash

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.arkapp.bookstore.R
import com.arkapp.bookstore.data.repository.PrefRepository
import com.arkapp.bookstore.utils.hide
import kotlinx.android.synthetic.main.fragment_splash.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val prefRepository by lazy { PrefRepository(requireContext()) }
    private lateinit var backListener: OnBackPressedCallback

    private fun initSignUpBtn() {
        if (!prefRepository.setLoggedIn()) {
            signUpBtn.setOnClickListener {
                findNavController().navigate(R.id.action_splashFragment_to_signUpFragment)
            }
        } else
            signUpBtn.hide()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSignUpBtn()

        backListener = requireActivity()
            .onBackPressedDispatcher
            .addCallback(this) {
                this.remove()
                requireActivity().finish()
            }

    }

    override fun onStart() {
        super.onStart()

        loadSplash()
    }

    override fun onDestroy() {
        super.onDestroy()
        backListener.remove()
    }

    private fun loadSplash() {
        CoroutineScope(Dispatchers.Main).launch {
            delay(1000)
            if (prefRepository.setLoggedIn())
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        }
    }
}
