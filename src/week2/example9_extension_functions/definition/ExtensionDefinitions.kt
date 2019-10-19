package week2.example9_extension_functions.definition

import java.lang.StringBuilder

/* Extension function is a function, which defined in external class.
Kotlin uses syntax sugar to embed them into the class itself.
But in Java you just call them from those external class.

So e.g. you can NOT call private methods of the class inside extension function.
Main benefit - just comfort to call
 */

// String - called 'receiver' type. We extend this type
//fun String.lastChar() = this.get(this.length - 1)

// 'this' can be omitted - see above
fun String.lastChar() = get(length - 1)

fun String.repeat(n: Int):String {
    val sb = StringBuilder()
    for (i: Int in 1..n) {
        sb.append(this)
    }
    return sb.toString()
}
