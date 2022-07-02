package com.app.mymall.Fragment.ForgotPasswordFragment.View

import android.app.Activity

interface ForgotPasswordView {
    fun showMessage(activity: Activity?, msg: String?)
    fun showDialog(activity: Activity?)
    fun hideDialog()
}