package com.app.mymall.Fragment.SignUpFragment.View

import android.app.Activity

interface SignUpView {
    fun showMessage(activity: Activity?, msg: String?)
    fun showDialog(activity: Activity?)
    fun hideDialog()
}