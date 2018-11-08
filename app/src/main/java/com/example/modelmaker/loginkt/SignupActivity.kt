package com.example.modelmaker.loginkt

import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_signup.*
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SignupActivity : AppCompatActivity() {

    lateinit var ET_id: EditText
    lateinit var ET_password: EditText
    lateinit var ET_repassword: EditText
    lateinit var ET_name: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        ET_id = findViewById(R.id.et_id)
        ET_password = findViewById(R.id.et_password)
        ET_repassword = findViewById(R.id.et_repassword)
        ET_name = findViewById(R.id.et_name)


        val retrofit = Retrofit.Builder()
                .baseUrl("http://13.125.250.151:8284")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        var server = retrofit.create(ChaninService::class.java)


        //가입하기버튼 리스너
        btn_submit.setOnClickListener {
            val id = ET_id.text.toString()
            val password = ET_password.text.toString()
            val repassword = ET_repassword.text.toString()
            val name = ET_name.text.toString()

            if(id.equals("")){
                toast("아이디를 입력해주세요")
                return@setOnClickListener
            }
            if(password.equals("")){
                toast("비밀번호를 입력해주세요")
                return@setOnClickListener
            }
            if(!password.equals(repassword)) {
                toast("비밀번호가 서로 일치하지 않습니다.")
                return@setOnClickListener
            }

            server.signupRequest(id,password,name).enqueue(object: Callback<SignupResponseData>{
                override fun onFailure(call: Call<SignupResponseData>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(call: Call<SignupResponseData>, response: Response<SignupResponseData>) {

                    Log.v("호롤ㄹ롤롤",response.body().toString())
                    var msg = response.body()?.msg.toString()

                    when(msg) {
                        "success" -> {
                            val intent = Intent()
                            intent.putExtra("id",id)
                            setResult(Activity.RESULT_OK,intent)
                            finish()
                        }
                        "duplicated" -> {
                            toast("중복된 아이디 입니다.")
                            ET_id.setText("")
                        }
                        "fail" -> {
                            toast("?????????아돈노")
                        }
                    }
                }


            })



        }
    }
}
