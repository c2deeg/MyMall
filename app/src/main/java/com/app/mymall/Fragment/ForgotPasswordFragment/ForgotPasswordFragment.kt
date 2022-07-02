package com.app.mymall.Fragment.ForgotPasswordFragment

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentActivity
import com.app.mymall.Fragment.EnterOtpFragment.EnterOtpPresenter.EnterOtpPresenter
import com.app.mymall.Fragment.ForgotPasswordFragment.Presenter.ForgotPasswordPresenter
import com.app.mymall.Fragment.ForgotPasswordFragment.View.ForgotPasswordView
import com.app.mymall.R
import com.app.mymall.Utils.Utils

class ForgotPasswordFragment : Fragment(), View.OnClickListener, ForgotPasswordView {
    var btn_continue: Button? = null
    var et_mail: EditText? = null
    var enterOtpPresenter: EnterOtpPresenter? = null
    var forgotPasswordPresenter: ForgotPasswordPresenter? = null
    var activity: Activity? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_forgot_password, container, false)
        activity = getActivity()
        init(view)
        listeners(view)
        forgotPasswordPresenter = ForgotPasswordPresenter(activity as FragmentActivity, this)
        return view
    }

    fun init(view: View) {
        btn_continue = view.findViewById(R.id.btn_continue)
        et_mail = view.findViewById(R.id.et_mail)

    }

    fun listeners(view: View?) {
        btn_continue?.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v == btn_continue) {
            forgotPasswordPresenter?.forgotPasswordMethod(et_mail)

//            Utils.loginActivitychangeFragment(requireContext(), EnterOtpFragment())

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