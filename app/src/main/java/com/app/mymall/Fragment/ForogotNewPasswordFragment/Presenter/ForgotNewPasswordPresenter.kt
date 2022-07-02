package com.app.mymall.Fragment.ForogotNewPasswordFragment.Presenter

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.app.mymall.Activities.LoginActivity.LoginActivity
import com.app.mymall.Fragment.ForogotNewPasswordFragment.View.ForgotNewPasswordView
import com.app.mymall.Handler.ForgotNewPassHandler
import com.app.mymall.Models.ForgotNewPasssword.ForgotNewPassExample
import com.app.mymall.Utils.CSPreferences
import com.app.mymall.Utils.Utils
import com.app.mymall.Utils.WebServices

class ForgotNewPasswordPresenter(private val activity: FragmentActivity,private val forgotNewPasswordView: ForgotNewPasswordView) {



    fun newpasswodMethod(newpass: String) {
        var token:String?=null
        token = CSPreferences.readString(activity,Utils.TOKEN)
        if (Utils.isNetworkConnected(activity)) {
            forgotNewPasswordView.showDialog(activity)
            WebServices.Factory1.getInstance()
                ?.forgotnewPassword(token,newpass, object : ForgotNewPassHandler {
                    override fun onSuccess(forgotNewPassExample: ForgotNewPassExample?) {
                        forgotNewPasswordView.hideDialog()
                        if (forgotNewPassExample != null) {
                            if (forgotNewPassExample.getIsSuccess() == true) {
                                forgotNewPasswordView.showMessage(activity, forgotNewPassExample.message)
                                var intent = Intent(activity, LoginActivity::class.java)
                                activity.startActivity(intent)
                            }
                        }
                    }

                    override fun onError(message: String?) {
                        forgotNewPasswordView.hideDialog()
                        forgotNewPasswordView.showMessage(activity, message)
                    }

                })
        }

    }
    }
