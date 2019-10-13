//@file:JvmName("Func") //Class name for Java. By default FunctionsKt
package week2.example2

import kotlin.math.pow

//Function outside of class - call from Java as a static function
fun max(a: Int, b: Int): Int = if (a > b) a else b

fun min(a: Int, b: Int): Int {
    fun localFunction(a: Int) = 0; //Just an example of function inside another function
    return if (a < b) a else b;
}

class Functions {
    //Function inside of the class - call from Java as a member function
    fun pow(a: Double, b: Double): Double = a.pow(b)
}
