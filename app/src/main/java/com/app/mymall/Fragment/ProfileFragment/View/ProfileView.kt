package com.app.mymall.Fragment.ProfileFragment.View

import android.app.Activity
import androidx.fragment.app.FragmentActivity
import com.app.mymall.Models.Profile.GetProfileData.GetProfileData

interface ProfileView {
    fun showMessage(activity: Activity?, msg: String?)
    fun showDialog(activity: Activity?)
    fun hideDialog()
    fun setData(activity: FragmentActivity, data: GetProfileData?)
}