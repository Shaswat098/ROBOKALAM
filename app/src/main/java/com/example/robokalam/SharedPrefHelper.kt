package com.example.robokalam

import android.content.Context

object SharedPrefHelper {
    private const val PREF_NAME = "RoboKalamPrefs"
    private const val KEY_IS_LOGGED_IN = "isLoggedIn"
    private const val KEY_USER_EMAIL = "email"
    private const val KEY_USER_NAME = "username"

    fun setLoginStatus(context: Context, isLoggedIn: Boolean) {
        val sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        sharedPref.edit().putBoolean(KEY_IS_LOGGED_IN, isLoggedIn).apply()
    }

    fun getLoginStatus(context: Context): Boolean {
        val sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sharedPref.getBoolean(KEY_IS_LOGGED_IN, false)
    }

    fun setLoggedInUserEmail(context : Context , email : String)  {
        val sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        sharedPref.edit().putString(KEY_USER_EMAIL , email).apply()
    }

    fun getLoggedInUserEmail(context: Context) : String? {
        val sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sharedPref.getString(KEY_USER_EMAIL , null)
    }

    fun setLoggedInUserName(context: Context, username: String) {
        val sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        sharedPref.edit().putString(KEY_USER_NAME, username).apply()
    }

    fun getLoggedInUserName(context: Context) :String? {
        val sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sharedPref.getString(KEY_USER_NAME, null)
    }

    fun clearLoginStatus(context: Context) {
        val sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        sharedPref.edit().clear().apply()
    }
}
