fun main(args: Array<String>){
    User.get()
}

////////////////////////////////////////////////////////////////////////////

abstract class Model(){
    constructor(map:Map<String,Object>):this()
    abstract class Callback<in T>(val succsessCallback:(T)->Unit):APICallback(){
        override fun onResponse(map:Map<String,Object>){
            succsessCallback(T(map))
        }
    }
}

data class User(var id:Int, var name:String):Model(){
    constructor(map:Map<String,Object>):this(
        id = map.get("id") as Int,
        name = map.get("name").toString()
    )
    companion object{
        fun get(){
            TempAPI.getUser(object:Callback<User>(succsessCallback={
                user:User->
                
            }){})
        }
    }
}

data class Car(var id:Int, var speed:Int):Model(){
    constructor(map:Map<String,Object>):this(
        id = map.get("id") as Int,
        speed = map.get("speed") as Int
    )
    companion object{
        fun get(){
            TempAPI.getCar(object:Callback<Car>(succsessCallback={
                car:Car->
                
            }){})
        }
    }
}



////////////////////////////////////////////////////////////////////////////

class TempAPI{
    companion object{
        fun getUser(callback:APICallback){
            callback.onResponse(mapOf<String, Object>("id" to 1 as Object, "name" to "AAAA" as Object))
        }
        fun getCar(callback:APICallback){
            callback.onResponse(mapOf<String, Object>("id" to 1 as Object, "name" to 190 as Object))
        }
    }
}

abstract class APICallback(){
    abstract fun onResponse(map:Map<String,Object>)    
}
