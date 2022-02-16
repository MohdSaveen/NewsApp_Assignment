package com.example.newsappassignment.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NewsEntity::class], version =2)
abstract class TheDatabase :RoomDatabase(){

    abstract fun getDao():DataDao

    companion object{
        private var INSTANCE:TheDatabase?=null

        fun getDatabaseInstance(context: Context):TheDatabase{
            return if (INSTANCE!=null){
                 INSTANCE!!
            }else{
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    TheDatabase::class.java,
                    "theDatabase"
                )
                builder.fallbackToDestructiveMigration()
                INSTANCE = builder.build()
                INSTANCE!!

            }
        }
    }
}