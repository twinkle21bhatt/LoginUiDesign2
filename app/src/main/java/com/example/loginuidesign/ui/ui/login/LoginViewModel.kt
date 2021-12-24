package com.example.loginuidesign.ui.ui.login

import android.app.PendingIntent.getActivity
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.loginuidesign.OTP
import com.example.loginuidesign.R
import com.example.loginuidesign.ui.data.LoginRepository
import com.example.loginuidesign.ui.data.Result
import com.google.firebase.auth.FirebaseAuth
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.ContextCompat.startActivity







//import com.example.loginuidesign.ui.R

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm
    private lateinit var auth: FirebaseAuth

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(email: String, password: String) {
        // can be launched in a separate asynchronous job

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{task ->
                if(task.isSuccessful){
                    _loginResult.value =
                        LoginResult(success = LoggedInUserView(displayName = email))

                }
            }

//        val result = loginRepository.login(email, password)
//
//        if (result is Result.Success) {
//            _loginResult.value =
//                LoginResult(success = LoggedInUserView(displayName = result.data.displayName))
//        } else {
//            _loginResult.value = LoginResult(error = R.string.login_failed)
//        }
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains("@")) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}