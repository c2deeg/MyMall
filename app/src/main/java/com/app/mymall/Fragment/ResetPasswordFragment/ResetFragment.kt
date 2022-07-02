package com.app.mymall.Fragment.ResetPasswordFragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.text.method.SingleLineTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import com.app.mymall.Activities.HomeActivity.HomeActivity
import com.app.mymall.Fragment.ResetPasswordFragment.Presenter.ResetPresenter
import com.app.mymall.Fragment.ResetPasswordFragment.View.ResetPasswordView
import com.app.mymall.R
import com.app.mymall.Utils.Utils


class ResetFragment : Fragment(), View.OnClickListener,ResetPasswordView {
    var activity:Activity?=null
    var et_oldpassword:EditText?=null
    var et_confirmpassword:EditText?=null
    var img_eye:ImageView?=null
    var flag = true
    var resetPresenter:ResetPresenter?=null
    var btn_continue:Button?=null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_reset, container, false)
        activity = getActivity()
        inits(view)
        listeners(view)
        resetPresenter = ResetPresenter(activity as FragmentActivity,this)
        return view
    }



    private fun inits(view: View?) {
        et_oldpassword = view?.findViewById(R.id.et_oldpassword)
        et_confirmpassword = view?.findViewById(R.id.et_confirmpassword)
        img_eye = view?.findViewById(R.id.img_eye)
        btn_continue = view?.findViewById(R.id.btn_continue)

    }

    private fun listeners(view: View?) {
        img_eye?.setOnClickListener(this)
        btn_continue?.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v==img_eye){
            if (flag) {
                img_eye!!.setImageResource(R.drawable.hidepassword)

                if (et_confirmpassword?.getTransformationMethod()?.javaClass?.getSimpleName() == "PasswordTransformationMethod") {
                    et_confirmpassword?.setTransformationMethod(SingleLineTransformationMethod())
                } else {
                    et_confirmpassword?.setTransformationMethod(PasswordTransformationMethod())
                }

            } else {
                img_eye!!.setImageResource(R.drawable.eye)

                et_confirmpassword?.setTransformationMethod(PasswordTransformationMethod())

            }
            flag = !flag
        } else if(v==btn_continue){

            resetPresenter?.resetPasswordMethod(et_oldpassword,et_confirmpassword)
//
//            var intent = Intent(activity,HomeActivity::class.java)
//            startActivity(intent)
        }
    }

    override fun showMessage(activity: Activity?, msg: String?) {
      Utils.showMessage(activity,msg)
    }

    override fun showDialog(activity: Activity?) {
       Utils.showDialogMethod(activity,requireActivity()!!.fragmentManager)
    }

    override fun hideDialog() {
       Utils.hideDialog()
    }

}
