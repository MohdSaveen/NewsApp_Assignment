package com.example.newsappassignment.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDataToDb(article: NewsEntity)

    @Query("select * from article")
    fun getDataFromDb():LiveData<List<NewsEntity>>

    @Query("delete from article")
    fun deleteDataFromDb()
}