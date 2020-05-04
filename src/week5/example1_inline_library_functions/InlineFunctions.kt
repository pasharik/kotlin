package week5.example1_inline_library_functions

fun main() {
    42.takeIf { it > 10 }
            ?.let { println("The number is: $it"); it * 10 }
            ?.let { println("Updated number in next function: $it") }

    repeat(10) {
        println(it)
    }
}
