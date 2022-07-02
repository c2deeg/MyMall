package com.app.mymall.Adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.app.mymall.R
import com.app.mymall.StaticModelClasses.CartModelClasses
import com.app.mymall.StaticModelClasses.ViewPagerModelClass

class ScreenSlidePagerAdapter(private val activity:Activity, private val arrayList: List<ViewPagerModelClass>) :
    RecyclerView.Adapter<ScreenSlidePagerAdapter.Pager2ViewHolder>() {
    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img_viewpager: ImageView = itemView.findViewById(R.id.img_viewpager)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScreenSlidePagerAdapter.Pager2ViewHolder {
return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.viewpageritem,parent,false))
    }

    override fun onBindViewHolder(holder: ScreenSlidePagerAdapter.Pager2ViewHolder, position: Int) {

        var arrayList :ViewPagerModelClass = arrayList.get(position)

        holder.img_viewpager.setImageResource(arrayList.imgae!!)
    }

    override fun getItemCount(): Int {
       return arrayList.size
    }

}