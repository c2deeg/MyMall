package com.app.mymall.Fragment.CartsFragment

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.mymall.Adapters.CartsRecyclerAdapter
import com.app.mymall.Adapters.RecyclerSizeAdapter
import com.app.mymall.R
import com.app.mymall.StaticModelClasses.CartsModelClass
import com.app.mymall.StaticModelClasses.SizeModelClass


class CartsFragment : Fragment() {
    var activity: Activity? = null
    var cart_recyclerview: RecyclerView? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_carts, container, false)
        activity = getActivity()
        init(view)
        listeners(view)

        var cartsList: ArrayList<CartsModelClass> = ArrayList()
        cartsList.add(CartsModelClass(R.drawable.jacket, "Jackets", "Multicolor", "L", "2", "$300"))
        cartsList.add(CartsModelClass(R.drawable.dress, "Jackets", "Multicolor", "L", "2", "$300"))
        cartsList.add(CartsModelClass(R.drawable.jacket, "Jackets", "Multicolor", "L", "2", "$300"))
        cartsList.add(CartsModelClass(R.drawable.dress, "Jackets", "Multicolor", "L", "2", "$300"))
        cart_recyclerview?.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        val cartsRecyclerAdapter = CartsRecyclerAdapter(requireActivity(), cartsList)
        cart_recyclerview?.adapter = cartsRecyclerAdapter



        return view
    }


    private fun init(view: View?) {
        cart_recyclerview = view?.findViewById(R.id.cart_recyclerview)

    }

    private fun listeners(view: View?) {

    }


}