package week3.example5_assignment_nice_string

fun String.isNice(): Boolean {
    //!this.contains("""(bu)|(ba)|(be)""".toRegex())
    val noBadStrings = setOf("bu", "ba", "be").none { this.contains(it) }
    val hasThreeVowels = this.sumBy { if ("aeiou".contains(it)) 1 else 0 } >= 3
    val hasDoubles = this.zipWithNext().any { it.first == it.second }
    return listOf(noBadStrings, hasThreeVowels, hasDoubles).count { it } >= 2
}
