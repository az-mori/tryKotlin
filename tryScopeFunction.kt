fun main(args: Array<String>){
    var user:User?=null
    
    println("/////////////////////////////////////////////")
    println("basic usage")
    user?.apply{println("user name ${name}")}?:println("user is null")
    user?.let{println("user name ${it.name}")}?:println("user is null")
    user?.run{println("user name ${name}")}?:println("user is null")
    user?.also{user->println("user name ${user.name}")}?:println("user is null")
    with(user){println("user name ${this?.name}")}
    
    user = User(id=1, name="AAA")
    
    user?.apply{println("user name ${name}")}?:println("user is null")
    user?.let{println("user name ${it.name}")}?:println("user is null")
    user?.run{println("user name ${name}")}?:println("user is null")
    user?.also{user->println("user name ${user.name}")}?:println("user is null")
    with(user){println("user name ${this?.name}")}
    
    println("/////////////////////////////////////////////")
    
}

data class User(var id:Int,var name:String){   
}
