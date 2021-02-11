package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = findViewById<RecyclerView>(R.id.list)
        val btn = findViewById<Button>(R.id.btn)
        val items = mutableListOf<String>()
        val adapter = Adapter()
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        btn.setOnClickListener {
            adapter.addItem()
        }
    }
}

class Adapter() : RecyclerView.Adapter<Lvh>() {
    private val list = mutableListOf<String>()
    fun addItem() {
        list.add("qwe")
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Lvh {
        return Lvh(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: Lvh, position: Int) {
        if (position == itemCount - 1) {
            holder.text.text = "Tail (last item)"
        } else {
            holder.text.text = "Body"
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}

class Lvh(view: View) : RecyclerView.ViewHolder(view) {
    val text = view.findViewById<TextView>(R.id.text)
}