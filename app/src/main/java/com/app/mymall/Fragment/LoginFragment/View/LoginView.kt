package com.app.mymall.Fragment.LoginFragment.View

import android.app.Activity

interface LoginView {
    fun showMessage(activity: Activity?, msg: String?)
    fun showDialog(activity: Activity?)
    fun hideDialog()
}