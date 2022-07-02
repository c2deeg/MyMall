package com.app.mymall.Handler

import com.app.mymall.Models.ForgotPassword.ForgotExample
import com.app.mymall.Models.Profile.GetProfileData.GetProfileExample

interface GetProfiledataHandler {
    fun onSuccess(getProfileExample: GetProfileExample?)
    fun onError(message: String?)
}