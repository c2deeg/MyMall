package com.app.mymall.Activities.LoginActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import com.app.mymall.Fragment.LoginFragment.LoginFragment
import com.app.mymall.R

class LoginActivity : AppCompatActivity() {
    var login_container: FrameLayout? = null
    lateinit var username: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
        username = intent.getStringExtra("username").toString()
        Log.d("checkvalue", username)


        val bundle = Bundle()
        bundle.putString("username", username.toString())
        val fragment = LoginFragment()
        fragment.setArguments(bundle);
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.add(R.id.login_container, fragment)
        transaction.commit()

    }

    fun init() {
        login_container = findViewById(R.id.login_container)


    }


}