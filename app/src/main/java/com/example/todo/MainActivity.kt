package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.apply)

        btn.setOnClickListener {

            val day = findViewById<EditText>(R.id.day)

            //Get The Day using Textview and store it value
            val todoDay = day.text.toString()

            //Pass Day To Second Activity
            Intent(this, SecondActivity::class.java).also {
                it.putExtra("EXTRA_DATE", todoDay)
                startActivity(it)
            }
        }


    }


}