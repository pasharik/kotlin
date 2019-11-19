package week3.example4_member_references

// funn = { main() }
//val funn = ::main  // function reference - under the hood it's a lambda, which calls this method

fun isEven(i: Int) = i % 2 == 0

fun main() {
    //::isEven(2)
    val list = listOf(1, 2, 4, 5)
    println(list.filter(::isEven))
    //println("Member reference")
}
