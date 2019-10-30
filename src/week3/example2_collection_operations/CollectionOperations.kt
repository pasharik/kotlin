package week3.example2_collection_operations

fun operations() {
    // flatten - combine all sub-collections into single collection
    val list: List<List<Int>> = listOf(listOf(1, 2), listOf(3, 4))
    println(list.flatten())

    val l = listOf(1, 2, 4, 5, 7)
    // map - create corresponding list for each element
    val map = l.map { it.rangeTo(it + 4) }
    println(map)

    // flatMap - map and then flatten the result
    val mapFlat = l.flatMap { it.rangeTo(it + 4) }
    println(mapFlat)

    val l2 = listOf(10, 22, 19, 13)

    // zip - union of 2 collections (like when we close a zipper)
    for ((a, b) in l2 zip l) {
        println("$a + $b = ${a + b}")
    }

    // zipWithNext - combine 1st+2nd, 2nd+3rd, etc.
    for ((a, b) in l.zipWithNext()) {
        println("$a - $b")
    }

    l.last()
}

fun main() {
    operations()
}