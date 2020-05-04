package week5.example2_playground_inlining_filter

fun filterNonZero(list: List<Int>) = list.myFilter { it != 0 }

/*
This is pseudo-code. Compiler generates inlined byte-code.
Entire body taken from Iterable.myFilter
Predicate substituted from filterNonZero
 */
fun filterNonZeroGenerated(list: List<Int>): List<Int> {
    val destination = ArrayList<Int>()
    for (element in list) {
        if (element != 0) { // '{ it != 0 }'
            destination.add(element)
        }
    }
    return destination
}

//Just simplified version of Iterable.filter
inline fun <T> Iterable<T>.myFilter(predicate: (T) -> Boolean): List<T> {
    val destination = ArrayList<T>()
    for (element in this) {
        if (predicate(element)) {
            destination.add(element)
        }
    }
    return destination
}
