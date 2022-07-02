package com.app.mymall.Activities.HomeActivity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import com.app.mymall.Fragment.CartFragment.CartFragment
import com.app.mymall.Fragment.CartsFragment.CartsFragment
import com.app.mymall.Fragment.CheckMapFragment.CheckMapFragment
import com.app.mymall.Fragment.HomeFragment
import com.app.mymall.Fragment.HomeMainFragment.HomeMainFragment
import com.app.mymall.Fragment.ProfileFragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.view.Window

import androidx.core.content.ContextCompat

import android.view.WindowManager
import com.app.mymall.Fragment.FavouritesFragment.FavouritesFragment
import com.app.mymall.R


class HomeActivity : AppCompatActivity(), View.OnClickListener {
    var bottomnavigation: BottomNavigationView? = null
    var home_container: FrameLayout? = null
    var fab: FloatingActionButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        statusBarColor()
        super.onCreate(savedInstanceState)
        setContentView(com.app.mymall.R.layout.activity_home)


        val window: Window = this.getWindow()

// clear FLAG_TRANSLUCENT_STATUS flag:

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

// finally change the color

// finally change the color
        window.statusBarColor = ContextCompat.getColor(this, R.color.black)
//        window.setStatusBarColor(ContextCompat.getColor(this, com.app.mymall.R.color.black))


        var homeMainFragment = HomeMainFragment()
        val homeFragment = HomeFragment()
        setCurrentFragment(homeFragment)

        val supportFragment = CheckMapFragment()
        val cartFragment = CartsFragment()
        val profileFragment = ProfileFragment()
        val favFragment = CartFragment()
        init()
        listners()
        bottomnavigation = findViewById(R.id.bottomNavigationView)
        bottomnavigation?.setBackgroundDrawable(null)



        bottomnavigation?.setOnNavigationItemSelectedListener setOnNavigationItemSelectedListener@{
            when (it.itemId) {
                R.id.mHome -> setCurrentFragment(homeFragment)
                R.id.mLocation -> setCurrentFragment(supportFragment)
                R.id.mLocation -> setCurrentFragment(cartFragment)
                R.id.mcart -> setCurrentFragment(cartFragment)
                R.id.mProfile -> setCurrentFragment(profileFragment)
            }
            true


        }


    }

    private fun statusBarColor() {
        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.black)
        }
    }

    private fun listners() {
        fab?.setOnClickListener(this)
    }

    private fun init() {
        home_container = findViewById(R.id.home_container)
        fab = findViewById(R.id.fab)

    }

    private fun setCurrentFragment(fragment: androidx.fragment.app.Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.home_container, fragment)
            commit()
        }

    override fun onClick(v: View?) {
        if (v == fab) {
            val favFragment = FavouritesFragment()

            setCurrentFragment(favFragment)
        }
    }

}








