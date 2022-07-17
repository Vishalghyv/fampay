package com.vishal.contextualcards.data.network

import com.vishal.contextualcards.utils.APIException
import retrofit2.Response
import java.io.IOException

abstract class SafeAPIRequest {

    suspend fun<T: Any> apiRequest(call: suspend  () -> Response<T>) : T {
        val response = call()
        if(response.isSuccessful) {
            return response.body()!!
        } else {
            val message = StringBuilder()
            message.append("Error Code: ${response.code()}\n")
            kotlin.runCatching {
                message.append("${response.errorBody()?.string()}")
            }.onFailure {
                when (it) {
                    is IOException -> message.append("IOE while converting response.errorBody to string")
                    else -> throw it
                }
            }
            throw APIException(message.toString())
        }
    }

}