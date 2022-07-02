package com.app.mymall.Fragment.ForogotNewPasswordFragment.View

import android.app.Activity

interface ForgotNewPasswordView {


    fun showMessage(activity: Activity?, msg: String?)
    fun showDialog(activity: Activity?)
    fun hideDialog()
}