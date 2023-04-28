package com.example.appsem06s2;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase

//@Database(entities = arrayOf(Contact::class),version=1)
//@Database(entities = android.R.array.class,version = 1)


abstract class AppDataBase:RoomDatabase() {

    abstract fun getDao(): ContactDao
        companion object{
         private var INSTANCE: AppDatabase? = null
        }

}
