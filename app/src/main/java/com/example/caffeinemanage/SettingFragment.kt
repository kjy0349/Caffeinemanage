package com.example.caffeinemanage


import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentActivity


class SettingFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_setting, container, false)
        val noti_button = root.findViewById<Button>(R.id.set_noti)
        //fragment에서는 (activity as FragmentActivity)키워드를 사용
        val fragmentmanager = (activity as FragmentActivity).supportFragmentManager

        noti_button.setOnClickListener {
            var transaction = fragmentmanager.beginTransaction()
            transaction.replace(R.id.fragment_frame, alarm_setting())
            transaction.addToBackStack(null)//뒤로가기를 누르면 이전 프레그먼트로 되돌아감
            transaction.commit()
        }
        // Inflate the layout for this fragment
        return root
    }
}