package com.app.mymall.Activities.RegisterDetailActivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.app.mymall.Activities.BuildYourListing.BuildYourListingActivity
import com.app.mymall.Activities.StorePriceTimeRangeActivity.StorePriceTimeRangeActivity
import com.app.mymall.R

class RegisterDetailActivity : AppCompatActivity(), View.OnClickListener {
    var activity: Activity? = null
    var img_back: ImageView? = null
    var btn_storelisting: Button? = null
    var btn_selableitems: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_detail)
        inits()
        listeners()
    }

    private fun inits() {
        img_back = findViewById(R.id.img_back)
        btn_storelisting = findViewById(R.id.btn_storelisting)
        btn_selableitems = findViewById(R.id.btn_selableitems)

    }

    private fun listeners() {
        img_back?.setOnClickListener(this)
        btn_storelisting?.setOnClickListener(this)
        btn_selableitems?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == img_back) {
            finish()
        } else if (v == btn_storelisting) {
            var intent = Intent(this, StorePriceTimeRangeActivity::class.java)
            startActivity(intent)
        } else if(v==btn_selableitems){
            var intent = Intent(this, StorePriceTimeRangeActivity::class.java)
            startActivity(intent)
        }
    }
}