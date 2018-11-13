package com.example.modelmaker.loginkt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.modelmaker.loginkt.dataClasses.UserInfo
import com.example.modelmaker.loginkt.dataController.SharedPreferenceController
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var server : ChaninService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
                .baseUrl("http://13.125.250.151:8284")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        server = retrofit.create(ChaninService::class.java)



        btn_sginout.setOnClickListener {
            SharedPreferenceController.setCheckStayLogin(this, false)
        }


        btn_check_token.setOnClickListener {
            val id: String = intent.getStringExtra("id")
            val token : String = SharedPreferenceController.getUserToken(this,id)
            Log.v("토큰 확인", "$id 의 토큰 : $token")


            server.userInfoRequest(token).enqueue(object : Callback<UserInfoResponseData>{
                override fun onFailure(call: Call<UserInfoResponseData>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(call: Call<UserInfoResponseData>, response: Response<UserInfoResponseData>) {
                    val msg : String = response.body()!!.msg
                    val userInfo : UserInfo = response.body()!!.userInfo!!
                    val flag : Boolean = response.body()!!.flag

                    Log.v("토큰 유저 정보 확인","msg : $msg")
                    Log.v("토큰 유저 정보 확인","userInfo - name : "+userInfo.name)
                    Log.v("토큰 유저 정보 확인","userInfo - phone : "+userInfo.phone)
                    Log.v("토큰 유저 정보 확인","userInfo - email : "+userInfo.email)
                    Log.v("토큰 유저 정보 확인","flag : $flag")

                }

            })
        }

        btn_del_token.setOnClickListener {
            val id: String = intent.getStringExtra("id")
            SharedPreferenceController.setUserToken(this, id, "")

            val token: String = SharedPreferenceController.getUserToken(this, id)
            Log.v("토큰 제거", "$id 의 토큰 : $token")
        }
    }
}
