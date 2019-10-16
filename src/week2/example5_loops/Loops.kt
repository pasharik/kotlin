package week2.example5_loops

fun loopList() {
    val list = listOf("a", "b", "c")
    for (a: String in list) {
        println(a)
    }
    for ((index, value) in list.withIndex()) {
        println("$index : $value")
    }
    for (i:Int in 1..9) print(i)  //9 is included
    println()
    for (i in 1 until 9) print(i) //9 is excluded
    println()
    for (i in 20 downTo 2 step 3) print("$i ")
    println()
    for (c in "abc") print(c + 1)
}

fun loopMap() {
    val map = mapOf(
            1 to "One",
            2 to "Two",
            3 to "Three")
    for (m in map) {
        println("${m.key} - ${m.value}")
    }
    for ((key, value) in map) {
        println("$key : $value")
    }
}

fun main() {
    loopList()
    //loopMap()
}