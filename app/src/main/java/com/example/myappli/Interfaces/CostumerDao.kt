package com.example.myappli.Interfaces

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CostumerDao {
    @Query("SELECT * FROM Costumers")
    fun getAlphabetizedWords(): Flow<List<Costumer>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(costumer: Costumer)

   // @Query("DELETE FROM Costumers Where @id == id ")
    //suspend fun deleteById(id:Int)
}

@Entity(tableName = "Costumers")
data class Costumer(@PrimaryKey val id :Int, val logoUrl:String, val name:String, val description :String)