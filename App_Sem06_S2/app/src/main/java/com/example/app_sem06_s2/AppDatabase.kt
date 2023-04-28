package com.example.app_sem06_s2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database( entities = arrayOf(Contact::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
 abstract fun getDao(): ContactDao
 companion object //patron singleton
 {
     private var INSTANCE: AppDatabase? = null
     fun getIntance(context: Context): AppDatabase{
         if(INSTANCE==null){
             INSTANCE = Room
                 .databaseBuilder(context,AppDatabase::class.java,"contact.db")
                 .build()
         }
         return INSTANCE as AppDatabase
     }
 }
}