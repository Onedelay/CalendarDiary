package com.onedelay.calendardiary.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.onedelay.calendardiary.R
import com.onedelay.calendardiary.activity.WriteActivity
import kotlinx.android.synthetic.main.fragment_main.view.*
import kotlinx.android.synthetic.main.timeline_fragment_item_list.*

class CalendarFragment : android.support.v4.app.Fragment() {
    lateinit var listener: OnDayClickListener

    interface OnDayClickListener {
        fun onDayClickListener(year:Int, month:Int, dayOfMonth:Int)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)

        rootView.calendarView.setOnDateChangeListener({ calendarView, year, month, dayOfMonth ->
            //startActivityForResult(Intent(context, WriteActivity::class.java), 100)
            listener.onDayClickListener(year, month, dayOfMonth)
        })
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if(context is OnDayClickListener){
            listener = context
        }
    }
}