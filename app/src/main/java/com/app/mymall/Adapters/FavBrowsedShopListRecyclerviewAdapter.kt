package com.app.mymall.Adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.mymall.R

class FavBrowsedShopListRecyclerviewAdapter(private var activity: Activity) :
    RecyclerView.Adapter<FavBrowsedShopListRecyclerviewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavBrowsedShopListRecyclerviewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.favbrowsedstorelist, parent, false)
        return FavBrowsedShopListRecyclerviewAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavBrowsedShopListRecyclerviewAdapter.ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 8
    }


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

    }
}