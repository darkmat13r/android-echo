package `in`.darkmatter.laravel.echo.data

import com.google.gson.annotations.SerializedName

data class Message (
    @SerializedName("content")
    val content :String? = null
)