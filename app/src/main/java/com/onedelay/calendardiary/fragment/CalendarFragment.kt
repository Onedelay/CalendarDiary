package com.onedelay.calendardiary.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.onedelay.calendardiary.R
import kotlinx.android.synthetic.main.fragment_main.view.*

class CalendarFragment : android.support.v4.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)

        rootView.calendarView.setOnDateChangeListener({ calendarView, year, month, dayOfMonth -> Toast.makeText(context, "클릭됨", Toast.LENGTH_SHORT).show() })
        return rootView
    }

    companion object {
        private val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(sectionNumber: Int): CalendarFragment {
            val fragment = CalendarFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}