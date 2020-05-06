package week5.example4_playground_fibo

fun fibonacci(): Sequence<Int> = sequence {
    var p = Pair(0, 1)
    while (true) {
        yield(p.first)
        p = Pair(p.second, p.first + p.second)
    }
}

fun main(args: Array<String>) {
    println(fibonacci().take(5).toList())
}
