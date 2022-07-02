package com.app.mymall.Adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.app.mymall.R

class LastDayDealsRecyclerAdapter(var activity: Activity) :
    RecyclerView.Adapter<LastDayDealsRecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LastDayDealsRecyclerAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.lastdaydealsitem, parent, false)
        return LastDayDealsRecyclerAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: LastDayDealsRecyclerAdapter.ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 10
    }


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var cardview: CardView = itemView.findViewById(R.id.cardview)

    }
}