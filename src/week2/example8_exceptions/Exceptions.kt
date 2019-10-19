package week2.example8_exceptions

import java.io.IOException
import java.lang.IllegalArgumentException

fun checkPercentage(number: Int) {
    val percentage =
            if (number in 0..100)
                number
            else //Can assign 'throw' to a variable. In Java it won't compile
                throw IllegalArgumentException("Wrong number. Should be between 0 and 100: $number")
}

fun parseNum(s: String): Int =
    //try is expression. Can be assigned to result
    try {
        Integer.parseInt(s)
    } catch (e: NumberFormatException) {
        0 //Default return value
    }

// Need this annotation only for checked exceptions and only if need to call
// this function from Java. Otherwise you can not try-catch this exception
// in Java - compile will say what this exception is never thrown in this code block
@Throws(IOException::class)
fun foo() {
    throw IOException()
}

fun main() {
    println(parseNum("abc"))
}