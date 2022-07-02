package com.app.mymall.Adapters

import android.app.Activity
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.mymall.R
import com.app.mymall.StaticModelClasses.ViewPagerModelClass

class ShopRecyclerAdapter(
    private val activity: Activity) :
    RecyclerView.Adapter<ShopRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup,
        viewType: Int
    ): ShopRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.storelistitem, parent, false)
        return ShopRecyclerAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopRecyclerAdapter.ViewHolder, position: Int) {
        holder.img_like.setOnClickListener {
             var mIsFirstTime = true
            if (mIsFirstTime){
                holder.img_like.setColorFilter(Color.RED)
                mIsFirstTime=false;
            }else{
                holder.img_like.setColorFilter(Color.BLUE)
                mIsFirstTime=false;
            }

        }

    }

    override fun getItemCount(): Int {
     return 6
    }


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tv_shopname: TextView = itemView.findViewById(R.id.tv_shopname)
        val img_like: ImageView = itemView.findViewById(R.id.img_like)


    }
}