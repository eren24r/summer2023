package algorithm

fun binSearchBad(array: Array<Int>, element: Int): Int{
    if (array.isEmpty()) {
        return -1
    }

    val ind = array.size / 2
    return if (element == array[ind]) ind
    else if (element > array[ind]) ind + binSearch(array.copyOfRange(ind, array.size), element)
    else binSearch(array.copyOfRange(0, ind), element)
}

fun main(){
    val array = arrayOf(1, 2, 3, 4, 5)

    print(binSearchBad(array, 2))
    print(binSearch(array, -11))
    print(array.binarySearch(5))
}

fun binSearch(array: Array<Int>, element: Int): Int{
    var low = 0
    var high = array.size - 1

    while (low <= high) {
        val mid = (low + high) / 2
        val midVal = array[mid]
        if (midVal < element)
            low = mid + 1
        else if (midVal > element)
            high = mid - 1
        else
            return mid
    }
    return -(low + 1)
}