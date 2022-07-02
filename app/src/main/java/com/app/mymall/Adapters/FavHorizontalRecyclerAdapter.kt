package com.app.mymall.Adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.app.mymall.R
import com.app.mymall.StaticModelClasses.FavHorizontalClass
import com.app.mymall.StaticModelClasses.RatingRecyclerModelClass

class FavHorizontalRecyclerAdapter(
    private val activity: Activity,
    private val mList: List<FavHorizontalClass>
) :
    RecyclerView.Adapter<FavHorizontalRecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavHorizontalRecyclerAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.favhorizontallist, parent, false)
        return FavHorizontalRecyclerAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavHorizontalRecyclerAdapter.ViewHolder, position: Int) {

        var mList: FavHorizontalClass = mList.get(position)
        holder.img_jacket.setImageResource(mList.imgae!!)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var img_jacket: ImageView = itemView.findViewById(R.id.img_jacket)
    }
}