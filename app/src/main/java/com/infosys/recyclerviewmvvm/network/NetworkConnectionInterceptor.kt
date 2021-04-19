package com.infosys.recyclerviewmvvm.network

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import com.infosys.recyclerviewmvvm.util.NoInternetException
import okhttp3.Interceptor
import okhttp3.Response
import java.util.logging.Logger

@Suppress("DEPRECATION")
class NetworkConnectionInterceptor(
    val context: Context
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isInternetAvailable())
            throw NoInternetException("Make sure you have an active data connection")

        val authHeader=""


        Log.e("authheaerd",authHeader)
        val request =
            chain.request().newBuilder().addHeader("version", "92")
                .addHeader("content-type", "multipart/form-data")
                .addHeader("cache-control", "no-cache")
                .addHeader(
                    "Authorizationheader",
                    authHeader
                )
                .build()
        return chain.proceed(request)
    }

    private fun isInternetAvailable(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = connectivityManager.activeNetworkInfo
        return netInfo != null && netInfo.isConnected

    }

}