package com.app.mymall.Fragment.ProfileFragment

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.app.mymall.Activities.LoginActivity.LoginActivity
import com.app.mymall.Fragment.ProfileFragment.Presenter.ProfilePresenter
import com.app.mymall.Fragment.ProfileFragment.View.ProfileView
import com.app.mymall.Fragment.ResetPasswordFragment.ResetFragment
import com.app.mymall.Models.Profile.GetProfileData.GetProfileData
import com.app.mymall.R
import com.app.mymall.Utils.Utils
import java.io.IOException
import com.bumptech.glide.Glide


class ProfileFragment : Fragment(), View.OnClickListener, ProfileView {
    var activity: Activity? = null
    var img_selectimage: ImageView? = null
    private val pickImage = 100
    private var imageUri: Uri? = null
    var img_profile: ImageView? = null
    var tv_changepassword: TextView? = null
    var tv_logout: TextView? = null
    var tv_logoutalldevices: TextView? = null
    lateinit var profilePresenter: ProfilePresenter
    private var bitmap: Bitmap? = null
    var tv_username: TextView? = null
    var tv_email: TextView? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_profile, container, false)
        activity = getActivity()
        initUi(view)
        listeners(view)
        profilePresenter = ProfilePresenter(activity as FragmentActivity, this)
        profilePresenter.getprofileDetail()
        return view
    }

    private fun initUi(view: View?) {
        img_selectimage = view?.findViewById(R.id.img_selectimage)
        img_profile = view?.findViewById(R.id.img_profile)
        tv_changepassword = view?.findViewById(R.id.tv_changepassword)
        tv_logout = view?.findViewById(R.id.tv_logout)
        tv_logoutalldevices = view?.findViewById(R.id.tv_logoutalldevices)
        tv_username = view?.findViewById(R.id.tv_username)
        tv_email = view?.findViewById(R.id.tv_email)

    }

    private fun listeners(view: View?) {
        img_selectimage?.setOnClickListener(this)
        tv_changepassword?.setOnClickListener(this)
        tv_logout?.setOnClickListener(this)
        tv_logoutalldevices?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == img_selectimage) {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        } else if (v == tv_changepassword) {
            val fragment = ResetFragment()
            val transaction = getActivity()?.supportFragmentManager?.beginTransaction()
            transaction?.replace(android.R.id.content, fragment)
            transaction?.disallowAddToBackStack()
            transaction?.commit()
        } else if (v == tv_logout) {
            showDialog()
        } else if (v == tv_logoutalldevices) {
            showDialog()
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == AppCompatActivity.RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data

            //                    Log.d(TAG, "onActivityimg" + path);
            try {
                bitmap =
                    MediaStore.Images.Media.getBitmap(requireActivity()!!.contentResolver, imageUri)
                profilePresenter.uploadProfileImage(bitmap!!)
            } catch (e: IOException) {
                e.printStackTrace()
            }



            img_profile?.setImageURI(imageUri)
        }
    }


    private fun showDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.logoutdialog)
        val window = dialog.window
        val wlp = window!!.attributes
        wlp.gravity = Gravity.CENTER
        wlp.flags = wlp.flags and WindowManager.LayoutParams.FLAG_BLUR_BEHIND.inv()
        window.attributes = wlp
        dialog.window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        val btn_signout = dialog.findViewById<View>(R.id.btn_signout) as Button
//        val gender: String = CSPreferences.readString(activity, Utils.GENDERSELECT)

        btn_signout.setOnClickListener {
//            CSPreferences.putString(activity, Utils.USERLOGIN, "false")
            val intent1 = Intent(activity, LoginActivity::class.java)
            startActivity(intent1)

        }
        val btn_cancel = dialog.findViewById<View>(R.id.btn_cancel) as Button
        btn_cancel.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

    override fun showMessage(activity: Activity?, msg: String?) {
        Utils.showMessage(activity, msg)
    }

    override fun showDialog(activity: Activity?) {
        Utils.showDialogMethod(activity, requireActivity().fragmentManager)
    }

    override fun hideDialog() {
        Utils.hideDialog()
    }

    override fun setData(activity: FragmentActivity,   data: GetProfileData?) {

        tv_username?.setText(data?.name)
        tv_email?.setText(data?.email)
        Glide.with(activity).load(data?.profileImageName).placeholder(R.drawable.men).into(img_profile)

    }

//    fun setData(data: PersonalProfileData) {
//        this.personalProfileDataList = data
//        CSPreferences.putString(
//            activity,
//            Utils.ImageBaseURL,
//            personalProfileDataList.getProfileImageName()
//        )
//        Glide.with(activity).load(personalProfileDataList.getProfileImageName())
//            .placeholder(R.drawable.userdummy).into(img_profile)
//        tv_username.setText(personalProfileDataList.getName())
//        et_fullname.setText(personalProfileDataList.getName())
//        et_email.setText(personalProfileDataList.getEmail())
//        tv_aboutme.setText(personalProfileDataList.getDescription())
//    }


}