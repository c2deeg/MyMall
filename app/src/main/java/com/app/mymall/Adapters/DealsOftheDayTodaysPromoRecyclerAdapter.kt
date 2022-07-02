package com.app.mymall.Adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.app.mymall.R

class DealsOftheDayTodaysPromoRecyclerAdapter(var activity: Activity) :
    RecyclerView.Adapter<DealsOftheDayTodaysPromoRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DealsOftheDayTodaysPromoRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dealsofthedaytodayspromoitem, parent, false)
        return DealsOftheDayTodaysPromoRecyclerAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DealsOftheDayTodaysPromoRecyclerAdapter.ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 10
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var cardview: CardView = itemView.findViewById(R.id.cardview)

    }
}