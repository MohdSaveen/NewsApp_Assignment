package com.example.newsappassignment.model

import androidx.lifecycle.LiveData
import com.example.newsappassignment.model.local.DataDao
import com.example.newsappassignment.model.local.NewsEntity
import com.example.newsappassignment.model.remote.Network
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainRepository(private val dao: DataDao) {

    fun getDataFromApi(): LiveData<List<NewsEntity>>{

        CoroutineScope(IO).launch {
            try {
                val list = Network.api.getData().articles
              if(list!=null) {
                  dao.deleteDataFromDb()
              }
                list?.forEach {
                    if (it != null) {
                        val newsDb = it.title?.let { it1 -> it.urlToImage?.let { it2 ->
                            it.description?.let { it3 ->
                                it.publishedAt?.let { it4 ->
                                    it.source?.name?.let { it5 ->
                                        NewsEntity(it1,
                                            it2, it3, it4, it5
                                        )
                                    }
                                }
                            }
                        }
                        }
                        if (newsDb != null) {
                            dao.insertDataToDb(newsDb)
                        }
                    }
                }
            }
            catch (e:Exception){
            }
        }
        return dao.getDataFromDb()
    }
}