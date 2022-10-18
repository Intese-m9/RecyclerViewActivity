package com.example.recyclerviewactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewactivity.adapterRecycler.UserAdapter
import com.example.recyclerviewactivity.databinding.ActivityMainBinding
import com.example.recyclerviewactivity.model.UserModel
import com.example.recyclerviewactivity.retrofit.RandomApi
import com.example.recyclerviewactivity.retrofit.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var resultEducationApi: String = ""
    private var resultRecreation: String = ""

    private var resultEducationApi2: String = ""
    private var resultRecreation2: String = ""

    private var resultEducationApi3: String = ""
    private var resultRecreation3: String = ""

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: UserAdapter
    lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        GlobalScope.launch(Dispatchers.Main) {
            val randomApi = RetrofitHelper.getInstance().create(RandomApi::class.java)
            val EducationApi = randomApi.getEducation().body()?.activity
            val RecreationApi = randomApi.getRecreational().body()?.activity

            val EducationApi2 = randomApi.getEducation().body()?.activity
            val RecreationApi2 = randomApi.getRecreational().body()?.activity

            val EducationApi3 = randomApi.getEducation().body()?.activity
            val RecreationApi3 = randomApi.getRecreational().body()?.activity

             resultEducationApi = EducationApi.toString()
             resultRecreation = RecreationApi.toString()

            resultEducationApi2 = EducationApi2.toString()
            resultRecreation2 = RecreationApi2.toString()

            resultEducationApi3 = EducationApi3.toString()
            resultRecreation3 = RecreationApi3.toString()



            initial()

        }
    }

    private fun initial() {
        recyclerView = binding.rvUser
        adapter = UserAdapter(this)
        recyclerView.adapter = adapter
        adapter.setList(myUserData())

    }

    fun myUserData(): ArrayList<UserModel>{
        //add elements to list
        val userList = ArrayList<UserModel>()
        val randomOne = UserModel(resultEducationApi,resultRecreation)
        userList.add(randomOne)

        val randomTwo = UserModel(resultEducationApi2,resultRecreation2)
        userList.add(randomTwo)

        val randomThree = UserModel(resultEducationApi3,resultRecreation3)
        userList.add(randomThree)


        return userList
    }
}