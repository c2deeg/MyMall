package com.app.mymall.Fragment.ForogotNewPasswordFragment

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentActivity
import com.app.mymall.Fragment.ForogotNewPasswordFragment.Presenter.ForgotNewPasswordPresenter
import com.app.mymall.Fragment.ForogotNewPasswordFragment.View.ForgotNewPasswordView
import com.app.mymall.R
import com.app.mymall.Utils.Utils

class ForgotNewPasswordFragment : Fragment(), View.OnClickListener, ForgotNewPasswordView {
    var activity: Activity? = null
    lateinit var et_newpassword: EditText
    lateinit var btn_continue: Button
    var forgotNewPasswordPresenter: ForgotNewPasswordPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_forgot_new_password, container, false)
        activity = getActivity()
        init(view)
        listeners(view)
        forgotNewPasswordPresenter = ForgotNewPasswordPresenter(activity as FragmentActivity, this)
        return view
    }


    private fun init(view: View) {
        et_newpassword = view.findViewById(R.id.et_newpassword)
        btn_continue = view.findViewById(R.id.btn_continue)

    }

    private fun listeners(view: View) {
        et_newpassword.setOnClickListener(this)
        btn_continue.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v == btn_continue) {
            var newpass: String
            newpass = et_newpassword.text.toString()
            forgotNewPasswordPresenter?.newpasswodMethod(newpass)

        }
    }

    override fun showMessage(activity: Activity?, msg: String?) {
        Utils.showMessage(activity, msg)
    }

    override fun showDialog(activity: Activity?) {
        Utils.showDialogMethod(activity, requireActivity()!!.fragmentManager)
    }

    override fun hideDialog() {
        Utils.hideDialog()
    }


}