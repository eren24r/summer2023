package alYan

import java.util.Scanner
import kotlin.math.max
import kotlin.math.sqrt

fun main() {
    val scr = Scanner(System.`in`)
    val a = scr.nextFloat()
    val b = scr.nextFloat()
    val c = scr.nextFloat()
    val d = scr.nextFloat()
    val e = scr.nextFloat()
    val f = scr.nextFloat()

    if(a == 0f && b == 0f && c == 0f && d == 0f && e == 0f && f == 0f) {
        print(5)
    }
    else if(b == 0f && d == 0f) {
        if(a != 0f) {
            print(3)
            print(" ")
            print(e / a)
        }
        else {
            print(3)
            print(" ")
            print(f / c)
        }
    }
    else if(a == 0f && c == 0f){
            if(b != 0f) {
                print(4)
                print(" ")
                print(e / b)
            }
            else {
                print(4)
                print(" ")
                print(f / d)
            }
        }
    else if(a * d == b * c && a * f == c * e) {
        if(b != 0f) {
            print(1)
            print(" ")
            print(-a / b)
            print(" ")
            print(e / b)
        }
        else {
            print(1)
            print(" ")
            print(-c / d)
            print(" ")
            print(f / d)
        }
    }
    else if(a * d == b * c && a * f != c * e) {
        print(0)
        print(" ")
    }
    else {
        print(2)
        print(" ")
        print((e * d - b * f) / (a * d - b * c))
        print(" ")
        print((a * f - e * c) / (a * d - b * c))
    }
}

