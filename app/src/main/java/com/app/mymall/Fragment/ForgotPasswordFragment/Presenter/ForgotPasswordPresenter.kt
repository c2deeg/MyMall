package com.app.mymall.Fragment.ForgotPasswordFragment.Presenter

import android.widget.EditText
import androidx.fragment.app.FragmentActivity
import com.app.mymall.Fragment.EnterOtpFragment.EnterOtpFragment
import com.app.mymall.Fragment.ForgotPasswordFragment.View.ForgotPasswordView
import com.app.mymall.Handler.ForgotPasswordHandler
import com.app.mymall.Models.ForgotPassword.ForgotExample
import com.app.mymall.Models.Login.LoginExample
import com.app.mymall.Models.Profile.ProfileExample
import com.app.mymall.Utils.CSPreferences
import com.app.mymall.Utils.Utils
import com.app.mymall.Utils.WebServices

class ForgotPasswordPresenter(
    private val activity: FragmentActivity,
    private val forgotPasswordView: ForgotPasswordView
) {
    lateinit var mail: String

    fun forgotPasswordMethod(et_mail: EditText?) {
        mail = et_mail?.text.toString()
        if (Utils.isNetworkConnected(activity)) {
            forgotPasswordView.showDialog(activity)
            WebServices.Factory1.getInstance()
                ?.forgotPasswordMethod(mail, object : ForgotPasswordHandler {
                    override fun onSuccess(forgotPassExample: ForgotExample?) {
                        forgotPasswordView.hideDialog()
                        if (forgotPassExample != null) {
                            if (forgotPassExample.getIsSuccess() == true) {
                                CSPreferences.putString(
                                    activity,
                                    Utils.TOKEN,
                                    forgotPassExample.data.token
                                )
                                forgotPasswordView.showMessage(activity, forgotPassExample.message)
                                Utils.loginActivitychangeFragment(activity, EnterOtpFragment())
                            }
                        }
                    }

                    override fun onError(message: String?) {
                        forgotPasswordView.hideDialog()
                        forgotPasswordView.showMessage(activity, message)
                    }

                })
        }

    }
}