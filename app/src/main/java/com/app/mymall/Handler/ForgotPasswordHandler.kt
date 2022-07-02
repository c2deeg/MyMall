package com.app.mymall.Handler

import com.app.mymall.Models.ForgotPassword.ForgotExample
import com.app.mymall.Models.Login.LoginExample
import com.app.mymall.Models.Profile.ProfileExample

interface ForgotPasswordHandler {

    fun onSuccess(forgotPasswordExample:  ForgotExample?)
    fun onError(message: String?)
}