package com.example.modelmaker.loginkt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.modelmaker.loginkt.dataClasses.UserInfo
import com.example.modelmaker.loginkt.dataController.SharedPreferenceController
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_gototest.setOnClickListener {
            startActivity<testActivity>()
        }
    }

}
