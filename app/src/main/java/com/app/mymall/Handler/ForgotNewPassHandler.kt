package com.app.mymall.Handler

import com.app.mymall.Models.ForgotNewPasssword.ForgotNewPassExample
import com.app.mymall.Models.ForgotPassword.ForgotExample

interface ForgotNewPassHandler {
    fun onSuccess(forgotNewPassExample: ForgotNewPassExample?)
    fun onError(message: String?)
}