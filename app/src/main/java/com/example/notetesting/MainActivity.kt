package com.example.notetesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notetesting.Model.ReadDataModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var textViewt:TextView
    lateinit var recyclerView: RecyclerView
    lateinit var listy: List<ReadDataModel>
    lateinit var adapter:adapterClass
    lateinit var viewModel:testingViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView=findViewById(R.id.recycler)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager=LinearLayoutManager(applicationContext)

        //Building Retrofit
        val retrofit:Retrofit=Retrofit.Builder()
            .baseUrl("https://api.myjson.com/bins/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //Creating using the Interface class
        val  fetch:RetrofitfetchApi=retrofit.create(RetrofitfetchApi::class.java)

        val list:Call<List<ReadDataModel>>
        list=fetch.getData()


        viewModel=ViewModelProviders.of(this).get(testingViewModel::class.java)

        val data:LiveData<List<ReadDataModel>> = viewModel.getData()

        data.observe(this, object : Observer<List<ReadDataModel>> {

            override fun onChanged(t: List<ReadDataModel>?) {

                adapter.setData(t!!)


            }


        })



        list.enqueue(object : Callback<List<ReadDataModel>> {

            override fun onResponse(call: Call<List<ReadDataModel>>, response: Response<List<ReadDataModel>>) {
              if (!response.isSuccessful){

                  Toast.makeText(applicationContext,""+response.code(),Toast.LENGTH_LONG).show()
                  return

              }

                Toast.makeText(applicationContext,"Data Found",Toast.LENGTH_LONG).show()

                val  list:List<ReadDataModel>
                list= response.body()!!

                viewModel.getData()

                adapter=adapterClass()
                adapter.setData(list)
                recyclerView.adapter=adapter

               /* for (data in list){
                    val name:String=data.name
                    val dep:String=data.dep
                    val proj:String=data.proj
                    val home:String=data.home

                    listy= arrayListOf(ReadDataModel(data.name,data.dep,data.home,data.proj))

                }
*/

            }

            override fun onFailure(call: Call<List<ReadDataModel>>, t: Throwable) {

                Toast.makeText(applicationContext,"Throw is\t"+t.message,Toast.LENGTH_LONG).show()
                print(t.message)

            }


        })





    }


}
