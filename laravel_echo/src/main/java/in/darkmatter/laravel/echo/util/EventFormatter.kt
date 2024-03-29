package `in`.darkmatter.laravel.echo.util

class EventFormatter (private val namespace:String?){


    fun format(event:String):String{
        var mEvent  = event
        if(mEvent[0] == '.'  || mEvent[0] == ('\\')){
            return mEvent.substring(1)
        }else if(this.namespace != null){
            mEvent = "${this.namespace}.$mEvent"
        }
        return mEvent.replace("/\\./g".toRegex(), "\\")
    }
}