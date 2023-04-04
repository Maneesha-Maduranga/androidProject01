package com.example.todo.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R
import com.example.todo.model.Todo


class TodoAdapter(val c: Context, val todolist :ArrayList<Todo>): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>()
{



    inner class TodoViewHolder(val v: View): RecyclerView.ViewHolder(v) {
        var title = v.findViewById<TextView>(R.id.title)
        var time = v.findViewById<TextView>(R.id.time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v  = inflater.inflate(R.layout.list_item,parent,false)
        return TodoViewHolder(v)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val newList = todolist[position]
        holder.title.text = newList.title
        holder.time.text = newList.time
    }

    override fun getItemCount(): Int {
        return  todolist.size
    }
}