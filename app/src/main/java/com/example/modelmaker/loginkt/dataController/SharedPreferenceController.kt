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
        val preference: SharedPreferences = ctx.getSharedPreferences(IS_STAY_LOGIN,Context.MODE_PRIVATE)
        return preference.getBoolean(IS_STAY_LOGIN,false)
    }

    //유저 토큰 데이터
    fun setUserToken(ctx: Context, inputUserId : String, inputToken : String){
        val preference: SharedPreferences = ctx.getSharedPreferences(inputUserId,Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = preference.edit()
        editor.putString(inputUserId,inputToken)
        editor.commit()
    }

    fun getUserToken(ctx: Context, inputUserId: String): String{
        val preference: SharedPreferences = ctx.getSharedPreferences(inputUserId,Context.MODE_PRIVATE)
        return preference.getString(inputUserId,"nothing")
    }


}