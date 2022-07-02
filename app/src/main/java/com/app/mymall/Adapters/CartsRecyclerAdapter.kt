package com.app.mymall.Adapters

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.app.mymall.StaticModelClasses.CartsModelClass
import com.app.mymall.StaticModelClasses.ViewPagerModelClass
import android.content.Context
import androidx.appcompat.view.ContextThemeWrapper


class CartsRecyclerAdapter(private  val activity: Activity, private val mList: List<CartsModelClass>):
    RecyclerView.Adapter<CartsRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartsRecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(com.app.mymall.R.layout.cartslist, parent, false)
        return CartsRecyclerAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartsRecyclerAdapter.ViewHolder, position: Int) {
        var mList: CartsModelClass = mList.get(position)
        holder.img_item.setImageResource(mList.img!!)
        holder.tv_itemname.text = mList.itemname
        holder.tv_colortype.text = mList.color
        holder.tv_sizetype.text = mList.size
        holder.tv_quantity.text = mList.quantity
        holder.tv_price.text = mList.price


        holder.img_menu.setOnClickListener(View.OnClickListener { v ->

            val wrapper: Context = ContextThemeWrapper(activity, com.app.mymall.R.style.foodRatingBar)
            val popup = PopupMenu(wrapper, v)

//            val popup = PopupMenu(activity, v)
            popup.menuInflater.inflate(com.app.mymall.R.menu.popup_menu, popup.menu)


            popup.setOnMenuItemClickListener { item ->
                val id = item.itemId
                when (id) {

                }
                true
            }
            popup.show()
        })


    }

    override fun getItemCount(): Int {
        return mList.size
    }


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val img_item: ImageView = itemView.findViewById(com.app.mymall.R.id.img_item)
        val tv_itemname: TextView = itemView.findViewById(com.app.mymall.R.id.tv_itemname)
        val tv_colortype: TextView = itemView.findViewById(com.app.mymall.R.id.tv_colortype)
        val tv_sizetype: TextView = itemView.findViewById(com.app.mymall.R.id.tv_sizetype)
        val tv_quantity: TextView = itemView.findViewById(com.app.mymall.R.id.tv_quantity)
        val tv_price: TextView = itemView.findViewById(com.app.mymall.R.id.tv_price)
        val img_menu: ImageView = itemView.findViewById(com.app.mymall.R.id.img_menu)




    }
}