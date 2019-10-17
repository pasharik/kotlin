package week2.example6_ranges

// 'in' can be used to check if value is inside of range
fun isLetter(c: Char): Boolean = c in 'a'..'z' || c in 'A'..'Z'

fun isNotDigit(c: Char): Boolean = c !in '0'..'9'

fun recognize(c: Char): CharSequence = when(c) {
    in '0'..'9' -> "Digit"
    in 'a'..'z', in 'A'..'Z' -> "Letter"
    else -> "Unknown character"
}

// class MyDate : Comparable<MyDate>
// (myDate in startDate..endDate) - it will work, if MyDate class implements Comparable
// can also compare (myDate < startDate) - no need to call .compareTo(startDate)

fun main() {
    println("ball" in "a".."z") //true
    println("Kotlin" in "Java".."Scala") //true
    println("Kotlin" in setOf("Java", "Scala")) //false
}
