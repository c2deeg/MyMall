package com.app.mymall.Activities.FavBrowsedShopsDetailActivity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.mymall.Adapters.FavBrowsedShopListRecyclerviewAdapter
import com.app.mymall.R

class FavBrowsedStoreDetailActivity : AppCompatActivity(), View.OnClickListener {
    var activity:Activity?=null
    var favshopslist_recyclerview:RecyclerView?=null
    var img_back:ImageView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fav_browsed_store_detail)
        activity = this
        init()
        listener()

        favshopslist_recyclerview?.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
        var favBrowsedShopListRecyclerviewAdapter = FavBrowsedShopListRecyclerviewAdapter(this)
        favshopslist_recyclerview?.adapter = favBrowsedShopListRecyclerviewAdapter
    }
    private fun init(){
        favshopslist_recyclerview = findViewById(R.id.favshopslist_recyclerview)
        img_back = findViewById(R.id.img_back)
    }

    private fun listener() {
        img_back?.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        if (v==img_back){
            finish()
        }
    }
}