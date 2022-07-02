package com.app.mymall.Adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.mymall.R
import com.app.mymall.StaticModelClasses.SizeModelClass
import com.app.mymall.StaticModelClasses.ViewPagerModelClass

class RecyclerSizeAdapter(private val activity: Activity, private val mList: List<SizeModelClass>) :
    RecyclerView.Adapter<RecyclerSizeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerSizeAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sizelist, parent, false)
        return RecyclerSizeAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerSizeAdapter.ViewHolder, position: Int) {
        var mList: SizeModelClass = mList.get(position)
        holder.tv_size.text = mList.size
    }

    override fun getItemCount(): Int {
        return mList.size
    }


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tv_size: TextView = itemView.findViewById(R.id.tv_size)
    }
}