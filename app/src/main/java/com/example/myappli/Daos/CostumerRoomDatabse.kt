package com.example.myappli.Daos

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myappli.Interfaces.Costumer
import com.example.myappli.Interfaces.CostumerDao


@Database(entities = arrayOf(Costumer::class), version = 1, exportSchema = false)
abstract class CostumerRoomDatabase: RoomDatabase() {

    abstract fun costumerDao(): CostumerDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: CostumerRoomDatabase? = null

        fun getDatabase(context: Context): CostumerRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CostumerRoomDatabase::class.java,
                    "costumer_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}