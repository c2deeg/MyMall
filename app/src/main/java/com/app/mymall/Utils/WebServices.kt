package com.app.mymall.Utils

import com.app.mymall.Handler.*
import com.app.mymall.Models.ForgotNewPasssword.ForgotNewPassExample
import com.app.mymall.Models.ForgotPassword.ForgotExample
import com.app.mymall.Models.Login.LoginExample
import com.app.mymall.Models.OtpVerification.OtpExample
import com.app.mymall.Models.Profile.GetProfileData.GetProfileExample
import com.app.mymall.Models.Profile.ProfileExample
import com.app.mymall.Models.ResetPassword.ResetPasswordExample
import com.app.mymall.Models.SignUp.SignUpExample
import com.google.gson.JsonObject
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class WebServices() {

    private val TAG = "WebServic es"

    private lateinit var api: API

    // for Local data
    fun create() {
        //      mInstance =
        retrofit = Retrofit.Builder()
            //.baseUrl("https://test2.ebookbazaar.com/api/")
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        api = retrofit.create(API::class.java)
        //return retrofit.create(API::class.java)
    }

    companion object Factory1 {

        private lateinit var mInstance: WebServices

        private lateinit var retrofit: Retrofit

        val base_url = "http://93.188.167.68:8004/api/"
        internal var okHttpClient = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        fun getInstance(): WebServices? {
            mInstance = WebServices()
            return mInstance
        }
    }

    fun apiCreate() {
        api = retrofit.create(API::class.java)
    }

    //SignupMethod
    fun signupMethod(
        email: String?,
        name: String?,
        dob: String?,
        password: String,
        registerHandler: RegisterHandler
    ) {
        val jsonObject = JsonObject()
        jsonObject.addProperty("email", email)
        jsonObject.addProperty("name", name)
        jsonObject.addProperty("dob", dob)
        jsonObject.addProperty("password", password)
        apiCreate()
        api?.signupAPI(jsonObject).enqueue(object : Callback<SignUpExample?> {
            override fun onResponse(
                call: Call<SignUpExample?>,
                response: Response<SignUpExample?>
            ) {


                if (response.code() == 200) {
                    registerHandler.onSuccess(response.body())

                } else {
                    val responceData =
                        SocketConnection.convertStreamToString(response.errorBody()!!.byteStream())
                    try {
                        val jsonObject = JSONObject(responceData)
                        val message = jsonObject.optString("message")
                        val error = jsonObject.optString("error")
                        if (!message.equals("", ignoreCase = true)) {
                            registerHandler.onError(message)
                        } else {
                            registerHandler.onError(error)
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call<SignUpExample?>, t: Throwable) {
                registerHandler.onError(t.message)
            }

        })
    }

    //LoginMethod
    fun loginMethod(email: String?, password: String?, loginHandler: LoginHandler) {
        val jsonObject = JsonObject()
        jsonObject.addProperty("email", email)
        jsonObject.addProperty("password", password)

        apiCreate()
        api?.logAPI(jsonObject)?.enqueue(object : Callback<LoginExample?> {
            override fun onResponse(call: Call<LoginExample?>, response: Response<LoginExample?>) {
                var acesstoken:String?=null
                acesstoken = response.headers()["x-access-token"]
                if (response.code() == 200) {
                    loginHandler.onSuccess(response.body(),acesstoken)
                } else {
                    val responceData = SocketConnection.convertStreamToString(
                        response.errorBody()!!.byteStream()
                    )
                    try {
                        val jsonObject = JSONObject(responceData)
                        val message = jsonObject.optString("message")
                        val error = jsonObject.optString("error")
                        if (!message.equals("", ignoreCase = true)) {
                            loginHandler.onError(message)
                        } else {
                            loginHandler.onError(error)
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call<LoginExample?>, t: Throwable) {
                loginHandler.onError(t.message)
            }
        })
    }


    //forgotpasswordMethod
    fun forgotPasswordMethod(email: String?, forgotPasswordHandler: ForgotPasswordHandler) {
        apiCreate()
        val jsonObject = JsonObject()
        jsonObject.addProperty("email", email)
        api.forgotPasswordAPI(jsonObject).enqueue(object : Callback<ForgotExample> {
            override fun onResponse(call: Call<ForgotExample>, response: Response<ForgotExample>) {
                if (response.code() == 200) {
                    forgotPasswordHandler.onSuccess(response.body())
                } else {
                    val responceData = SocketConnection.convertStreamToString(
                        response.errorBody()!!.byteStream()
                    )
                    try {
                        val jsonObject = JSONObject(responceData)
                        val message = jsonObject.optString("message")
                        val error = jsonObject.optString("error")
                        if (!message.equals("", ignoreCase = true)) {
                            forgotPasswordHandler.onError(message)
                        } else {
                            forgotPasswordHandler.onError(error)
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call<ForgotExample>, t: Throwable) {
                forgotPasswordHandler.onError(t.message)
            }

        })
    }

    //EnterOtpMethod
    fun OtpMethod(token: String?, otp:String?,otpHandler: EnterOtpHandler) {
        apiCreate()
        val jsonObject = JsonObject()
        jsonObject.addProperty("otp", otp)
        api.otpVerifyAPI(token!!,jsonObject).enqueue(object : Callback<OtpExample> {
            override fun onResponse(call: Call<OtpExample>, response: Response<OtpExample>) {
                if (response.code() == 200) {
                    otpHandler.onSuccess(response.body())
                } else {
                    val responceData = SocketConnection.convertStreamToString(
                        response.errorBody()!!.byteStream()
                    )
                    try {
                        val jsonObject = JSONObject(responceData)
                        val message = jsonObject.optString("message")
                        val error = jsonObject.optString("error")
                        if (!message.equals("", ignoreCase = true)) {
                            otpHandler.onError(message)
                        } else {
                            otpHandler.onError(error)
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call<OtpExample>, t: Throwable) {
                otpHandler.onError(t.message)
            }

        })
    }

    //ForgotNewpassword
    fun forgotnewPassword(token: String?, newPassword:String?,forgotNewPassHandler: ForgotNewPassHandler) {
        apiCreate()
        val jsonObject = JsonObject()
        jsonObject.addProperty("newPassword", newPassword)
        api.forgotNewPasswordAPI(token!!,jsonObject).enqueue(object : Callback<ForgotNewPassExample> {
            override fun onResponse(call: Call<ForgotNewPassExample>, response: Response<ForgotNewPassExample>) {
                if (response.code() == 200) {
                    forgotNewPassHandler.onSuccess(response.body())
                } else {
                    val responceData = SocketConnection.convertStreamToString(
                        response.errorBody()!!.byteStream()
                    )
                    try {
                        val jsonObject = JSONObject(responceData)
                        val message = jsonObject.optString("message")
                        val error = jsonObject.optString("error")
                        if (!message.equals("", ignoreCase = true)) {
                            forgotNewPassHandler.onError(message)
                        } else {
                            forgotNewPassHandler.onError(error)
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call<ForgotNewPassExample>, t: Throwable) {
                forgotNewPassHandler.onError(t.message)
            }

        })
    }

    //ProfileImageUpload
    fun profileimageupload(image:MultipartBody.Part,id:String?,profileHandler: ProfileHandler){
        apiCreate()
         api.updateProfileAPI(image,id)?.enqueue(object : Callback<ProfileExample?> {
             override fun onResponse(call: Call<ProfileExample?>, response: Response<ProfileExample?>) {
                 if (response.code() == 200) {
                     profileHandler.onSuccess(response.body())
                 } else {
                     val responceData = SocketConnection.convertStreamToString(
                         response.errorBody()!!.byteStream()
                     )
                     try {
                         val jsonObject = JSONObject(responceData)
                         val message = jsonObject.optString("message")
                         val error = jsonObject.optString("error")
                         if (!message.equals("", ignoreCase = true)) {
                             profileHandler.onError(message)
                         } else {
                             profileHandler.onError(error)
                         }
                     } catch (e: JSONException) {
                         e.printStackTrace()
                     }
                 }
             }
             override fun onFailure(call: Call<ProfileExample?>, t: Throwable) {
                 profileHandler.onError(t.message)
             }

         })

    }

    //getprofileData
    fun getprofileData(id: String?,getProfiledataHandler: GetProfiledataHandler){
        apiCreate()
        api.getPersonalProfileData(id)?.enqueue(object : Callback<GetProfileExample?> {
            override fun onResponse(call: Call<GetProfileExample?>, response: Response<GetProfileExample?>) {
                if (response.code() == 200) {
                    getProfiledataHandler.onSuccess(response.body())
                } else {
                    val responceData = SocketConnection.convertStreamToString(
                        response.errorBody()!!.byteStream()
                    )
                    try {
                        val jsonObject = JSONObject(responceData)
                        val message = jsonObject.optString("message")
                        val error = jsonObject.optString("error")
                        if (!message.equals("", ignoreCase = true)) {
                            getProfiledataHandler.onError(message)
                        } else {
                            getProfiledataHandler.onError(error)
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            }
            override fun onFailure(call: Call<GetProfileExample?>, t: Throwable) {
                getProfiledataHandler.onError(t.message)
            }

        })

    }

    //ResetPassword
    fun resetPassword(token: String?,id: String?,oldPassword:String?,newPassword: String?,resetPasswordHandler: ResetPasswordHandler){
        apiCreate()
        val jsonObject = JsonObject()
        jsonObject.addProperty("oldPassword", oldPassword)
        jsonObject.addProperty("newPassword", newPassword)
        api.resetPassword(token!!,id,jsonObject).enqueue(object : Callback<ResetPasswordExample> {
            override fun onResponse(call: Call<ResetPasswordExample>, response: Response<ResetPasswordExample>) {
                if (response.code() == 200) {
                    resetPasswordHandler.onSuccess(response.body())
                } else {
                    val responceData = SocketConnection.convertStreamToString(
                        response.errorBody()!!.byteStream()
                    )
                    try {
                        val jsonObject = JSONObject(responceData)
                        val message = jsonObject.optString("message")
                        val error = jsonObject.optString("error")
                        if (!message.equals("", ignoreCase = true)) {
                            resetPasswordHandler.onError(message)
                        } else {
                            resetPasswordHandler.onError(error)
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call<ResetPasswordExample>, t: Throwable) {
                resetPasswordHandler.onError(t.message)
            }

        })




    }


    //getStorePriceTimming
    fun getstorePriceTimming(description:String?,name:String?,slogan:String?,webSiteUrl:String?,){

    }




}



