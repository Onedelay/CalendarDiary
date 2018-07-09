package com.onedelay.calendardiary.fragment

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.WindowManager
import com.onedelay.calendardiary.R
import com.onedelay.calendardiary.fragment.model.DailyItem

class DayListFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(context!!)
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_day_list, null)
        builder.setView(view)

        val recyclerview: RecyclerView = view.findViewById(R.id.daily_list)
        recyclerview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        val list = ArrayList<DailyItem>()

        list.add(DailyItem(R.drawable.ic_money, "오늘 하루 쓴 돈"))
        list.add(DailyItem(R.drawable.ic_reminder, "기억해야할 것"))
        list.add(DailyItem(R.drawable.ic_open_book, "하루 일기장"))

        recyclerview.adapter = DailyListItemRecyclerviewAdapter(list, context!!)

        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        val window = dialog.window
        val params: WindowManager.LayoutParams = window?.attributes!!
        params.apply {
            width = WindowManager.LayoutParams.WRAP_CONTENT
            height = WindowManager.LayoutParams.WRAP_CONTENT
        }
        window.apply {
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            attributes = params
        }
    }
}