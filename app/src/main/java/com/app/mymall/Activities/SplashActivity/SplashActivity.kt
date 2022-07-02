package com.app.mymall.Activities.SplashActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import android.view.WindowManager
import com.app.mymall.Activities.SplashSkipActivity.SplashSkipActivity
import com.app.mymall.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash)




        Handler(Looper.getMainLooper()).postDelayed({
            /* Create an Intent that will start the Menu-Activity. */
            val mainIntent = Intent(this, SplashSkipActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, 3000)
    }
}