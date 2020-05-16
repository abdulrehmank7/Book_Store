package com.arkapp.bookstore.ui.settings

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.arkapp.bookstore.BuildConfig
import com.arkapp.bookstore.data.authentication.getCurrentUser
import com.arkapp.bookstore.data.authentication.signOut
import com.arkapp.bookstore.data.repository.PrefRepository
import com.arkapp.bookstore.databinding.FragmentSettingBinding
import com.arkapp.bookstore.utils.loadImage
import com.arkapp.bookstore.utils.showAlertDialog

/**
 * A simple [Fragment] subclass.
 */
class SettingFragment : Fragment() {

    private lateinit var binding: FragmentSettingBinding

    private val prefRepository by lazy { PrefRepository(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userData = getCurrentUser()
        binding.userName.text = userData?.displayName
        binding.email.text = userData?.email
        binding.userImg.loadImage(userData?.photoUrl.toString())

        binding.appVersion.text = "version ${BuildConfig.VERSION_NAME}"

        binding.logout.setOnClickListener {
            requireContext().showAlertDialog(
                "Logout",
                "Do you want to logout?",
                "Logout",
                "Cancel",
                DialogInterface.OnClickListener { dialog, _ ->
                    requireActivity().signOut(prefRepository)
                    dialog.dismiss()
                }
            )
        }
    }
}
