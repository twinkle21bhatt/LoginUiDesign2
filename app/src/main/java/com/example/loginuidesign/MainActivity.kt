package com.example.loginuidesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val userId = intent.getStringExtra("user_id")
        val emailId = intent.getStringExtra("email_id")

        val tv_user: TextView = findViewById(R.id.tv_user_id)
        val tv_email: TextView = findViewById(R.id.tv_email_id)
        tv_user.text="User ID :: $userId"

        tv_email.text = "Email ID :: $emailId"
        val btn_logout: TextView = findViewById(R.id.btn_logout)



        btn_logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()

            startActivity(Intent(this@MainActivity, Login::class.java))
            finish()
        }



      }
}