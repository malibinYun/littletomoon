package com.example.modelmaker.loginkt

import android.graphics.Rect
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_test.*
import org.jetbrains.anko.toast

class testActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        var r : Rect = Rect()

        btn_getpoint.setOnClickListener {
            btn_getpoint.getGlobalVisibleRect(r)
            toast("버튼의 절대좌표 left : "+r.left+" right : "+r.right+" bottom : "+r.bottom+" top : "+r.top)
        }

        iv_disgust.setOnClickListener {
            iv_disgust.getGlobalVisibleRect(r)
            toast("이미지의 절대좌표 left : "+r.left+" right : "+r.right+" bottom : "+r.bottom+" top : "+r.top)
        }
    }
}
