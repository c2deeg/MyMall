package com.app.mymall.Adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.mymall.R
import com.app.mymall.StaticModelClasses.FavHorizontalClass
import com.app.mymall.StaticModelClasses.FurnitureModelClass

class FurnitureRecyclerAdapter(
    private val activity: Activity,
    private val mList: List<FurnitureModelClass>
) :
    RecyclerView.Adapter<FurnitureRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FurnitureRecyclerAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.furniturelist, parent, false)
        return FurnitureRecyclerAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FurnitureRecyclerAdapter.ViewHolder, position: Int) {
        var mList: FurnitureModelClass = mList.get(position)
        holder.tv_description.text = mList.description
        holder.tv_discount.text = mList.discount
        holder.tv_date.text = mList.date
        holder.img_item.setImageResource(mList.img!!)

    }

    override fun getItemCount(): Int {
       return mList.size
    }


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var tv_description: TextView = itemView.findViewById(R.id.tv_description)
        var tv_discount: TextView = itemView.findViewById(R.id.tv_discount)
        var tv_date: TextView = itemView.findViewById(R.id.tv_date)
        var img_item: ImageView = itemView.findViewById(R.id.img_item)
    }
}