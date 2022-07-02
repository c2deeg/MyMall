package com.app.mymall.Fragment.FavouritesFragment

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.VideoView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.mymall.Activities.FavBrowsedShopsDetailActivity.FavBrowsedStoreDetailActivity
import com.app.mymall.Adapters.ColorRecyclerViewAdapter
import com.app.mymall.Adapters.FavShopsRecyclerAdapter
import com.app.mymall.Adapters.RecentlyBrowsedRecyclerAdapter
import com.app.mymall.Adapters.StoreRecyclerAdapter

import android.widget.MediaController
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.app.mymall.Fragment.CheckMapFragment.CheckMapFragment
import com.app.mymall.R


class FavouritesFragment : Fragment(), View.OnClickListener {
    var activity: Activity? = null
    var favshop_recyclerview: RecyclerView? = null
    var recentlybrowsed_recyclerview: RecyclerView? = null
    var videoview: VideoView? = null
    var btn_browseall: Button? = null
    var btn_nearyou: Button? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(com.app.mymall.R.layout.fragment_favourites, container, false)
        activity = getActivity()
        inits(view)
        listeners(view)

        favshop_recyclerview?.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val favShopsRecyclerAdapter = FavShopsRecyclerAdapter(requireActivity())
        favshop_recyclerview?.adapter = favShopsRecyclerAdapter

        //recentlybrowsedAdapter

        recentlybrowsed_recyclerview?.layoutManager =
            GridLayoutManager(activity, 2, RecyclerView.HORIZONTAL, false)
        val recentlyBrowsedRecyclerAdapter = RecentlyBrowsedRecyclerAdapter(requireActivity())
        recentlybrowsed_recyclerview?.adapter = recentlyBrowsedRecyclerAdapter

        val videoView = view.findViewById(com.app.mymall.R.id.videoview) as VideoView
        val mediaController = MediaController(activity)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(
            Uri.parse(
                "android.resource://" + activity?.getPackageName()
                    .toString() + "/" + com.app.mymall.R.raw.mallvideo
            )
        )
        videoView.start()

        return view
    }

    //initialize
    private fun inits(view: View) {
        favshop_recyclerview = view.findViewById(R.id.favshop_recyclerview)
        recentlybrowsed_recyclerview = view.findViewById(R.id.recentlybrowsed_recyclerview)
        videoview = view.findViewById(R.id.videoview)
        btn_browseall = view.findViewById(R.id.btn_browseall)
        btn_nearyou = view.findViewById(R.id.btn_nearyou)

    }

    private fun listeners(view: View) {
        btn_browseall?.setOnClickListener(this)
        btn_nearyou?.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v == btn_browseall) {
            var intent = Intent(activity, FavBrowsedStoreDetailActivity::class.java)
            startActivity(intent)
        } else if (v == btn_nearyou) {
            val fragment: Fragment = CheckMapFragment()
            val fragmentManager: FragmentManager = getActivity()!!.supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(android.R.id.content, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }


}