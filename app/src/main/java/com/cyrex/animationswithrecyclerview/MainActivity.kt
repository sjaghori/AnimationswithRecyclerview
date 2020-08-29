package com.cyrex.animationswithrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.lifecycle.Observer
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.awesome_item) {
    private val viewModel by viewModels<BeerListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = AwesomeAdapter()
        awesome_recyclerview.adapter = adapter
        awesome_recyclerview.addItemDecoration(DividerItemDecoration(this, VERTICAL))

        viewModel.initialise()
        viewModel.displayedBeers.observe(this, Observer {
            adapter.submitList(it)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.list_search_menu, menu)

        val searchView = menu?.findItem(R.id.search)?.actionView as? SearchView
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.onSearch(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.onSearch(newText)
                return false
            }
        })
        return true
    }
}