package com.app.mymall.Fragment.LoginFragment.Presenter

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.app.mymall.Activities.HomeActivity.HomeActivity
import com.app.mymall.Fragment.LoginFragment.View.LoginView
import com.app.mymall.Handler.LoginHandler
import com.app.mymall.Models.Login.LoginExample
import com.app.mymall.Utils.CSPreferences
import com.app.mymall.Utils.Utils
import com.app.mymall.Utils.WebServices

class LoginPresenter(private val activity: FragmentActivity?, private val loginView: LoginView) {
    private var et_mail: String?=null
    private var et_pass: String?=null

    fun loginMethod(et_mail: String, et_pass: String) {
        this.et_mail = et_mail
        this.et_pass = et_pass
        if (Utils.isNetworkConnected(activity!!)) {
            if (checkValidation())
            loginView?.showDialog(activity)
            WebServices.Factory1.getInstance()?.loginMethod(et_mail, et_pass, object : LoginHandler {
                    override fun onSuccess(loginExample: LoginExample?, acesstoken: String?) {
                        loginView?.hideDialog()
                        if (loginExample != null) {
                            if (loginExample.getIsSuccess() === true) {

                                CSPreferences.putString(activity,Utils.TOKEN,acesstoken)
                                Log.d("Checktoken",acesstoken+"")
                                CSPreferences.putString(activity,Utils.USERID,loginExample.data.id)
                                loginView?.showMessage(activity, loginExample.getMessage())
                                var intent = Intent(activity, HomeActivity::class.java)
                                activity?.startActivity(intent)

                            } else {
                                loginView?.showMessage(activity, loginExample.getMessage())
                            }
                        } else {
                            loginView?.showMessage(activity, loginExample?.getMessage())
                        }
                    }

                    override fun onError(message: String?) {
                        loginView?.hideDialog()
                        loginView?.showMessage(activity, message)
                    }
                })

        }


        else {
            Toast.makeText(activity, "Please check internet connection", Toast.LENGTH_SHORT).show()
        }


    }

    private fun checkValidation(): Boolean {
        if (et_mail?.length==0) {
            loginView.showMessage(activity, "Please enter your email")
            return false
        }else if(et_pass?.length==0){
            loginView.showMessage(activity, "Please enter your password")
            return false
        }
       return true
    }


}