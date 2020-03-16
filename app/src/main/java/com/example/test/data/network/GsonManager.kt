package com.example.test.data.network

import com.google.gson.*
import org.joda.time.DateTime
import java.lang.reflect.Type

object GsonManager {
    val instance: Gson
        get() {
            return GsonBuilder()
                    .serializeNulls()
                    .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                    .registerTypeAdapter(DateTime::class.java, dateTypeAdapter)
                    .create()
        }

    private val dateTypeAdapter = object : JsonDeserializer<DateTime>, JsonSerializer<DateTime> {
        override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): DateTime? {
            return try {
                DateTime(json.asLong * 1000)
            } catch (e: Exception) {
                Thread.currentThread().uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), e)
                null
            }
        }

        override fun serialize(src: DateTime?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement {
            return src?.let {
                JsonPrimitive(it.millis / 1000)
            } ?: JsonNull.INSTANCE
        }
    }
}