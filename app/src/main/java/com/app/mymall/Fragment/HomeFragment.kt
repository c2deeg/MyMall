package com.app.mymall.Fragment

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.app.mymall.Activities.LoginActivity.LoginActivity
import com.app.mymall.Activities.StoreDetailActivity.StoreDetailActivity
import com.app.mymall.Fragment.CheckMapFragment.CheckMapFragment
import com.app.mymall.Fragment.DealsOfthedayFragment.DealsOfTheDayFragment
import com.app.mymall.Fragment.FavouritesFragment.FavouritesFragment
import com.app.mymall.Fragment.HomeMainFragment.HomeMainFragment
import com.app.mymall.R
import com.google.android.material.navigation.NavigationView
import com.infideap.drawerbehavior.AdvanceDrawerLayout
import com.yarolegovich.slidingrootnav.SlidingRootNav

class HomeFragment : Fragment(), NavigationView.OnNavigationItemSelectedListener,
    View.OnClickListener {
    var activity: Activity? = null
    lateinit var screenTitles: Array<String>
    lateinit var screenIcons: Array<Drawable>
    var slidingRootNav: SlidingRootNav? = null
    var drawer: AdvanceDrawerLayout? = null
    var toggle: ActionBarDrawerToggle? = null
    lateinit var img_drawer: ImageView
    lateinit var navigationView: NavigationView
    lateinit var home_fragmentcontainer: FrameLayout
    lateinit var tv_fav: TextView
    lateinit var tv_nearshop: TextView
    lateinit var tv_registerstore: TextView
    lateinit var tv_deals: TextView
    lateinit var tv_signout: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home, container, false)
        activity = getActivity()
        init(view)
        listeners(view)
        val homeFragmentMain = HomeMainFragment()
        setCurrentFragment(homeFragmentMain)
        val toolbar: Toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        (activity as AppCompatActivity).supportActionBar?.title = "My Title"


        activity?.getWindow()
            ?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN or WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        activity?.getWindow()?.setStatusBarColor(Color.parseColor("#ff33316d"))

        val toggle = ActionBarDrawerToggle(activity, drawer, R.string.app_name, R.string.app_name)

        drawer?.addDrawerListener(toggle!!)
        toggle?.syncState()
        navigationView = view.findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
        var view2 = inflater.inflate(R.layout.navigation_view, container, false)
//        var tv_profile: TextView = view.findViewById(R.id.tx_profil)
//        tv_fav.setOnClickListener {
//            Toast.makeText(activity, "click", Toast.LENGTH_SHORT).show()
//            var intent = Intent(activity,StoreDetailActivity::class.java)
//            startActivity(intent)
//            drawer?.closeDrawers()
//        }


        drawer?.setViewScale(Gravity.START, 0.8f)
        drawer?.setRadius(Gravity.START, 35f)
        drawer?.setViewElevation(Gravity.START, 80f)

        return view
    }


    fun init(view: View) {
        drawer = view.findViewById(R.id.drawer_layout)
        img_drawer = view.findViewById(R.id.img_drawer)
        home_fragmentcontainer = view.findViewById(R.id.home_fragmentcontainer)
        tv_fav = view.findViewById(R.id.tv_fav)
        tv_nearshop = view.findViewById(R.id.tv_nearshop)
        tv_registerstore = view.findViewById(R.id.tv_registerstore)
        tv_deals = view.findViewById(R.id.tv_deals)
        tv_signout = view.findViewById(R.id.tv_signout)
    }


    private fun listeners(view: View?) {
        img_drawer.setOnClickListener(this)
        tv_fav.setOnClickListener(this)
        tv_nearshop.setOnClickListener(this)
        tv_registerstore.setOnClickListener(this)
        tv_deals.setOnClickListener(this)
        tv_signout.setOnClickListener(this)

    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
//            R.id.tv_fav -> Toast.makeText(activity, "vlvvl", Toast.LENGTH_SHORT).show()


        }
        true




        if (item.itemId == R.id.mHome) {


        }
        return false
    }

    override fun onClick(v: View?) {
        if (v == img_drawer) {
            drawer?.openDrawer(navigationView)
        } else if (v == tv_fav) {
            drawer?.closeDrawers()
            setCurrentFragment(FavouritesFragment())
        } else if (v == tv_nearshop) {
            drawer?.closeDrawers()
            setCurrentFragment(CheckMapFragment())
        } else if (v == tv_registerstore) {
            drawer?.closeDrawers()
            var intent = Intent(activity, StoreDetailActivity::class.java)
            startActivity(intent)
        } else if (v == tv_deals) {
            drawer?.closeDrawers()
            Toast.makeText(activity,"clicked",Toast.LENGTH_SHORT).show()
            setCurrentFragment(DealsOfTheDayFragment())
        } else if (v==tv_signout){
            drawer?.closeDrawers()
            showDialog()

        }
    }


    private fun setCurrentFragment(fragment: androidx.fragment.app.Fragment) =
        childFragmentManager.beginTransaction().apply {
            replace(R.id.home_fragmentcontainer, fragment)
            commit()
        }


    private fun showDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.logoutdialog)
        val window = dialog.window
        val wlp = window!!.attributes
        wlp.gravity = Gravity.CENTER
        wlp.flags = wlp.flags and WindowManager.LayoutParams.FLAG_BLUR_BEHIND.inv()
        window.attributes = wlp
        dialog.window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        val btn_signout = dialog.findViewById<View>(R.id.btn_signout) as Button
//        val gender: String = CSPreferences.readString(activity, Utils.GENDERSELECT)

        btn_signout.setOnClickListener {
//            CSPreferences.putString(activity, Utils.USERLOGIN, "false")
            val intent1 = Intent(activity, LoginActivity::class.java)
            startActivity(intent1)

        }
        val btn_cancel = dialog.findViewById<View>(R.id.btn_cancel) as Button
        btn_cancel.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }


}