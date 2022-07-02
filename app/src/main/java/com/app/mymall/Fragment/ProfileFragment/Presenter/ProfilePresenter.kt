package com.app.mymall.Fragment.ProfileFragment.Presenter

import android.graphics.Bitmap
import androidx.fragment.app.FragmentActivity
import com.app.mymall.Fragment.ForogotNewPasswordFragment.ForgotNewPasswordFragment
import com.app.mymall.Fragment.ProfileFragment.ProfileFragment
import com.app.mymall.Fragment.ProfileFragment.View.ProfileView
import com.app.mymall.Handler.EnterOtpHandler
import com.app.mymall.Handler.GetProfiledataHandler
import com.app.mymall.Handler.ProfileHandler
import com.app.mymall.Models.OtpVerification.OtpExample
import com.app.mymall.Models.Profile.GetProfileData.GetProfileExample
import com.app.mymall.Models.Profile.ProfileExample
import com.app.mymall.Utils.CSPreferences
import com.app.mymall.Utils.Utils
import com.app.mymall.Utils.WebServices
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.ByteArrayOutputStream
import java.util.*

class ProfilePresenter(private val activity: FragmentActivity, private val profileView: ProfileView) {
    private var imagePart: MultipartBody.Part? = null
    private var id: RequestBody? = null
    fun uploadProfileImage(photo:Bitmap){
        if (photo != null) {
            val stream = ByteArrayOutputStream()
            photo.compress(Bitmap.CompressFormat.JPEG, 40, stream)
            val photoByteArray = stream.toByteArray()
            val requestFile =
                RequestBody.create(MediaType.parse("multipart/form-data"), photoByteArray)
            id = RequestBody.create(
                MediaType.parse("multipart/form-data"),
                CSPreferences.readString(activity, Utils.USERID)
            )
            val random = Random()
            imagePart = MultipartBody.Part.createFormData("file", "abc" + random.nextInt(1000000) + ".jpg", requestFile)
        }
        if (Utils.isNetworkConnected(activity!!)) {
            profileView?.showDialog(activity)
            var id:String?=null
            id = CSPreferences.readString(activity,Utils.USERID)
            WebServices.Factory1.getInstance()?.profileimageupload(imagePart!!,id, object :
                ProfileHandler {
                override fun onSuccess(profileExample: ProfileExample?) {
                    profileView?.hideDialog()
                    if (profileExample != null) {
                        if (profileExample.getIsSuccess() === true) {
                            profileView?.showMessage(activity, profileExample.data)
//                            Utils.loginActivitychangeFragment(activity, ForgotNewPasswordFragment())
                        }
                    } else {
                        profileView?.showMessage(activity, profileExample?.data)
                    }
                }

                override fun onError(message: String?) {
                    profileView?.hideDialog()
                    profileView?.showMessage(activity, message)
                }
            })
        }
    }


    fun getprofileDetail(){
        if (Utils.isNetworkConnected(activity!!)) {
            profileView?.showDialog(activity)
            var id:String?=null
            id = CSPreferences.readString(activity,Utils.USERID)
            WebServices.Factory1.getInstance()?.getprofileData(id, object :
                GetProfiledataHandler {
                override fun onSuccess(getProfileExample: GetProfileExample?) {
                    profileView?.hideDialog()
                    if (getProfileExample != null) {
                        if (getProfileExample.getIsSuccess() === true) {
                            profileView?.showMessage(activity, getProfileExample.message)
                            profileView.setData(activity,getProfileExample.data)
//                            Utils.loginActivitychangeFragment(activity, ForgotNewPasswordFragment())
                        }
                    } else {
                        profileView?.showMessage(activity, getProfileExample?.message)
                    }
                }

                override fun onError(message: String?) {
                    profileView?.hideDialog()
                    profileView?.showMessage(activity, message)
                }
            })
        }



    }
}