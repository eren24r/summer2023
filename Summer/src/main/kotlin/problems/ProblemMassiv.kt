package problems

/*
Создание таблицы умножения для всех элементов массива. Например,
если массив состоит из элементов [2, 3, 7, 8, 10], сначала каждый эле-
мент умножается на 2, затем каждый элемент умножается на 3, затем
на 7 и т. д.
 */
fun main(){
    val array = arrayOf(2, 3, 7, 8, 10)
    table(array)
}

fun table(array: Array<Int>){
    for (i in array){
        for(j in array){
            print(j)
            print("*")
            print(i)
            print("=")
            print(i * j)
            println()
        }
    }
}