package com.app.mymall.Activities.SelecroleActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.app.mymall.Activities.LoginActivity.LoginActivity
import com.app.mymall.R

class SelectRoleActivity : AppCompatActivity(), View.OnClickListener {
    var btn_user: Button? = null
    var btn_shopowner: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_role)
        init()
        listeners()


    }

    fun init() {
        btn_user = findViewById(R.id.btn_user)
        btn_shopowner = findViewById(R.id.btn_shopowner)

    }

    fun listeners() {
        btn_user?.setOnClickListener(this)
        btn_shopowner?.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v == btn_user) {
            val mainIntent = Intent(this, LoginActivity::class.java)
            mainIntent.putExtra("username", "user")
            startActivity(mainIntent)
        } else if (v == btn_shopowner) {
            val mainIntent1 = Intent(this, LoginActivity::class.java)
            mainIntent1.putExtra("username", "shopowner")
            startActivity(mainIntent1)
        }
    }
}
