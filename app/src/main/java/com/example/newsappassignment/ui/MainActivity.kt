package com.example.newsappassignment.ui

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsappassignment.R
import com.example.newsappassignment.model.MainRepository
import com.example.newsappassignment.model.local.DataDao
import com.example.newsappassignment.model.local.NewsEntity
import com.example.newsappassignment.model.local.TheDatabase
import com.example.newsappassignment.ui.adapter.FeedAdapter
import com.example.newsappassignment.viewmodel.MainViewModel
import com.example.newsappassignment.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var repository: MainRepository
    private lateinit var dao: DataDao
    private var list = emptyList<NewsEntity>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dao = TheDatabase.getDatabaseInstance(this).getDao()
        repository = MainRepository(dao)
        viewModel =
            ViewModelProvider(this, ViewModelFactory(repository)).get(MainViewModel::class.java)


        viewModel.getData().observe(this, {

            list = it
            setRecyclerView(list as ArrayList<NewsEntity>)
        })
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                val newList= ArrayList<NewsEntity>()
                list.forEach {
                    if(it.Name.lowercase().contains(p0!!.lowercase())||it.desc.lowercase().contains(
                            p0.lowercase())){
                        newList.add(it)
                    }
                }
                setRecyclerView(newList)
                return false
            }
            override fun onQueryTextChange(p0: String?): Boolean {
                val newList= ArrayList<NewsEntity>()
                list.forEach {
                    if(it.Name.lowercase().contains(p0!!.lowercase())||it.desc.lowercase().contains(
                            p0.lowercase())){
                        newList.add(it)
                    }
                }
                setRecyclerView(newList)
                return false
            }
        })
    }

    private fun setRecyclerView(list: ArrayList<NewsEntity>) {
//        list.reverse()
        val newsAdapter = FeedAdapter(list)
        recyclerview.adapter = newsAdapter
        recyclerview.layoutManager = LinearLayoutManager(this)

    }

}