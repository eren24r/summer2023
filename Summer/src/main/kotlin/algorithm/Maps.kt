package algorithm

fun main(){
    val myMap = MyMap<String, Int>()
    myMap.addElement("hello", 1)
    myMap.addElement("hi", 2)
    myMap.addElement("can", 3)
    myMap.addElement("i", 4)
    myMap.addElement("sleep", 5)
    myMap.addElement("???", 6)
    myMap.addElement("bro", 7)
    myMap.addElement("i", 8)
    myMap.addElement("want", 9)
    myMap.addElement("to sleep", 10)

    myMap.printAllElement()
}

class MyMap<K, V>{
    private var arraySize = 10
    private var mapArray = Array<Any?>(arraySize, init = {null})

    fun addElement(key: K, value: V){
        if(mapArray[key.hashCode() % arraySize] == null){
            mapArray[key.hashCode() % arraySize] = value
        }
    }

    fun getValue(key: K): V? {
        return if (mapArray[key.hashCode() % arraySize] != null) {
            mapArray[key.hashCode() % arraySize] as V
        }else {
            null
        }
    }

    fun printAllElement(){
        mapArray.forEach { println(it) }
    }
}