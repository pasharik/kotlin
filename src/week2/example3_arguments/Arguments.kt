package week2.example3_arguments

//Under the hood Kotlin generates only single function with all parameters
//And another function with description of defaults
fun repeatSeparator(separator: CharSequence = "*", number: Int = 1) {
    repeat(number) {
        print(separator)
    }
    println()
}

//Generates overloaded functions in bytecode;
//There are 2^(n of arguments) possible combinations of arguments
//So with 3 parameters we got 8 functions
//But @JvmOverloads generates only N+1 functions:
/*
  fun()
  fun(a)
  fun(a, b)
 */
//In this case can call from java with 'default' arguments
/*
multiply(Int a) {
    return multiply(a, 1)
}
... etc */
@JvmOverloads
fun multiply(a: Int = 1, b: Int = 1): Int = a * b

fun main() {
    println(listOf('a', 'b', 'c').joinToString(separator = "", prefix = "(", postfix = ")"))
    println(listOf(1, 2, 3).joinToString(separator = "; ", postfix = "."))

    repeatSeparator()
    repeatSeparator("-", 10)
    repeatSeparator("&")
    repeatSeparator(number = 10)
}