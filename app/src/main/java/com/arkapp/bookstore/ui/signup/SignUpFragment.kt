package com.arkapp.bookstore.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.arkapp.bookstore.R
import com.arkapp.bookstore.data.database.AppDatabase
import com.arkapp.bookstore.data.database.DatabaseHelper
import com.arkapp.bookstore.data.models.UserLogin
import com.arkapp.bookstore.data.preferences.ENTERED_USER_EMAIL
import com.arkapp.bookstore.data.preferences.ENTERED_USER_NAME
import com.arkapp.bookstore.data.repository.PrefRepository
import com.arkapp.bookstore.databinding.FragmentSignupBinding
import com.arkapp.bookstore.utils.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 */
class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignupBinding

    private val prefRepository by lazy { PrefRepository(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ENTERED_USER_NAME = ""
        ENTERED_USER_EMAIL = ""

        val helper = DatabaseHelper(requireContext(), lifecycleScope)
        helper.addBooksToDB()

        binding.signUpBtn.setOnClickListener {
            if (isDoubleClicked(1000)) return@setOnClickListener
            if (binding.signUpBtn.text == getString(R.string.sign_up)) {
                binding.signUpBtn.text = getString(R.string.login)
                binding.signUpDesc.text = getString(R.string.already_have_account)

                binding.loginCard.hide()
                binding.signUpCard.show()

                binding.userNameEt.text?.clear()
                binding.passwordEt.text?.clear()

                binding.userName.error = null
                binding.password.error = null

            } else {
                binding.signUpBtn.text = getString(R.string.sign_up)
                binding.signUpDesc.text = getString(R.string.not_have_an_account)

                binding.signUpCard.hide()
                binding.loginCard.show()

                binding.signUpUserNameEt.text?.clear()
                binding.signUpPasswordEt.text?.clear()
                binding.signUpConfirmPasswordEt.text?.clear()

                binding.signUpUserName.error = null
                binding.signUpPassword.error = null
                binding.signUpConfirmPassword.error = null
            }
        }

        binding.loginBtn.setOnClickListener {
            if (isDoubleClicked(1000)) return@setOnClickListener
            binding.loginProgress.show()
            requireActivity().window.disableTouch()
            onLoginClicked()
        }

        binding.insideSignUpBtn.setOnClickListener {
            if (isDoubleClicked(1000)) return@setOnClickListener
            binding.signupProgress.show()
            requireActivity().window.disableTouch()
            onSignUpClicked()
        }

        removeErrorOnChange()
    }

    private fun removeErrorOnChange() {
        binding.userNameEt.doAfterTextChanged { binding.userName.error = null }
        binding.passwordEt.doAfterTextChanged { binding.password.error = null }
        binding.signUpUserNameEt.doAfterTextChanged { binding.signUpUserName.error = null }
        binding.signUpEmailEt.doAfterTextChanged { binding.signUpEmail.error = null }
        binding.signUpPasswordEt.doAfterTextChanged { binding.signUpPassword.error = null }
        binding.signUpConfirmPasswordEt.doAfterTextChanged {
            binding.signUpConfirmPassword.error = null
        }
    }


    private fun onLoginClicked() {
        if (binding.userNameEt.text!!.isEmpty()) {
            binding.userName.error = "Username required!"

            binding.loginProgress.hide()
            requireActivity().window.enableTouch()
            return
        }

        if (binding.passwordEt.text!!.isEmpty()) {
            binding.password.error = "Password required!"

            binding.loginProgress.hide()
            requireActivity().window.enableTouch()
            return
        }

        checkCredentials()
    }

    private fun checkCredentials() {
        lifecycleScope.launch(Dispatchers.Main) {

            val userLoginDao = AppDatabase.getDatabase(requireContext()).userLoginDao()

            val userData =
                if (binding.userNameEt.value().isEmailValid()) {
                    ENTERED_USER_EMAIL = binding.userNameEt.value()

                    userLoginDao.getLoggedInUserEmail(
                        binding.userNameEt.value(),
                        binding.passwordEt.value()
                    )
                } else {
                    ENTERED_USER_NAME = binding.userNameEt.value()
                    userLoginDao.getLoggedInUser(
                        binding.userNameEt.value(),
                        binding.passwordEt.value()
                    )
                }
            if (userData.isEmpty()) {
                requireContext().toast("Login failed!")
                binding.userName.error = "Check username and password!"
                binding.loginProgress.hide()
                requireActivity().window.enableTouch()
            } else {
                delay(1000)
                binding.loginProgress.hide()
                requireActivity().window.enableTouch()
                onLoginSuccess()
            }
        }
    }

    private fun onSignUpClicked() {
        if (binding.signUpUserNameEt.text!!.isEmpty()) {
            binding.signUpUserName.error = "Username required!"

            binding.signupProgress.hide()
            requireActivity().window.enableTouch()
            return
        }

        if (binding.signUpEmailEt.text!!.isEmpty()) {
            binding.signUpEmail.error = "Email required!"

            binding.signupProgress.hide()
            requireActivity().window.enableTouch()
            return
        }

        if (binding.signUpUserNameEt.text!!.length < 3) {
            binding.signUpUserName.error = "Invalid Username!"

            binding.signupProgress.hide()
            requireActivity().window.enableTouch()
            return
        }

        if (!binding.signUpEmailEt.value().isEmailValid()) {
            binding.signUpEmail.error = "Invalid Email!"

            binding.signupProgress.hide()
            requireActivity().window.enableTouch()
            return
        }

        if (binding.signUpPasswordEt.text!!.isEmpty()) {
            binding.signUpPassword.error = "Password required!"

            binding.signupProgress.hide()
            requireActivity().window.enableTouch()
            return
        }

        if (binding.signUpPasswordEt.text!!.length < 3) {
            binding.signUpPassword.error = "Invalid Password! Length should be more than 4"

            binding.signupProgress.hide()
            requireActivity().window.enableTouch()
            return
        }

        if (binding.signUpConfirmPasswordEt.text!!.isEmpty()) {
            binding.signUpConfirmPassword.error = "Password required!"

            binding.signupProgress.hide()
            requireActivity().window.enableTouch()
            return
        }

        if (binding.signUpConfirmPasswordEt.value() != binding.signUpPasswordEt.value()) {
            binding.signUpConfirmPassword.error = "Password incorrect!"

            binding.signupProgress.hide()
            requireActivity().window.enableTouch()
            return
        }

        checkIfAccountExist()
    }

    private fun checkIfAccountExist() {
        lifecycleScope.launch(Dispatchers.Main) {
            val userLoginDao = AppDatabase.getDatabase(requireContext()).userLoginDao()

            val userData =
                userLoginDao.checkLoggedInUser(binding.signUpUserNameEt.value())

            val userDataEmail =
                userLoginDao.checkLoggedInUserEmail(binding.signUpEmailEt.value())



            when {
                userData.isNotEmpty() -> {
                    requireContext().toast("Signup failed!")
                    binding.signUpUserName.error = "Username already exits!"

                    binding.signupProgress.hide()
                    requireActivity().window.enableTouch()
                }
                userDataEmail.isNotEmpty() -> {
                    requireContext().toast("Signup failed!")
                    binding.signUpEmail.error = "Email already exits!"

                    binding.signupProgress.hide()
                    requireActivity().window.enableTouch()
                }
                else -> storeCredentials()
            }
        }
    }


    private fun storeCredentials() {
        lifecycleScope.launch(Dispatchers.Main) {
            val userLoginDao = AppDatabase.getDatabase(requireContext()).userLoginDao()

            userLoginDao.insert(
                UserLogin(
                    null,
                    binding.signUpUserNameEt.value(),
                    binding.signUpEmailEt.value(),
                    binding.signUpPasswordEt.value()
                )
            )

            ENTERED_USER_NAME = binding.signUpUserNameEt.value()
            ENTERED_USER_EMAIL = binding.signUpEmailEt.value()

            delay(1000)
            binding.signupProgress.hide()
            requireActivity().window.enableTouch()

            onLoginSuccess()
        }
    }

    private fun onLoginSuccess() {
        requireContext().toast("Login success")
        prefRepository.setLoggedIn(true)
        findNavController().navigate(R.id.action_signUpFragment_to_splashFragment)
    }
}
