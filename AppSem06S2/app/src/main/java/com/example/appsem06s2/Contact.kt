package com.example.appsem06s2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Contact (
    @PrimaryKey(autoGenerate = true )
    var id: Int,

    @ColumnInfo
    var name: String,
    @ColumnInfo
    var telephone: String  )