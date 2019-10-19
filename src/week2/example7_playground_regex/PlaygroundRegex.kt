package week2.example7_playground_regex

// Implement the function that checks whether a string is a valid identifier.
// A valid identifier is a non-empty string that starts with a letter or underscore
// and consists of only letters, digits and underscores.

fun isValidIdentifier(s: String): Boolean {
    val regex = """^[_a-zA-Z][_a-zA-Z0-9]*""".toRegex()
    return regex.matches(s)
}

fun main(args: Array<String>) {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}