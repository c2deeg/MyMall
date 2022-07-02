package com.app.mymall.Activities.StoreDetailActivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.mymall.Activities.RegisterDetailActivity.RegisterDetailActivity
import com.app.mymall.Adapters.FavHorizontalRecyclerAdapter
import com.app.mymall.Adapters.StoreRecyclerAdapter
import com.app.mymall.R
import com.app.mymall.StaticModelClasses.FavHorizontalClass

class StoreDetailActivity : AppCompatActivity(), View.OnClickListener {
    var activity: Activity? = null
    var store_horizontalrecyclerview: RecyclerView? = null
    var img_back: ImageView? = null
    var btn_register: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_detail)
        activity = this
        init()
        listeners()

        var favList: ArrayList<FavHorizontalClass> = ArrayList()
        favList.add(FavHorizontalClass(R.drawable.storespic2))
        favList.add(FavHorizontalClass(R.drawable.storespic3))
        favList.add(FavHorizontalClass(R.drawable.storespic))
        favList.add(FavHorizontalClass(R.drawable.dress))
        favList.add(FavHorizontalClass(R.drawable.dress))
        favList.add(FavHorizontalClass(R.drawable.dress))
        favList.add(FavHorizontalClass(R.drawable.dress))
        favList.add(FavHorizontalClass(R.drawable.dress))
        favList.add(FavHorizontalClass(R.drawable.dress))
        favList.add(FavHorizontalClass(R.drawable.dress))
        favList.add(FavHorizontalClass(R.drawable.dress))
        favList.add(FavHorizontalClass(R.drawable.dress))
        favList.add(FavHorizontalClass(R.drawable.dress))
        favList.add(FavHorizontalClass(R.drawable.dress))
        store_horizontalrecyclerview?.layoutManager =
            GridLayoutManager(activity, 2, RecyclerView.HORIZONTAL, false)
        val storeRecyclerAdapter = StoreRecyclerAdapter(this, favList)
        store_horizontalrecyclerview?.adapter = storeRecyclerAdapter


    }

    private fun init() {
        store_horizontalrecyclerview = findViewById(R.id.store_horizontalrecyclerview)
        img_back = findViewById(R.id.img_back)
        btn_register = findViewById(R.id.btn_register)
    }

    private fun listeners() {
        img_back?.setOnClickListener(this)
        btn_register?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == img_back) {
            finish()
        } else if (v == btn_register) {
            var intent = Intent(activity, RegisterDetailActivity::class.java)
            startActivity(intent)
        }
    }
}