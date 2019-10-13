package week2.example1

fun main(args: Array<String>) {
    val name = if (args.isNotEmpty()) args[0] else "Kotlin";
    println("Hello, $name!")
    println("Hello, ${args.getOrNull(0)}!")
    println("Arithmetic: ${1 + 2}; Function call: ${Math.pow(2.0, 8.0)}")
}
