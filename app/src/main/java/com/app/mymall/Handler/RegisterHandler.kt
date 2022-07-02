package com.app.mymall.Handler

import com.app.mymall.Models.Login.LoginExample
import com.app.mymall.Models.SignUp.SignUpExample

interface RegisterHandler {
    fun onSuccess(signUpExample: SignUpExample?)
    fun onError(message: String?)
}