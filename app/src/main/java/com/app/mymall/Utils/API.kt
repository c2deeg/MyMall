package com.app.mymall.Utils

import com.app.mymall.Models.ForgotNewPasssword.ForgotNewPassExample
import com.app.mymall.Models.ForgotPassword.ForgotExample
import com.app.mymall.Models.Login.LoginExample
import com.app.mymall.Models.OtpVerification.OtpExample
import com.app.mymall.Models.Profile.GetProfileData.GetProfileExample
import com.app.mymall.Models.Profile.ProfileExample
import com.app.mymall.Models.ResetPassword.ResetPasswordExample
import com.app.mymall.Models.SignUp.SignUpExample
import com.app.mymall.Models.StorePriceTimming.StorePriceListingExample
import com.google.gson.JsonObject
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface API {
    //SignUpAPI
    @POST("users/create")
    fun signupAPI(@Body jsonObject: JsonObject?): Call<SignUpExample>

    //LoginAPI
    @POST("users/login")
    fun logAPI(@Body jsonObject: JsonObject?): Call<LoginExample?>?
    //ForgotPasswordAPI
    @POST("users/forgotPassword")
    fun forgotPasswordAPI(@Body jsonObject: JsonObject?):Call<ForgotExample>
    //EnterOtp
    @POST("users/otpVerify")
    fun  otpVerifyAPI(@Header("x-access-token") xaccesstoken:String,@Body jsonObject: JsonObject?):Call<OtpExample>
    //ForgotNewPassword
    @POST("users/changePassword")
    fun forgotNewPasswordAPI(@Header("x-access-token") token:String,@Body jsonObject: JsonObject?):Call<ForgotNewPassExample>
    //UploadProfileIMage
    @Multipart
    @PUT("users/profileImageUpload/{id}")
     fun updateProfileAPI(@Part image: MultipartBody.Part?, @Path("id") id: String?): Call<ProfileExample?>?
     //getprofileData
     @GET("users/getUserById/{id}")
     fun getPersonalProfileData(@Path("id")id:String?):Call<GetProfileExample>
     //resetPassword
     @PUT("users/resetPassword/{id}")
     fun resetPassword(@Header("x-access-token")token: String,@Path("id")id: String?,@Body jsonObject: JsonObject?): Call<ResetPasswordExample>

     //AddStoreAPI
     @POST("store/create")
     fun addStoreAPI(@Body jsonObject: JsonObject?):Call<StorePriceListingExample>
}