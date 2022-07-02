package com.app.mymall.Fragment.EnterOtpFragment.EnterOtpView

import android.app.Activity

interface EnterOtpView {

    fun showMessage(activity: Activity?, msg: String?)
    fun showDialog(activity: Activity?)
    fun hideDialog()
}