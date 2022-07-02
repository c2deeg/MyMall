package com.app.mymall.Activities.StorePriceTimeRangeActivity

import android.app.Activity
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.app.mymall.Activities.BuildYourListing.BuildYourListingActivity
import com.app.mymall.Activities.StorePriceTimeRangeActivity.Presenter.StorePriceTimeRangePresenter
import com.app.mymall.Activities.StorePriceTimeRangeActivity.View.StorePriceTimeRangeView
import com.app.mymall.R
import java.util.*

class StorePriceTimeRangeActivity : AppCompatActivity(), View.OnClickListener,
    StorePriceTimeRangeView {
    var btn_continue: Button? = null
    var activity: Activity? = null
    var tv_timefrom: TextView? = null
    var tv_timeto: TextView? = null
    var mYear: Int? = null
    var mMonth: Int? = null
    var mDay: Int? = null
    var storePriceTimeRangePresenter: StorePriceTimeRangePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_price_time_range)
        activity = this
        init()
        listeners()
        storePriceTimeRangePresenter = StorePriceTimeRangePresenter(activity as StorePriceTimeRangeActivity, this)
    }


    //initialize
    private fun init() {
        btn_continue = findViewById(R.id.btn_continue)
        tv_timefrom = findViewById(R.id.tv_timefrom)
        tv_timeto = findViewById(R.id.tv_timeto)

    }

    private fun listeners() {
        btn_continue?.setOnClickListener(this)
        tv_timefrom?.setOnClickListener(this)
        tv_timeto?.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v == btn_continue) {
            var intent = Intent(activity, BuildYourListingActivity::class.java)
            startActivity(intent)
        } else if (v == tv_timefrom) {
            val mcurrentTime = Calendar.getInstance()
            val hour = mcurrentTime[Calendar.HOUR_OF_DAY]
            val minute = mcurrentTime[Calendar.MINUTE]
            val mTimePicker: TimePickerDialog
            mTimePicker = TimePickerDialog(
                activity,
                { timePicker, selectedHour, selectedMinute -> tv_timefrom?.setText("$selectedHour:$selectedMinute") },
                hour,
                minute,
                true
            ) //Yes 24 hour time

            mTimePicker.setTitle("Select Time")
            mTimePicker.show()

        } else if (v == tv_timeto) {
            val mcurrentTime = Calendar.getInstance()
            val hour = mcurrentTime[Calendar.HOUR_OF_DAY]
            val minute = mcurrentTime[Calendar.MINUTE]
            val mTimePicker: TimePickerDialog
            mTimePicker = TimePickerDialog(
                activity,
                { timePicker, selectedHour, selectedMinute -> tv_timeto?.setText("$selectedHour:$selectedMinute") },
                hour,
                minute,
                true
            ) //Yes 24 hour time

            mTimePicker.setTitle("Select Time")
            mTimePicker.show()
        }
    }


}