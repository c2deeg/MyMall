package com.app.mymall.Handler

import com.app.mymall.Models.ForgotPassword.ForgotExample
import com.app.mymall.Models.OtpVerification.OtpExample

interface EnterOtpHandler {

    fun onSuccess(otpExample: OtpExample?)
    fun onError(message: String?)
}