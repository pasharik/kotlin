package week3.example1_nullable

fun nullCheck() {
    // '?' after type name means it can be null
    // Otherwise compiler will require to set a value
    val s:String? = "abcd"
    val length1 = if (s != null) s.length else 0
    // Same as above
    val length2 = s?.length ?:0
}

fun npeCheck(s:String?): String {
    // Operator !! throws NPE if argument is null, otherwise returns the argument
    // Try to avoid it. Only use when compiler is not smart enough to check
    return s!!
}

fun precedencePuzzler():Int {
    val x:Int? = 1
    val y:Int = 2
    return x ?: 0 + y
    //   = x ?:(0 + y)
    // Result is 1, because '+' has higher precedence than '?:'
    // To 'fix':  (x ?: 0) + y
}

fun main() {
    println(npeCheck("aa"))
    println(precedencePuzzler())
}