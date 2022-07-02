package com.app.mymall.Adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.mymall.Activities.StoreDetailActivity.StoreDetailActivity
import com.app.mymall.R
import com.app.mymall.StaticModelClasses.ViewPagerModelClass

class FavShopsRecyclerAdapter(
    private val activity: Activity,

) :
    RecyclerView.Adapter<FavShopsRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavShopsRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.favshopsitem, parent, false)
        return FavShopsRecyclerAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavShopsRecyclerAdapter.ViewHolder, position: Int) {
        holder.linearlayout.setOnClickListener{
            var intent = Intent(activity,StoreDetailActivity::class.java)
            activity.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return 9
    }


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val img_storepic: ImageView = itemView.findViewById(R.id.img_storepic)
        val tv_storename: TextView = itemView.findViewById(R.id.tv_storename)
        val tv_storeitems: TextView = itemView.findViewById(R.id.tv_storeitems)
        val linearlayout: LinearLayout = itemView.findViewById(R.id.linearlayout)
    }
}