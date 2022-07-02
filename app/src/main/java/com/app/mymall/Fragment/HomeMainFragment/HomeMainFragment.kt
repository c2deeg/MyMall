package com.app.mymall.Fragment.HomeMainFragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.mymall.Adapters.FavHorizontalRecyclerAdapter
import com.app.mymall.Adapters.RecyclerSizeAdapter
import com.app.mymall.R
import com.app.mymall.StaticModelClasses.FavHorizontalClass
import com.app.mymall.StaticModelClasses.SizeModelClass
import androidx.recyclerview.widget.DividerItemDecoration
import com.app.mymall.Activities.RegisterDetailActivity.RegisterDetailActivity
import com.app.mymall.Adapters.FurnitureRecyclerAdapter
import com.app.mymall.StaticModelClasses.FurnitureModelClass
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.app.mymall.Fragment.CheckMapFragment.CheckMapFragment
import com.app.mymall.Fragment.FavouritesFragment.FavouritesFragment


class HomeMainFragment : Fragment(), View.OnClickListener {
    var activity: Activity? = null
    lateinit var fav_horizontalrecyclerview: RecyclerView
    lateinit var furniture_recyclerview: RecyclerView
    lateinit var btn_register: Button
    lateinit var btn_shopfav: Button
    lateinit var btn_nearyou: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home_main, container, false)
        activity = getActivity()
        init(view)
        listeners(view)
        //FavRecyclerviewHorizontalR
        var favList: ArrayList<FavHorizontalClass> = ArrayList()
        favList.add(FavHorizontalClass(R.drawable.dress))
        favList.add(FavHorizontalClass(R.drawable.dress))
        favList.add(FavHorizontalClass(R.drawable.dress))
        favList.add(FavHorizontalClass(R.drawable.dress))
        favList.add(FavHorizontalClass(R.drawable.dress))
        favList.add(FavHorizontalClass(R.drawable.dress))
        favList.add(FavHorizontalClass(R.drawable.dress))
        favList.add(FavHorizontalClass(R.drawable.dress))
        favList.add(FavHorizontalClass(R.drawable.dress))
        favList.add(FavHorizontalClass(R.drawable.dress))
        favList.add(FavHorizontalClass(R.drawable.dress))
        favList.add(FavHorizontalClass(R.drawable.dress))
        favList.add(FavHorizontalClass(R.drawable.dress))
        favList.add(FavHorizontalClass(R.drawable.dress))
        fav_horizontalrecyclerview.layoutManager =
            GridLayoutManager(this.context, 2, RecyclerView.HORIZONTAL, false)
        val favHorizontalRecyclerAdapter = FavHorizontalRecyclerAdapter(requireActivity(), favList)
        fav_horizontalrecyclerview.adapter = favHorizontalRecyclerAdapter

        //FurnitureRecyclerView
        var furnitureList: ArrayList<FurnitureModelClass> = ArrayList()
        furnitureList.add(
            FurnitureModelClass(
                "All furniture items available here",
                "30%",
                "30December 2021",
                R.drawable.chair2
            )
        )
        furnitureList.add(
            FurnitureModelClass(
                "All furniture items available here",
                "30%",
                "30Dec 2021",
                R.drawable.chair3
            )
        )
        furnitureList.add(
            FurnitureModelClass(
                "All furniture items available here",
                "30%",
                "30Dec 2021",
                R.drawable.chair3
            )
        )
        furnitureList.add(
            FurnitureModelClass(
                "All furniture items available here",
                "30%",
                "30Dec 2021",
                R.drawable.chair3
            )
        )
        furniture_recyclerview.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val furnitureRecyclerAdapter = FurnitureRecyclerAdapter(requireActivity(), furnitureList)
        furniture_recyclerview.adapter = furnitureRecyclerAdapter


        return view;
    }

    fun init(view: View) {
        fav_horizontalrecyclerview = view.findViewById(R.id.fav_horizontalrecyclerview)
        furniture_recyclerview = view.findViewById(R.id.furniture_recyclerview)
        btn_register = view.findViewById(R.id.btn_register)
        btn_shopfav = view.findViewById(R.id.btn_shopfav)
        btn_nearyou = view.findViewById(R.id.btn_nearyou)

    }

    fun listeners(view: View?) {
        btn_register.setOnClickListener(this)
        btn_shopfav.setOnClickListener(this)
        btn_nearyou.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v==btn_register){
            var intent = Intent(activity,RegisterDetailActivity::class.java)
            startActivity(intent)
        }else if(v==btn_shopfav){
            val fragment: Fragment = FavouritesFragment()
            val fragmentManager: FragmentManager = getActivity()!!.supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(android.R.id.content, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()

        } else if (v==btn_nearyou){
            val fragment: Fragment = CheckMapFragment()
            val fragmentManager: FragmentManager = getActivity()!!.supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(android.R.id.content, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }

}