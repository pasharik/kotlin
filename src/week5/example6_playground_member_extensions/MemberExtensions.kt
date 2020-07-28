package week5.example6_playground_member_extensions

class Words {
    private val list = mutableListOf<String>()

    // This extension function visible only inside Words class
    // In Java it's compiled to regular function: Words.record(str)
    fun String.record() = list.add(this)
    operator fun String.unaryPlus() = list.add(this)
    ///////

    override fun toString() = list.toString()
}

fun main(args: Array<String>) {
    val words = Words()
    with(words) {
        // The following two lines should compile:
        "one".record()
        +"two"
    }
    println(words.toString() == "[one, two]")
}
