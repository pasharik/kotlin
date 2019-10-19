package week2.example9_extension_functions.definition

infix fun <A> A.eq(other: A) {
    if (this == other) println("OK")
    else println("Error: $this != $other")
}

fun getAnswer(): Int = 42

fun main() {
    getAnswer() eq 42  //OK
    getAnswer() eq 43  //Error: 42 != 43
}
