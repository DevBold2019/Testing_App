package com.example.notetesting.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "testing_table")
 data class ReadDataModel(

    @SerializedName("name")
    val name: String,
    @SerializedName("dept")
    val dep: String,
    @SerializedName("home")
    val home: String,
    @SerializedName("project")
    val proj: String

) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}