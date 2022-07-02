package com.app.mymall.Fragment.SignUpFragment

import android.app.Activity
import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.app.mymall.Fragment.LoginFragment.LoginFragment
import com.app.mymall.Fragment.SignUpFragment.Presenter.SignUpPresenter
import com.app.mymall.Fragment.SignUpFragment.View.SignUpView
import com.app.mymall.R
import com.app.mymall.Utils.Utils
import java.util.*


class SignUpFragment : Fragment(), View.OnClickListener, SignUpView {
    private var activity: Activity? = null
    var tv_seldob: TextView? = null
    var btn_continue: Button? = null
    var tv_login: TextView? = null
    var mDay: Int? = null
    var mMonth: Int? = null
    var mYear: Int? = null
    lateinit var uservalue: String
    var et_username: EditText? = null
    var et_companyname: EditText? = null
    var et_mail: EditText? = null
    var et_pass: EditText? = null
    lateinit var signUpPresenter: SignUpPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        activity = getActivity()
        init(view)
        listeners(view)
        uservalue = requireArguments().getString("username")!!
        Log.d("uservalcheckimg", uservalue)
        if (uservalue.equals("shopowner")) {
            tv_seldob?.visibility = View.GONE
            et_companyname?.visibility = View.VISIBLE

        }

        signUpPresenter = SignUpPresenter(activity as FragmentActivity, this)

        return view
    }


    fun init(view: View) {
        tv_seldob = view.findViewById(R.id.tv_seldob)
        tv_login = view.findViewById(R.id.tv_login)
        et_companyname = view.findViewById(R.id.et_companyname)
        et_username = view.findViewById(R.id.et_username)
        et_mail = view.findViewById(R.id.et_mail)
        et_pass = view.findViewById(R.id.et_pass)
        btn_continue = view.findViewById(R.id.btn_continue)


    }

    fun listeners(view: View) {
        tv_seldob?.setOnClickListener(this)
        tv_login?.setOnClickListener(this)
        btn_continue?.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v == tv_seldob) {
            val c = Calendar.getInstance()
            mYear = c[Calendar.YEAR]
            mMonth = c[Calendar.MONTH]
            mDay = c[Calendar.DAY_OF_MONTH]
            val datePickerDialog = DatePickerDialog(
                requireActivity(),
                { view, year, monthOfYear, dayOfMonth -> tv_seldob?.setText(dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year) },
                mYear!!,
                mMonth!!,
                mDay!!
            )
            datePickerDialog.show()
            datePickerDialog.datePicker.maxDate = System.currentTimeMillis()
        } else if (v == tv_login) {

            val bundle = Bundle()
            bundle.putString("username", uservalue.toString())
            val fragment = LoginFragment()
            fragment.setArguments(bundle);
            val fm = getActivity()?.supportFragmentManager
            val transaction = fm?.beginTransaction()
            transaction?.add(R.id.login_container, fragment)
            transaction?.commit()
//            Utils.loginActivitychangeFragment(requireContext(), LoginFragment())
        } else if (v == btn_continue) {
            signUpPresenter?.signUpMethod(et_mail, et_username, tv_seldob, et_pass)
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