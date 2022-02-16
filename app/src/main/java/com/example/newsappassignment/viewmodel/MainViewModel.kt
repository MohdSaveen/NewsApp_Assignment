package com.example.newsappassignment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.newsappassignment.model.MainRepository
import com.example.newsappassignment.model.local.NewsEntity
import com.example.newsappassignment.model.remote.responsemodel.ArticlesDTO

class MainViewModel(private val repository: MainRepository):ViewModel() {

    fun getData():LiveData<List<NewsEntity>>{
        return repository.getDataFromApi()
    }



}