package com.example.modelmaker.loginkt

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {

    lateinit var ET_id: EditText
    lateinit var ET_pass: EditText

    val REQUEST_CODE_SIGNUP_ACTIVITY = 1000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        ET_id = findViewById(R.id.et_id)
        ET_pass = findViewById(R.id.et_password)

        val retrofit = Retrofit.Builder()
                .baseUrl("http://13.125.250.151:8284")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        var server = retrofit.create(ChaninService::class.java)



        btn_signin.setOnClickListener {
            val id: String = ET_id.text.toString()
            val pass: String = ET_pass.text.toString()

            server.signinRequest(id,pass).enqueue(object : Callback<SigninResponseData> {
                override fun onFailure(call: Call<SigninResponseData>, t: Throwable) {

                }

                override fun onResponse(call: Call<SigninResponseData>, response: Response<SigninResponseData>) {


                    Log.e("호롤ㄹ롤롤",response?.body().toString())

                    if(response.body()?.msg.equals("success")) {
                        startActivity<MainActivity>()
                    }else if(response.body()?.msg.equals("fail")){
                        toast("아이디 또는 비밀번호가 틀렸습니다.")
                    }else {
                        toast("?????????????")
                    }
                }
            })

        }
        TV_signup.setOnClickListener {
            startActivityForResult<SignupActivity>(REQUEST_CODE_SIGNUP_ACTIVITY)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==REQUEST_CODE_SIGNUP_ACTIVITY){
            if(resultCode==Activity.RESULT_OK){
                ET_id.setText(data?.getStringExtra("id"))
                toast("회원가입이 완료되었습니다!")
            }

        }

    }

}
