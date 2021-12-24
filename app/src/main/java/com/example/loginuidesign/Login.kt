package com.example.loginuidesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit
import com.google.firebase.auth.MultiFactorResolver
import com.google.firebase.auth.MultiFactorInfo
import com.google.firebase.auth.FirebaseAuthMultiFactorException










class Login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btn_login: TextView = findViewById(R.id.btn_login)
        val et_login_email: TextView = findViewById(R.id.et_login_email)
        val et_login_password: TextView = findViewById(R.id.et_login_password)


        btn_login.setOnClickListener{
            when{
                TextUtils.isEmpty(et_login_email.text.toString().trim{it <= ' '}) ->{
                    Toast.makeText(
                        this@Login,
                        "please enter email.",
                        Toast.LENGTH_SHORT
                    ).show()


                }

                TextUtils.isEmpty(et_login_password.text.toString().trim{it <= ' '})->{
                    Toast.makeText(this@Login,
                        "please enter password.",
                        Toast.LENGTH_SHORT
                    ).show()

                }
                else ->{

//                    val button3: TextView = findViewById(R.id.button3)
//                    val button4: TextView = findViewById(R.id.button4)
//                    val editTextPhone3: TextView = findViewById(R.id.editTextPhone3)
//                    val editTextPhone4: TextView = findViewById(R.id.editTextPhone4)




                    val email:String = et_login_email.text.toString().trim{it <=' '}
                    val password:String =et_login_password.text.toString().trim {it <=' '}

                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener {task ->
                            if (task.isSuccessful){
                                Toast.makeText(this@Login,
                                    " You are logged in successfully",
                                    Toast.LENGTH_SHORT
                                ).show()
//                                startPhoneNumberVerification("+9779808086831")




                                val intent = Intent (this@Login, OTP::class.java)

                                intent.flags =
                                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                intent.putExtra(
                                    "user_id",
                                    FirebaseAuth.getInstance().currentUser!!.uid
                                )
                                intent.putExtra("email_id", email)
                                startActivity(intent)
                                finish()



                            }else{

                                //if th elogin is not successful then error message.
                                Toast.makeText(this@Login,
                                    "User not Found!!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                        }
                }


            }


        }
    }
    private fun startPhoneNumberVerification(phoneNumber :String){

        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber)
            .setTimeout(601, TimeUnit.SECONDS)
            .setActivity(this)
            .setCallbacks(callbacks)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)


    }
}