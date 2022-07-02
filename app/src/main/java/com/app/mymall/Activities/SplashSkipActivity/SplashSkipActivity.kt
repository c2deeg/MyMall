package com.app.mymall.Activities.SplashSkipActivity

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import com.app.mymall.Activities.SelecroleActivity.SelectRoleActivity
import com.app.mymall.R

class SplashSkipActivity : AppCompatActivity(), View.OnClickListener {

    var tv_skip: TextView? = null
    var img_arrowforward: ImageView? = null
    private  val TAG = "Gestures"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_splash_skip)
        init()
        listener()








    }






    fun init() {
        tv_skip = findViewById<TextView>(R.id.tv_skip) as TextView
        img_arrowforward = findViewById(R.id.img_arrowforward)


    }

    fun listener() {
        tv_skip!!.setOnClickListener(this)
        img_arrowforward!!.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v == tv_skip) {
            val mainIntent = Intent(this, SelectRoleActivity::class.java)
            startActivity(mainIntent)
        } else if (v == img_arrowforward) {
            val mainIntent1 = Intent(this, SelectRoleActivity::class.java)
            startActivity(mainIntent1)

        }
    }
}