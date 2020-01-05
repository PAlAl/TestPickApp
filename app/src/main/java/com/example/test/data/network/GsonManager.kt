package com.example.test.data.network

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder

object GsonManager {
    val instance: Gson
        get() {
            return GsonBuilder()
                    .serializeNulls()
                    .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                    .create()
        }
}