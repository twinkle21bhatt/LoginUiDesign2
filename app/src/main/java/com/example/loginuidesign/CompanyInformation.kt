package com.example.loginuidesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class CompanyInformation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_information)


        val btn_submit: TextView = findViewById(R.id.btn_submit)
        val et_company_name: TextView = findViewById(R.id.et_company_name)
        val et_location: TextView = findViewById(R.id.et_location)
        val et_address: TextView = findViewById(R.id.et_address)
        val et_contact_no: TextView = findViewById(R.id.et_contact_no)
        val et_email: TextView = findViewById(R.id.et_email)



        btn_submit.setOnClickListener{
            when{
                TextUtils.isEmpty(et_company_name.text.toString().trim{it <= ' '}) ->{
                    Toast.makeText(
                        this@CompanyInformation,
                        "please enter company name.",
                        Toast.LENGTH_SHORT
                    ).show()


                }
                TextUtils.isEmpty(et_location.text.toString().trim{it <= ' '})->{
                    Toast.makeText(this@CompanyInformation,
                        "please enter your Location.",
                        Toast.LENGTH_SHORT
                    ).show()

                }


                TextUtils.isEmpty(et_address.text.toString().trim{it <= ' '})->{
                    Toast.makeText(this@CompanyInformation,
                        "please enter your address.",
                        Toast.LENGTH_SHORT
                    ).show()

                }

                TextUtils.isEmpty(et_contact_no.text.toString().trim{it <= ' '})->{
                    Toast.makeText(this@CompanyInformation,
                        "please enter your contact_no.",
                        Toast.LENGTH_SHORT
                    ).show()

                }

                TextUtils.isEmpty(et_email.text.toString().trim{it <= ' '})->{
                    Toast.makeText(this@CompanyInformation,
                        "please enter your Email.",
                        Toast.LENGTH_SHORT
                    ).show()

                }
//                 else ->{
//
//                    val email:String = et_login_email.text.toString().trim{it <=' '}
//                    val password:String =et_login_password.text.toString().trim {it <=' '}
//
//                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
//                        .addOnCompleteListener {task ->
//                            if (task.isSuccessful){
//                                Toast.makeText(this@Login,
//                                    " You are logged in successfully",
//                                    Toast.LENGTH_SHORT
//                                ).show()
//
//                                val intent =
//
//                                    Intent (this@Login, MainActivity::class.java)
//                                intent.flags =
//                                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//                                intent.putExtra(
//                                    "user_id",
//                                    FirebaseAuth.getInstance().currentUser!!.uid
//                                )
//                                intent.putExtra("email_id", email)
//                                startActivity(intent)
//                                finish()
//
//                            }else{
//
//                                //if the login is not successful then error message.
//                                Toast.makeText(this@Login,
//                                    "User not Found!!",
//                                    Toast.LENGTH_SHORT
//                                ).show()
//                            }
//
//                        }
//                }


            }


        }
    }
}