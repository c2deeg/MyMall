package com.app.mymall.Fragment.DealsOfthedayFragment

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.mymall.Adapters.DealsOftheDayTodaysPromoRecyclerAdapter
import com.app.mymall.Adapters.DealsoftheDayClothesRecyclerAdapter
import com.app.mymall.Adapters.LastDayDealsRecyclerAdapter
import com.app.mymall.R

class DealsOfTheDayFragment : Fragment() {
    var activity: Activity? = null
    var recyclerviewclothes: RecyclerView? = null
    var recyclerviewtodayspromo: RecyclerView? = null
    var recyclerviewlastday: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_deals_of_the_day, container, false)
        activity = getActivity()
        init(view)
        listeners(view)
        //clothesAdapter
        recyclerviewclothes?.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        var dealsoftheclothesAdapter = DealsoftheDayClothesRecyclerAdapter(requireActivity())
        recyclerviewclothes?.adapter = dealsoftheclothesAdapter

        //dealsofthedayTodaysPromoRecyclerAdapter
        recyclerviewtodayspromo?.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        var dealsOftheDayTodaysPromoRecyclerAdapter =
            DealsOftheDayTodaysPromoRecyclerAdapter(requireActivity())
        recyclerviewtodayspromo?.adapter = dealsOftheDayTodaysPromoRecyclerAdapter

        //lastdaydealsRecyclerAdapter
        recyclerviewlastday?.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val lastDayDealsRecyclerAdapter = LastDayDealsRecyclerAdapter(requireActivity())
        recyclerviewlastday?.adapter = lastDayDealsRecyclerAdapter
        return view
    }


    private fun init(view: View?) {
        recyclerviewclothes = view?.findViewById(R.id.recyclerviewclothes)
        recyclerviewtodayspromo = view?.findViewById(R.id.recyclerviewtodayspromo)
        recyclerviewlastday = view?.findViewById(R.id.recyclerviewlastday)

    }


    private fun listeners(view: View?) {

    }


}