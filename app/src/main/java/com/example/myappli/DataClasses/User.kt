package com.example.myappli.DataClasses

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class User (
    @PrimaryKey val id:Int,
    val name:String?=null,
    val password:String?=null
)