package com.example.modelmaker.loginkt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().apply{
            postDelayed({

                //ANKO 라이브러리
                startActivity<LoginActivity>()
                finish()

                //일반 코틀린 문법
//                val intent : Intent = Intent(this@SplashActivity,LoginActivity::class.java) //보내는 액티비티, 목적지 액티비티 가 인텐트 안의 매개변수래
//                intent.putExtra("data1", "Hello")
//                intent.putExtra("data2","World!")
//                intent.putExtra("data3",1000)
//                startActivity(intent);
                //finish()


            }, 2000)//인위적으로 딜레이를 주는 함수 2초설정함
        }

    }
}
