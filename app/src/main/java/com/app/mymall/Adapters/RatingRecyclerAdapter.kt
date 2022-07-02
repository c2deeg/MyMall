package com.app.mymall.Adapters

import android.app.Activity
import android.text.method.PasswordTransformationMethod
import android.text.method.SingleLineTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import com.app.mymall.R
import com.app.mymall.StaticModelClasses.RatingRecyclerModelClass
import com.app.mymall.StaticModelClasses.SizeModelClass
import com.ms.square.android.expandabletextview.ExpandableTextView

class RatingRecyclerAdapter(
    private val activity: Activity,
    private val mList: List<RatingRecyclerModelClass>
) :
    RecyclerView.Adapter<RatingRecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RatingRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ratinglist, parent, false)
        return RatingRecyclerAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RatingRecyclerAdapter.ViewHolder, position: Int) {
        var mList: RatingRecyclerModelClass = mList.get(position)
        holder.tv_name.text = mList.name
        holder.tv_date.text = mList.date
        holder.tv_review.text = mList.review

        holder.tv_showmore.setOnClickListener {
            holder.tv_review.maxLines=20
            holder.tv_showmore.text = "ShowLess"
            var flag = true

            if (flag){

                if (holder.tv_review.maxLines==2) {

                    holder.tv_review.maxLines=20
                    holder.tv_showmore.text = "ShowLess"
                } else {
                    holder.tv_review.maxLines=2
                    holder.tv_showmore.text = "ShowMore"
                }

            }else {
                holder.tv_review.maxLines=3
                holder.tv_showmore.text = "Show Less"

            }
            flag = !flag





        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tv_name: TextView = itemView.findViewById(R.id.tv_name)
        val tv_date: TextView = itemView.findViewById(R.id.tv_date)
        val tv_review: TextView = itemView.findViewById(R.id.tv_review)
        val tv_showmore: TextView = itemView.findViewById(R.id.tv_showmore)
        val img_thumb: ImageView = itemView.findViewById(R.id.img_thumb)

        var expTv: ExpandableTextView? = itemView.findViewById<android.view.View?>(R.id.expand_text_view).findViewById<android.view.View?>(R.id.expand_text_view) as ExpandableTextView?
    }
}