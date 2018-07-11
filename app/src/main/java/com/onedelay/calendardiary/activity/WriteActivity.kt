package com.onedelay.calendardiary.activity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.onedelay.calendardiary.R
import com.onedelay.calendardiary.fragment.model.TimelineItem

class WriteActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    var item = TimelineItem()
    lateinit var spinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        spinner = findViewById(R.id.categoryList)
        val adapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this, R.array.category_examples, android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this

        val date: TextView = findViewById(R.id.date)
        item.date = date.text.toString()

        val content: EditText = findViewById(R.id.content)
        item.content = content.text.toString()

        val writeButton: Button = findViewById(R.id.writeButton)
        writeButton.setOnClickListener({
            val returnIntent = Intent()
            returnIntent.putExtra("test","test")
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        })
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        Toast.makeText(baseContext, spinner.getItemAtPosition(p2).toString(), Toast.LENGTH_SHORT).show()
        item.category = spinner.getItemAtPosition(p2).toString()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}
