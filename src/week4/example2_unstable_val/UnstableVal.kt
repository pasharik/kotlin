package week4.example2_unstable_val

var counter = 0
val foo: Int
    get() {
        return counter++
    }

fun main() {
    //values should be different
    println(foo)
    println(foo)
    println(foo)
}