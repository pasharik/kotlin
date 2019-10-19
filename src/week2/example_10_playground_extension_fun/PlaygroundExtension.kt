package week2.example_10_playground_extension_fun

//Change the 'sum' function so that it was declared as an extension to List<Int>.

fun List<Int>.sum(): Int {
    var res = 0;
    for (i in this) {
        res += i
    }
    return res
}

fun main(args: Array<String>) {
    println(listOf(1, 2, 3).sum())
}
