package com.app.mymall.Handler

import com.app.mymall.Models.ResetPassword.ResetPasswordExample
import com.app.mymall.Models.SignUp.SignUpExample

interface ResetPasswordHandler {
    fun onSuccess(resetPasswordExample: ResetPasswordExample?)
    fun onError(message: String?)

}