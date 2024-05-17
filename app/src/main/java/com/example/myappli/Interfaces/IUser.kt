package com.example.myappli.Interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myappli.DataClasses.User


@Dao
interface IUser {

        @Query("Select * From Users where :name==name AND :password==password")
        fun Get(name:String?, password:String?):User

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        fun insert(user:User)

}