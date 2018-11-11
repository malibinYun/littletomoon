package com.example.modelmaker.loginkt.dataController

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceController{
    private val IS_STAY_LOGIN : String = "isStay"

    //로그인 유지 데이터
    fun setCheckStayLogin(ctx : Context, input_status : Boolean) {
        val preference: SharedPreferences = ctx.getSharedPreferences(IS_STAY_LOGIN, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preference.edit()
        editor.putBoolean(IS_STAY_LOGIN, input_status)
        editor.commit()
    }

    fun getCheckStayLogin(ctx: Context): Boolean {
        val preferences: SharedPreferences = ctx.getSharedPreferences(IS_STAY_LOGIN,Context.MODE_PRIVATE)
        return preferences.getBoolean(IS_STAY_LOGIN,false)
    }


}