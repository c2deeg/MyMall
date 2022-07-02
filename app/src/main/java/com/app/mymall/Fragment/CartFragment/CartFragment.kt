package com.app.mymall.Fragment.CartFragment

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import com.app.mymall.Adapters.CartGridViewAdapter
import com.app.mymall.R
import com.app.mymall.StaticModelClasses.CartModelClasses
import androidx.recyclerview.widget.GridLayoutManager


class CartFragment : Fragment() {
    var activity: Activity? = null
    lateinit var cart_gridview: GridView

//    private var arrayList:ArrayList<CartModelClasses> ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_cart, container, false)
        activity = getActivity()
        initUi(view)

        var arrayList: ArrayList<CartModelClasses> = ArrayList()
        arrayList.add(CartModelClasses(R.drawable.men, "10%"))
        arrayList.add(CartModelClasses(R.drawable.imgjean, "10%"))
        arrayList.add(CartModelClasses(R.drawable.jacket, "10%"))
        arrayList.add(CartModelClasses(R.drawable.towel, "10%"))
        arrayList.add(CartModelClasses(R.drawable.jacket, "10%"))
        arrayList.add(CartModelClasses(R.drawable.jacket, "10%"))

//        arrayList = ArrayList()
//        arrayList = setDataList()
//        setDataList()


        val cartadapter = CartGridViewAdapter(requireActivity(), arrayList)

        cart_gridview.adapter = cartadapter

        return view
    }

    private fun initUi(view: View) {
        cart_gridview = view.findViewById(R.id.cart_gridview)
    }

//    private fun setDataList(): ArrayList<CartModelClasses> {
//        var arrayList: ArrayList<CartModelClasses> = ArrayList()
//        arrayList.add(CartModelClasses(R.drawable.men, "10%"))
//        arrayList.add(CartModelClasses(R.drawable.men, "10%"))
//        arrayList.add(CartModelClasses(R.drawable.men, "10%"))
//        return arrayList
//    }


}