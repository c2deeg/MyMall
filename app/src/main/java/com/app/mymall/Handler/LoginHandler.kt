package com.app.mymall.Handler

import com.app.mymall.Models.Login.LoginExample

interface LoginHandler {
    fun onSuccess(loginExample: LoginExample?, acesstoken: String?)
    fun onError(message: String?)
}