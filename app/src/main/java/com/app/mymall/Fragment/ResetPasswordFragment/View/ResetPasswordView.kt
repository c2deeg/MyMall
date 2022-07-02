package com.app.mymall.Fragment.ResetPasswordFragment.View

import android.app.Activity

interface ResetPasswordView {

    fun showMessage(activity: Activity?, msg: String?)
    fun showDialog(activity: Activity?)
    fun hideDialog()
}