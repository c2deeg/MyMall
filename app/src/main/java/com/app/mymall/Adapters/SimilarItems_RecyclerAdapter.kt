package com.app.mymall.Adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.mymall.R
import com.app.mymall.StaticModelClasses.SimilarItemsModelClass
import com.app.mymall.StaticModelClasses.ViewPagerModelClass

class SimilarItems_RecyclerAdapter(private  val activity: Activity, private val mList: List<SimilarItemsModelClass>): RecyclerView.Adapter<SimilarItems_RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarItems_RecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.similaritemlist, parent, false)
        return SimilarItems_RecyclerAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: SimilarItems_RecyclerAdapter.ViewHolder, position: Int) {
        var mList: SimilarItemsModelClass = mList.get(position)
        holder.img_item.setImageResource(mList.imgae!!)
        holder.tv_name.text = mList.name
        holder.tv_price.text = mList.price
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val img_item: ImageView = itemView.findViewById(R.id.img_item)
        val img_fav: ImageView = itemView.findViewById(R.id.img_fav)
        val tv_name: TextView = itemView.findViewById(R.id.tv_name)
        val tv_price: TextView = itemView.findViewById(R.id.tv_price)
    }
}