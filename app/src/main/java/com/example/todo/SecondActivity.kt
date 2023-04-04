package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.model.Todo
import com.example.todo.view.TodoAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SecondActivity : AppCompatActivity() {

    private lateinit var addBtn: FloatingActionButton
    private lateinit var recycleView: RecyclerView
    private lateinit var todoList:ArrayList<Todo>
    private lateinit var todAdapter: TodoAdapter
    private lateinit var tododay: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tododate = intent.getStringExtra("EXTRA_DATE")

        tododay = findViewById(R.id.tvday)

        tododay.text = tododate

        todoList = ArrayList()

        addBtn = findViewById(R.id.addingBtn)

        recycleView = findViewById(R.id.mRecycler)

        todAdapter = TodoAdapter(this,todoList)

        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = todAdapter

        addBtn.setOnClickListener { addData() }

    }

    private fun addData() {
        val inflter = LayoutInflater.from(this)
        val v = inflter.inflate(R.layout.add_item,null)

        val title = v.findViewById<EditText>(R.id.title)
        val time = v.findViewById<EditText>(R.id.time)

        val addDialog = AlertDialog.Builder(this)

        addDialog.setView(v)

        addDialog.setPositiveButton("Ok"){
                dialog,_->
            val todotitle = title.text.toString()
            val todotime = time.text.toString()
            todoList.add(Todo("Title: $todotitle","Time. : $todotime"))
            todAdapter.notifyDataSetChanged()
            Toast.makeText(this,"Add To DO", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancel"){
                dialog,_->
            dialog.dismiss()
            Toast.makeText(this,"Cancel", Toast.LENGTH_SHORT).show()

        }
        addDialog.create()
        addDialog.show()
    }
}