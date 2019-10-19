package week2.example9_extension_functions.definition

/* Entire Kotlin standard library is just a set of extensions on top of Java standard library */

fun checkTypes() {
    val set = hashSetOf(1, 20, 55);
    val list = arrayListOf("Abc", "nnn", "foo")
    val map = hashMapOf(1 to "Aaa", 5 to "Bbb", 20 to "Ccc")

    println(set.javaClass)    //class java.util.HashSet
    println(list.javaClass)   //class java.util.ArrayList
    println(map.javaClass)    //class java.util.HashMap

    list.getOrNull(1)   // getOrNull() - extension function

    // -- UNTIL --
    // i.until(20)
    // infix fun Int.until
    // 'untill' is just an extension function, but with 'infix' keyword.
    // This allows us to write '1 until 10' - no need for call .until(..)

    // -- TO --
    // Also just infix extension function. Same as: "abc".to(10)
    // Returns Pair<A, B>

    val c: Char = 'a'
    c.isDigit()              // extension function
}

fun stringExtensionExamples() {
    // Multiline string using triple quotes
    val q = """
        To code, 
        or not to code?...""".trimIndent() //To get rid of indent

    "123".toInt()
    "1e-10".toDouble()
    "xx".toIntOrNull()  //null
}

fun main() {
    checkTypes()
    //stringExtensionExamples()
}