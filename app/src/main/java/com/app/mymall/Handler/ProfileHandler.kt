package com.app.mymall.Handler

import com.app.mymall.Models.Profile.ProfileExample
import com.app.mymall.Models.SignUp.SignUpExample

interface ProfileHandler {

    fun onSuccess(profileExample: ProfileExample?)
    fun onError(message: String?)
}