package com.arkapp.bookstore.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.arkapp.bookstore.BuildConfig
import com.arkapp.bookstore.R
import com.arkapp.bookstore.data.authentication.getCurrentUser
import com.arkapp.bookstore.data.repository.PrefRepository
import com.arkapp.bookstore.databinding.FragmentSettingBinding
import com.arkapp.bookstore.utils.initVerticalAdapter
import com.arkapp.bookstore.utils.loadImage

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

        val titles = arrayOf(
            "Most Searched",
            "Best Seller",
            "New Arrival",
            "Logout"
        )
        val icons = arrayOf(
            R.drawable.ic_search,
            R.drawable.ic_whatshot,
            R.drawable.ic_new_releases,
            R.drawable.ic_exit
        )

        val adapter = SettingAdapter(
            requireActivity(),
            titles,
            icons,
            prefRepository,
            findNavController()
        )
        binding.settingRv.initVerticalAdapter(adapter, true)

    }
}
