package com.app.mymall.Fragment.EnterOtpFragment.EnterOtpPresenter

import androidx.fragment.app.FragmentActivity
import com.app.mymall.Fragment.EnterOtpFragment.EnterOtpView.EnterOtpView
import com.app.mymall.Fragment.ForogotNewPasswordFragment.ForgotNewPasswordFragment
import com.app.mymall.Handler.EnterOtpHandler
import com.app.mymall.Models.OtpVerification.OtpExample
import com.app.mymall.Utils.CSPreferences
import com.app.mymall.Utils.Utils
import com.app.mymall.Utils.WebServices

class EnterOtpPresenter(
    private val activity: FragmentActivity,
    private val enterOtpView: EnterOtpView
) {


    fun enterOtpMethod(code: String) {
        var token: String? = null
        token = CSPreferences.readString(activity, Utils.TOKEN)
        if (Utils.isNetworkConnected(activity!!)) {
            enterOtpView?.showDialog(activity)
            WebServices.Factory1.getInstance()?.OtpMethod(token, code, object :
                EnterOtpHandler {
                override fun onSuccess(otpExample: OtpExample?) {
                    enterOtpView?.hideDialog()
                    if (otpExample != null) {
                        if (otpExample.getIsSuccess() === true) {
                            enterOtpView?.showMessage(activity, otpExample.getMessage())
                            Utils.loginActivitychangeFragment(activity, ForgotNewPasswordFragment())


                        } else {
                            enterOtpView?.showMessage(activity, otpExample.getMessage())
                        }
                    } else {
                        enterOtpView?.showMessage(activity, otpExample?.getMessage())
                    }
                }

                override fun onError(message: String?) {
                    enterOtpView?.hideDialog()
                    enterOtpView?.showMessage(activity, message)
                }
            })
        }
    }
}