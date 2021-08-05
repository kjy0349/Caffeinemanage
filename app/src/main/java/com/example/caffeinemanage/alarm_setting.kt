package com.example.caffeinemanage

import android.annotation.SuppressLint
import android.app.TimePickerDialog
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Bundle
import android.text.format.DateFormat
import android.text.format.Time
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat

class alarm_setting : Fragment() {
    @SuppressLint("SimpleDateFormat")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_alarm_setting, container, false)
        val setting_btn = root.findViewById<Button>(R.id.set_btn)
        val time_tv = root.findViewById<TextView>(R.id.timeView)
        setting_btn.setOnClickListener{
            val cal = java.util.Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener{timePicker, hour, minute ->
                cal.set(java.util.Calendar.HOUR_OF_DAY,hour)
                cal.set(java.util.Calendar.MINUTE,minute)
                time_tv.text= java.text.SimpleDateFormat("a hh:mm").format(cal.time)
            }
            TimePickerDialog(activity,timeSetListener,cal.get(java.util.Calendar.HOUR_OF_DAY),cal.get(java.util.Calendar.MINUTE),false)
                .show()
        }

        return root
    }

    private fun openTimePicker(){
        val isSystem24Hour = DateFormat.is24HourFormat(requireContext())
        val clockFormat = if(isSystem24Hour) TimeFormat.CLOCK_24H else TimeFormat.CLOCK_12H

        val picker = MaterialTimePicker.Builder().setTimeFormat(clockFormat).setHour(12).setMinute(0).setTitleText("SET ALARM").build()
        picker.show(childFragmentManager,"TAG")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}