package com.example.notetesting.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.notetesting.Model.ReadDataModel

@Dao
interface testingDao {

    @Insert
    fun insertnotes(model:ReadDataModel)

    @Query("SELECT * FROM testing_table")

    fun getData():LiveData<List<ReadDataModel>>
}