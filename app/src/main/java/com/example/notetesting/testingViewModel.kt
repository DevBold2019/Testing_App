package com.example.notetesting


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notetesting.Model.ReadDataModel


class testingViewModel: ViewModel() {

     var mutable  : MutableLiveData<List<ReadDataModel>> = MutableLiveData()
     var list: List<ReadDataModel>?=null
    lateinit var  fetch:RetrofitfetchApi
    //private var allNotes: LiveData<List<Note>>


   fun  getData() : MutableLiveData<List<ReadDataModel>> {

       return mutable


       }





}