package `in`.darkmatter.laravel.echo.listener

import `in`.darkmatter.laravel.echo.data.EchoData
import `in`.darkmatter.laravel.echo.data.Message
import android.util.Log
import com.google.gson.Gson
import com.google.gson.internal.LinkedTreeMap
import com.google.gson.reflect.TypeToken

abstract class EchoListener<T> {
    companion object{
        private val TAG = EchoListener::class.java.simpleName
    }
    abstract fun onDataReceived(data: T?)

    fun submitData(it: Any) {
        Log.e(TAG, "Echio data  ${it}")
        val gson = Gson()
        val json = gson.toJson(it)
        val data: EchoData<T> = gson.fromJson(json, genericType<EchoData<T>>())
        Log.e(TAG,"Converted data ${data.data}")
        onDataReceived(data.data)
    }


}

inline fun <reified T> genericType() =  object:TypeToken<T>(){}.type