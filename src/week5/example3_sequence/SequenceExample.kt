package week5.example3_sequence

import kotlin.random.Random

fun main() {
    val list = listOf(1, 2, -1)
    val maxOddSquare = list
            .asSequence()
            .map { it * it }
            .filter { it % 2 == 1 }
            .max()
    println(maxOddSquare)

    //Sequence finished when takeIf returns null
    val s = generateSequence { Random.nextInt(5).takeIf { it > 1 } }
    println("Random: ${s.toList()}")

    //Infinite sequence
    val s2 = generateSequence(0) { it + 2 }
    println("First 5 even numbers: ${s2.take(5).toList()}")
}