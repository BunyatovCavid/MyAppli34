package com.example.myappli.Repositories

import androidx.annotation.WorkerThread
import com.example.myappli.Interfaces.Costumer
import com.example.myappli.Interfaces.CostumerDao
import kotlinx.coroutines.flow.Flow


class CostumerRepository (private val costumerDao: CostumerDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allWords: Flow<List<Costumer>> = costumerDao.getAlphabetizedWords()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(costumer: Costumer) {
        costumerDao.insert(costumer)
    }
}