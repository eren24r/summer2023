package algorithm

fun quickSort(array: Array<Int>): Array<Int>{
    if(array.isEmpty() || array.size == 1){
        return array
    }else{
        val pivot = array[0]
        var leftArray = emptyArray<Int>()
        var rightArray = emptyArray<Int>()

        for(i in 1 until array.size){
            if(array[i] > pivot){
                rightArray = rightArray.plus(array[i])
            }else{
                leftArray = leftArray.plus(array[i])
            }
        }

        return quickSort(leftArray) + arrayOf(pivot) + quickSort(rightArray)
    }
}

fun main(){
    val array = arrayOf(998, 7, 45, 2, 1, 8, 0, -6, 8, 898, -876, 787)

    val res = quickSort(array)

    res.forEach { println(it) }
}