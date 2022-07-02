package com.app.mymall.Fragment.ResetPasswordFragment.Presenter

import android.content.Intent
import android.util.Log
import android.widget.EditText
import androidx.fragment.app.FragmentActivity
import com.app.mymall.Activities.HomeActivity.HomeActivity
import com.app.mymall.Fragment.ResetPasswordFragment.View.ResetPasswordView
import com.app.mymall.Handler.LoginHandler
import com.app.mymall.Handler.ResetPasswordHandler
import com.app.mymall.Models.Login.LoginExample
import com.app.mymall.Models.ResetPassword.ResetPasswordExample
import com.app.mymall.Utils.CSPreferences
import com.app.mymall.Utils.Utils
import com.app.mymall.Utils.WebServices

class ResetPresenter(private val activity: FragmentActivity?,private val resetPasswordView: ResetPasswordView) {

    private var et_oldpassword: EditText?=null
    private var et_pass: EditText?=null

    fun resetPasswordMethod(et_oldpassword: EditText?, et_confirmpassword: EditText?) {
        this.et_oldpassword = et_oldpassword
        this.et_pass = et_confirmpassword
        var token:String?=null
        var id :String?=null
        var oldPassword:String?=null
        var newPassword:String?=null
        oldPassword = et_oldpassword?.text.toString().trim()
        newPassword = et_confirmpassword?.text.toString().trim()
        token = CSPreferences.readString(activity,Utils.TOKEN)
        id = CSPreferences.readString(activity,Utils.USERID)
        if (Utils.isNetworkConnected(activity!!)) {
            if (checkValidation())
            resetPasswordView?.showDialog(activity)
            WebServices.Factory1.getInstance()?.resetPassword(token,id,oldPassword, newPassword, object :
                ResetPasswordHandler {
                override fun onSuccess(resetPasswordExample: ResetPasswordExample?) {
                    resetPasswordView?.hideDialog()
                    if (resetPasswordExample != null) {
                        if (resetPasswordExample.getIsSuccess() === true) {
                            resetPasswordView?.showMessage(activity, resetPasswordExample?.getMessage())
                            var intent = Intent(activity, HomeActivity::class.java)
                            activity?.startActivity(intent)

                        }
                    } else {
                        resetPasswordView?.showMessage(activity, resetPasswordExample?.getMessage())
                    }
                }

                override fun onError(message: String?) {
                    resetPasswordView?.hideDialog()
                    resetPasswordView?.showMessage(activity, message)
                }
            })

        }

    }


    private fun checkValidation(): Boolean {
        if (et_oldpassword?.length() ==0) {
            resetPasswordView.showMessage(activity, "Please enter old password")
            return false
        }else if(et_pass?.length() ==0){
            resetPasswordView.showMessage(activity, "Please enter new password")
            return false
        }
        return true
    }
}