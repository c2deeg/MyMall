package com.app.mymall.Fragment.LoginFragment

import android.app.Activity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.text.method.SingleLineTransformationMethod
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.app.mymall.Fragment.ForgotPasswordFragment.ForgotPasswordFragment
import com.app.mymall.Fragment.LoginFragment.Presenter.LoginPresenter
import com.app.mymall.Fragment.LoginFragment.View.LoginView
import com.app.mymall.Fragment.SignUpFragment.SignUpFragment
import com.app.mymall.R
import com.app.mymall.Utils.Utils

class LoginFragment : Fragment(), View.OnClickListener,LoginView {
    private var activity: Activity? = null
    var et_mail: EditText? = null
    var et_pass: EditText? = null
    var btn_continue: Button? = null
    var tv_forgotpassword: TextView? = null
    var tv_dontaccount: TextView? = null
    var tv_register: TextView? = null
    var img_eye: ImageView? = null
    var flag = true
    lateinit var uservalue: String
    lateinit var  loginPresenter:LoginPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_login, container, false)
        activity = getActivity()
        init(view)
        listeners(view)
        uservalue = requireArguments().getString("username")!!
        loginPresenter = LoginPresenter(activity as FragmentActivity?,this)
        Log.d("uservalcheck", uservalue)


        return view
    }


    fun init(view: View) {

        et_mail = view.findViewById(R.id.et_mail)
        et_pass = view.findViewById(R.id.et_pass)
        btn_continue = view.findViewById(R.id.btn_continue)
        tv_forgotpassword = view.findViewById(R.id.tv_forgotpassword)
        tv_dontaccount = view.findViewById(R.id.tv_dontaccount)
        tv_register = view.findViewById(R.id.tv_register)
        img_eye = view.findViewById(R.id.img_eye)

    }

    fun listeners(view: View) {
        btn_continue?.setOnClickListener(this)
        tv_register?.setOnClickListener(this)
        tv_forgotpassword?.setOnClickListener(this)
        img_eye?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == btn_continue) {

            loginPresenter.loginMethod(et_mail!!.text.toString(), et_pass!!.text.toString())
//            val mainIntent = Intent(activity, HomeActivity::class.java)
//            startActivity(mainIntent)

        } else if (v == tv_register) {
//            Utils.loginActivitychangeFragment(requireActivity(), SignUpFragment())
            val bundle = Bundle()
            bundle.putString("username", uservalue.toString())
            val fragment = SignUpFragment()
            fragment.setArguments(bundle);
            val fm = getActivity()?.supportFragmentManager
            val transaction = fm?.beginTransaction()
            transaction?.add(R.id.login_container, fragment)
            transaction?.commit()


        } else if (v == tv_forgotpassword) {
            Utils.loginActivitychangeFragment(requireActivity(), ForgotPasswordFragment())

        } else if (v == img_eye) {
            if (flag) {
                img_eye!!.setImageResource(R.drawable.hidepassword)

                if (et_pass?.getTransformationMethod()?.javaClass?.getSimpleName() == "PasswordTransformationMethod") {
                    et_pass?.setTransformationMethod(SingleLineTransformationMethod())
                } else {
                    et_pass?.setTransformationMethod(PasswordTransformationMethod())
                }

            } else {
                img_eye!!.setImageResource(R.drawable.eye)

                et_pass?.setTransformationMethod(PasswordTransformationMethod())

            }
            flag = !flag
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