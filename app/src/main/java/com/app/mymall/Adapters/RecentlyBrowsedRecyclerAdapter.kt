package com.app.mymall.Adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.app.mymall.Activities.FavBrowsedShopsDetailActivity.FavBrowsedStoreDetailActivity
import com.app.mymall.R

class RecentlyBrowsedRecyclerAdapter(private val activity: Activity) :
    RecyclerView.Adapter<RecentlyBrowsedRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecentlyBrowsedRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recentlybrowseditems, parent, false)
        return RecentlyBrowsedRecyclerAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecentlyBrowsedRecyclerAdapter.ViewHolder, position: Int) {
        holder.cardview.setOnClickListener {
            var intent  = Intent(activity,FavBrowsedStoreDetailActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return 10
    }


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var cardview:CardView = itemView.findViewById(R.id.cardview)
    }
}