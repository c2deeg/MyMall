package com.app.mymall.Fragment.MapsFragment

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.mymall.R


class MapsFragment : Fragment() {
    var activity: Activity? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view= inflater.inflate(R.layout.fragment_maps, container, false)
        initUi(view)
        listeners(view)
        return view
    }



    private fun initUi(view: View?) {

    }

    private fun listeners(view: View?) {

    }


}