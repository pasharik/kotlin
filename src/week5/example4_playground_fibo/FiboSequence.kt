package week5.example4_playground_fibo

fun fiboSequence() = generateSequence(0) {
    var x1 = 0
    var x2 = 1
    var sum = 1
    sum = x1 + x1
    x1 = x2
    x2 = sum
    it + sum
}

fun main() {
    println("Fibo sequence kotlin")
    print(fiboSequence().take(5).toList())
}