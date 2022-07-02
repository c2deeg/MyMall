package com.app.mymall.Fragment.SignUpFragment.Presenter

import android.content.Intent
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.app.mymall.Activities.HomeActivity.HomeActivity
import com.app.mymall.Fragment.SignUpFragment.View.SignUpView
import com.app.mymall.Handler.RegisterHandler
import com.app.mymall.Models.SignUp.SignUpExample
import com.app.mymall.Utils.Utils
import com.app.mymall.Utils.WebServices

class SignUpPresenter(private val activity: FragmentActivity, private val signUpView: SignUpView) {
    lateinit var email: String
    lateinit var username: String
    lateinit var dob: String
    lateinit var password: String

    fun signUpMethod(
        et_mail: EditText?,
        et_username: EditText?,
        tv_seldob: TextView?,
        et_pass: EditText?
    ) {
        email = et_mail?.text.toString()
        username = et_username?.text.toString()
        dob = tv_seldob?.text?.toString().toString()
        password = et_pass?.text.toString()
        if (checkValidation())
        if (Utils.isNetworkConnected(activity!!)) {
            signUpView.showDialog(activity)
            WebServices.Factory1.getInstance()
                ?.signupMethod(email, username, dob, password, object : RegisterHandler {
                    override fun onSuccess(signUpExample: SignUpExample?) {
                        signUpView.hideDialog()
                        if (signUpExample != null) {
                            if (signUpExample.getIsSuccess() === true) {
                                signUpView.showMessage(activity, signUpExample.message)
                                var intent = Intent(activity, HomeActivity::class.java)
                                activity?.startActivity(intent)
                            }
                        } else {
                            signUpView.showMessage(activity, signUpExample?.getMessage())
                        }
                    }

                    override fun onError(message: String?) {
                        signUpView.showMessage(activity, message)
                    }

                })
        }
    }


    private fun checkValidation(): Boolean {
        if (email.length==0) {
            signUpView.showMessage(activity, "Please enter your email")
            return false
        }else if(username.length==0){
            signUpView.showMessage(activity, "Please enter your name")
            return false
        } else if (password.length==0){
            signUpView.showMessage(activity,"Please enter Password")
            return false
        }else if (dob.length==0){
            signUpView.showMessage(activity,"Please select your Date of birth")
            return false
        }
        return true
    }

}