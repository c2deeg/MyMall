package com.app.mymall.Fragment.EnterOtpFragment

import android.app.Activity
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.FragmentActivity
import com.app.mymall.Fragment.EnterOtpFragment.EnterOtpPresenter.EnterOtpPresenter
import com.app.mymall.Fragment.EnterOtpFragment.EnterOtpView.EnterOtpView
import com.app.mymall.Fragment.ForogotNewPasswordFragment.ForgotNewPasswordFragment
import com.app.mymall.R
import com.app.mymall.Utils.Utils

public class EnterOtpFragment : Fragment(), View.OnClickListener, EnterOtpView {
    var et_code1: EditText? = null
    var et_code2: EditText? = null
    var et_code3: EditText? = null
    var et_code4: EditText? = null
    var linearlayout: LinearLayout? = null
    var img_next: ImageView? = null
    var enterOtpPresenter: EnterOtpPresenter? = null

    companion object {
        private const val TEST_VERIFY_CODE = "6768"
    }


    lateinit var editTexts: Array<EditText>
    public var activity: Activity? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_enter_otp, container, false)
        activity = getActivity()
        et_code1 = view.findViewById(R.id.et_code1)
        et_code2 = view.findViewById(R.id.et_code2)
        et_code3 = view.findViewById(R.id.et_code3)
        et_code4 = view.findViewById(R.id.et_code4)
        linearlayout = view.findViewById(R.id.linearlayout)
        init(view)
        listeners(view)
        setListener()
        initfocus()
        enterOtpPresenter = EnterOtpPresenter(activity as FragmentActivity, this)



        return view
    }


    private fun init(view: View) {
        img_next = view.findViewById(R.id.img_next)

    }

    private fun listeners(view: View) {
        img_next?.setOnClickListener(this)

    }


    override fun onClick(v: View?) {
        if (v == img_next) {
            var code:String
            code = et_code1?.text.toString()+et_code2?.text.toString()+et_code3?.text.toString()+et_code4?.text.toString()
            enterOtpPresenter?.enterOtpMethod(code)
//            Utils.loginActivitychangeFragment(requireContext(), ForgotNewPasswordFragment())
        }
    }


    private fun setListener() {
        linearlayout?.setOnClickListener {
            if (activity?.currentFocus != null) {
                val inputManager =
                    activity?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                inputManager.hideSoftInputFromWindow(linearlayout?.windowToken, 0)
            }


        }

        setTextChangedListener(fromEditText = et_code1!!, targetEditText = et_code2)
        setTextChangedListener(fromEditText = et_code2!!, targetEditText = et_code3)
        setTextChangedListener(fromEditText = et_code3!!, targetEditText = et_code4)
        setTextChangedListener(fromEditText = et_code4!!, done = {
            verifyOtp()
        })

        setKeyListener(fromEditText = et_code2!!, backToEditText = et_code1!!)
        setKeyListener(fromEditText = et_code3!!, backToEditText = et_code2!!)
        setKeyListener(fromEditText = et_code4!!, backToEditText = et_code3!!)
    }


    private fun initfocus() {
        et_code1?.isEnabled = true
        et_code1?.postDelayed({
            et_code1?.requestFocus()
            val inpitMethodManager =
                activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inpitMethodManager.showSoftInput(et_code1, InputMethodManager.SHOW_FORCED)

        }, 500)
    }

    private fun request() {
        et_code1?.isEnabled = false
        et_code2?.isEnabled = false
        et_code3?.isEnabled = false
        et_code4?.isEnabled = false


        et_code1?.setText("")
        et_code2?.setText("")
        et_code3?.setText("")
        et_code4?.setText("")
        initfocus()

    }

    private fun setTextChangedListener(
        fromEditText: EditText,
        targetEditText: EditText? = null,
        done: (() -> Unit)? = null
    ) {
        fromEditText.addTextChangedListener {
            it?.let { String ->
                if (String.isNotBlank()) {
                    targetEditText?.let { editText ->
                        editText.isEnabled = true
                        editText.requestFocus()
                    } ?: kotlin.run {
                        done?.let { done ->
                            done()
                        }
                    }
                    fromEditText.clearFocus()
                    fromEditText.isEnabled = false
                }

            }
        }
    }

    private fun setKeyListener(fromEditText: EditText, backToEditText: EditText) {
        fromEditText.setOnKeyListener { _, _, event ->
            if (null != event && KeyEvent.KEYCODE_DEL == event.keyCode) {
                backToEditText.isEnabled = true
                backToEditText.requestFocus()
                backToEditText.setText("")

                fromEditText.clearFocus()

                fromEditText.isEnabled = false
            }
            false

        }

    }


    private fun verifyOtp() {
        val otpCode = "${et_code1?.text.toString().trim()}+" +
                "${et_code2?.text.toString()}+" + "${et_code3?.text.toString()}+" + "${et_code4?.text.toString()}"
        if (4 != otpCode.length) {
            return
        }
        if (otpCode == TEST_VERIFY_CODE) {
            Toast.makeText(activity, "source", Toast.LENGTH_SHORT).show()
            val inputManager =
                activity?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(linearlayout?.windowToken, 0)
            return


        }
        Toast.makeText(activity, "error,input,again", Toast.LENGTH_SHORT).show()
        request()
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







