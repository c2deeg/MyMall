package com.app.mymall.Adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.app.mymall.R
import com.app.mymall.StaticModelClasses.ViewPagerModelClass

class ColorRecyclerViewAdapter(private  val activity: Activity,private val mList: List<ViewPagerModelClass>) :
    RecyclerView.Adapter<ColorRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): ColorRecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.storelistitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ColorRecyclerViewAdapter.ViewHolder, position: Int) {

        var mList: ViewPagerModelClass = mList.get(position)

        holder.imageView.setImageResource(mList.imgae!!)
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.img_color)
    }
}