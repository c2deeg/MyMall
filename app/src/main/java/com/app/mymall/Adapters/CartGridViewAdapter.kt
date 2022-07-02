package com.app.mymall.Adapters

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.app.mymall.Activities.StoreDetailActivity.StoreDetailActivity
import com.app.mymall.R
import com.app.mymall.StaticModelClasses.CartModelClasses

internal class CartGridViewAdapter(
     private val activity: Activity, private val arrayList: List<CartModelClasses>) : BaseAdapter() {

    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(postion: Int): Any {
        return arrayList.get(postion)
    }

    override fun getItemId(postion: Int): Long {
        return postion.toLong()
    }

    override fun getView(postion: Int, convertview: View?, parent: ViewGroup?): View {

        var view :View = View.inflate(activity,R.layout.cartviewlist,null)
        var img_item :ImageView = view.findViewById(R.id.img_item)
        var tv_percentage :TextView = view.findViewById(R.id.tv_percentage)

        var cartList :CartModelClasses = arrayList.get(postion)
        img_item.setImageResource(cartList.imgae!!)
        tv_percentage.text = cartList.percentage
        img_item.setOnClickListener {
            val mainIntent1 = Intent(activity, StoreDetailActivity::class.java)
            activity.startActivity(mainIntent1)
        }

        return view
    }


}