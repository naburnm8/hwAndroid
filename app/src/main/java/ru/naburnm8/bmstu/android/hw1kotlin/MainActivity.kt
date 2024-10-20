package ru.naburnm8.bmstu.android.hw1kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.naburnm8.bmstu.android.hw1kotlin.ui.adapter.SquareAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: SquareAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private var items: MutableList<Int> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        fab = findViewById(R.id.fab)
        if (savedInstanceState != null) {
            items = savedInstanceState.getIntegerArrayList("items")?.toMutableList() ?: mutableListOf()
        } else {
            items = MutableList(6) { it }
        }
        adapter = SquareAdapter(this, items)
        recyclerView.adapter = adapter
        val columns = if (resources.configuration.orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT) 3 else 4
        recyclerView.layoutManager = GridLayoutManager(this, columns)
        fab.setOnClickListener {
            adapter.addItem()
            recyclerView.smoothScrollToPosition(adapter.itemCount - 1)
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntegerArrayList("items", ArrayList(items))
    }
}
