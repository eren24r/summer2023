package filesKt

import java.lang.Exception

fun main(){
    while(true) {
        work()
    }
}

fun bigSymbols(len: Int): String {
    val allBigSymbols = "QWERTYUIOPASDFGHJKLZXCVBNM"

    val countOfSymbols = ((len.toFloat() / 100) * 12.5.toFloat()).toInt()

    return giveRandSymbols(allBigSymbols, countOfSymbols)
}

fun smallSymbols(len: Int): String {
    val allBigSymbols = "qwertyuiopasdfghjklzxcvbnm"

    val countOfSymbols = ((len.toFloat() / 100) * 12.5.toFloat()).toInt()

    return giveRandSymbols(allBigSymbols, countOfSymbols)
}

fun numberSymbols(len: Int): String {
    val allBigSymbols = "1234567890"

    val countOfSymbols = ((len.toFloat() / 100) * 12.5.toFloat()).toInt()

    return giveRandSymbols(allBigSymbols, countOfSymbols)
}

fun onlySymbols(len: Int): String {
    val allBigSymbols = "~!@#$%^&*()_+.=-/*?^:;№\""

    val countOfSymbols = ((len.toFloat() / 100) * 12.5.toFloat()).toInt()

    return giveRandSymbols(allBigSymbols, countOfSymbols)
}

fun allSymbols(len: Int): String {
    val allBigSymbols = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890~!@#$%^&*()_+.=-/*?^:;№\""

    val countOfSymbols = len - (((len.toFloat() / 100) * 12.5.toFloat()).toInt() * 4)

    return giveRandSymbols(allBigSymbols, countOfSymbols)
}

fun giveRandSymbols(str: String, count: Int): String{
    var res = ""

    for(i in 0 until count){
        res = res + str.get((0 until str.length).random())
    }

    return res
}

fun passwordGen(len: Int): String{
    return bigSymbols(len) + smallSymbols(len) + numberSymbols(len) + onlySymbols(len) + allSymbols(len)
}

fun work(){
    print("Length of password (minimum length 8): ")

    try {
        val len = readln().toInt()

        if(len < 8){
            println("minimum length 8!!!")
            return
        }

        val res = passwordGen(len)
        println(res)
        println(res.length)

    }catch(e: Exception){
        println("Enter only number!!!")
        return
    }
}