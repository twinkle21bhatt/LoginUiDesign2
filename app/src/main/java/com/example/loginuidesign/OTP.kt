package com.example.loginuidesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
//import com.example.loginuidesign.ui.landing
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.concurrent.TimeUnit

class OTP : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private  var storedVerificationId: String?=""
    private lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)
        auth = Firebase.auth
        var mob = "+9779843709578"



        FirebaseApp.initializeApp(this)
        val button4: TextView = findViewById(R.id.btnVerify)
        val editTextPhone4: TextView = findViewById(R.id.txtOTP)
        val phone: TextView = findViewById(R.id.phone)

        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                Log.d(TAG, "onVerificationCompleted:$credential")
                signInWithPhoneAuthCredential(credential)
            }

            override fun onVerificationFailed(e: FirebaseException) {
                Log.d(TAG, "onVerificationFailed", e)

                if (e is FirebaseAuthInvalidCredentialsException) {

                } else if (e is FirebaseTooManyRequestsException) {

                }
            }

            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken

            ) {
                Log.d(TAG, "onCodeSent:$verificationId")
                storedVerificationId = verificationId
                resendToken = token
            }
        }

        startPhoneNumberVerification(mob)
//        phone.setOnClickListener {
//            startPhoneNumberVerification(mob)
//        }

        button4.setOnClickListener {
            verifyPhoneNumberWithCode(storedVerificationId, editTextPhone4!!.text.toString())
        }





    }
    override fun onStart() {
            super.onStart()
            val currentUser = auth.currentUser
            updateUI(currentUser)
        }

        private fun startPhoneNumberVerification(phoneNumber :String){

            val options = PhoneAuthOptions.newBuilder(auth)
                .setPhoneNumber(phoneNumber)
                .setTimeout(120, TimeUnit.SECONDS)
                .setActivity(this)
                .setCallbacks(callbacks)
                .build()
            PhoneAuthProvider.verifyPhoneNumber(options)


        }

        private fun verifyPhoneNumberWithCode(verificationId: String?, code: String){
            val credential = PhoneAuthProvider.getCredential(verificationId!!, code)
            signInWithPhoneAuthCredential(credential)

        }

        private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential){
          auth.signInWithCredential(credential)
              .addOnCompleteListener(this) {task ->
                  if(task.isSuccessful){
                      Log.d(TAG, "signInWithCredential:sucess")

                      val user = task.result?.user
                      Toast.makeText(this@OTP,
                          " You are logged in successfully",
                          Toast.LENGTH_SHORT
                      ).show()


                      val intent = Intent(this, CompanyInformation::class.java)

                      intent.flags =
                          Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                      intent.putExtra(
                          "user_id",
                          FirebaseAuth.getInstance().currentUser!!.uid
                      )
                      intent.putExtra("email_id", user?.email)
                      startActivity(intent)
                      finish()
                  }else{
                      Log.w(TAG, "SignInWithCredential: failure", task.exception)
                      if(task.exception is FirebaseAuthInvalidCredentialsException){
                          Toast.makeText(this, "Invalid OTP!!!", Toast.LENGTH_SHORT).show()
                      }
                  }
              }

        }

        private fun updateUI(user: FirebaseUser? = auth.currentUser){


        }
        companion object{
            private const val TAG = "MainActivity"
        }

    }


