package com.cookandroid.wildlift.singleton

import android.content.Context
import com.android.volley.Request
import com.android.volley.toolbox.Volley

class VolleyHttp private constructor(context: Context) {
    private val queue by lazy { Volley.newRequestQueue(context) }

    companion object {
        private var instance: VolleyHttp? = null

        fun getInstance(context: Context): VolleyHttp {
            return instance ?: synchronized(this) {
                VolleyHttp(context.applicationContext).also {
                    instance = it
                }
            }
        }
    }

    fun <T> request(request: Request<T>) {
        queue.add(request)
    }
}