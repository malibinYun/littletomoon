package com.example.modelmaker.loginkt

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.modelmaker.loginkt.dataController.SharedPreferenceController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_sginout.setOnClickListener {
            SharedPreferenceController.setCheckStayLogin(this,false)
        }


        btn_check_token.setOnClickListener {
            val intent = Intent()
            val id:String = intent.getStringExtra("id")
            //val token : String = SharedPreferenceController.getUserToken(this,id)
            Log.v("토큰 확인","$id 의 토큰 : ")
        }

        btn_del_token.setOnClickListener {
            val intent = Intent()
            val id:String = intent.getStringExtra("id")

            SharedPreferenceController.setUserToken(this,id,"")

            val token : String = SharedPreferenceController.getUserToken(this,id)
            Log.v("토큰 제거","$id 의 토큰 : $token")
        }
    }
}
