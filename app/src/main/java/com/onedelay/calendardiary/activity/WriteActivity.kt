package com.onedelay.calendardiary.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.onedelay.calendardiary.MyApp
import com.onedelay.calendardiary.R
import com.onedelay.calendardiary.database.Diary
import com.onedelay.calendardiary.fragment.TimelineItemRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_write.*
import kotlin.concurrent.thread

class WriteActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener, TimelineItemRecyclerViewAdapter.OnAddItemListener {
    lateinit var spinner: Spinner
    lateinit var category: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        spinner = findViewById(R.id.categoryList)
        val adapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this, R.array.category_examples, android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this

//        val date: TextView = findViewById(R.id.date)
//        val content: EditText = findViewById(R.id.content)

        writeButton.setOnClickListener({
            val returnIntent = Intent()
            returnIntent.putExtra("test", "test")
            setResult(Activity.RESULT_OK, returnIntent)
            thread {
                val diary = Diary(R.drawable.ic_open_book, category, "18/07/12", content.text.toString())
                MyApp.database!!.diaryDao().insert(diary)

                Log.d("ONEDELAY","DB INSERT OK : "+diary.toString())
            }

            finish()
        })
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        Toast.makeText(baseContext, spinner.getItemAtPosition(p2).toString(), Toast.LENGTH_SHORT).show()
        category = spinner.getItemAtPosition(p2).toString()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun onAddListener() {
        Toast.makeText(baseContext, "", Toast.LENGTH_SHORT)
    }
}
