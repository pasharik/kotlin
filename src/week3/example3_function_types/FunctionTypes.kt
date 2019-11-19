package week3.example3_function_types

// 'SAM interface' - Single Abstract Method
// Can store lambda in a variable, but can NOT store a function

//  sum: (Int, Int) -> Int = ...
val sum = { x: Int, y: Int -> x + y }

val isEven: (Int) -> Boolean = { x: Int -> x % 2 == 0 }

val nullFunc: ((Int) -> Int)? = null  // lambda itself is null

fun types() {
    val list = listOf(1, 2, 4, 5, 7)
    println(list.filter(isEven))
    nullFunc?.invoke(42)  // safe call for nullable function
}

fun main() {
    types()
}