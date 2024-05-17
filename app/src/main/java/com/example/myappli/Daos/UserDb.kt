package com.example.myappli.Daos

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myappli.DataClasses.User
import com.example.myappli.Interfaces.Costumer
import com.example.myappli.Interfaces.IUser


@Database(entities = arrayOf(User::class), version = 1)
abstract class UserDb: RoomDatabase() {

    abstract fun iuser(): IUser

    companion object {

        @Volatile
        private var INSTANCE: UserDb? = null

        fun getDatabase(context: Context): UserDb {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDb::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }


    }
}