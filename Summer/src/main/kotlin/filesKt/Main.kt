package filesKt

fun main() {
    var a: Double?;
    var b: Double?;
    var op: String?;

    a = 9.0;
    b = null;

    op = "/"

    println(calc(a, b, op))
}

fun calc(a: Double?, b: Double?, op: String?): Double? {
    var ans: Double?;

    when(op){
        "+" -> ans = a!! + b!!;
        "-" -> ans = a!! - b!!;
        "*" -> ans = a!! * b!!;
        "/" -> ans = a!! / b!!;
        else -> ans = null;
    }

    return ans;
}

class Calculator{
    private var name: String? = null;
    private var age: Int? = null;

    constructor(name: String?, age: Int?) {
        this.name = name
        this.age = age
    }


}