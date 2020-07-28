package week3.example2_collection_operations

import week3.example2_collection_operations.Gender.*

val heroes = listOf(
        Hero("The Captain", 60, MALE),
        Hero("Frenchy", 42, MALE),
        Hero("The Kid", 9, null),
        Hero("Lady Lauren", 29, FEMALE),
        Hero("First Mate", 29, MALE),
        Hero("Sir Stephen", 37, MALE))

fun operationsHeroes() {
    println(heroes.firstOrNull { it.age == 29 }?.name)
    println(heroes.map { "${it.name} - ${it.age}" })  // map() - returns list
    println("Number of different ages: " + heroes.map { it.age }.distinct().size)
    println("Number of people younger than 30: " + heroes.filter { it.age < 30 }.size)

    // partition - split collection in two
    val (youngest, oldest) = heroes.partition { it.age > 30 }
    println("Number of people older than 30: " + oldest.size)
    println("Oldest hero: " + heroes.maxBy { it.age }?.name)
    println("Are all younger 50? " + heroes.all { it.age < 50 })
    println("Any female? " + heroes.any { it.gender == FEMALE })
}

fun operationsHeroes2() {
    val groupBy: Map<Int, List<Hero>> = heroes.groupBy { it.age }
    println("Most common age: " + groupBy.maxBy { (_, v) -> v.size }?.key)

    // associateBy() - 1:1 mapping. In case of duplicate - override, so last element wins
    val associateBy: Map<String, Hero> = heroes.associateBy { it.name }
    println("Frenchy's age: " + associateBy["Frenchy"]?.age)

    val defaultHero = Hero("Unknown", 0, null)
    println("Unknown hero age: " + associateBy.getOrElse("unknown") { defaultHero }.age)

    // associate() - 1:1 mapping
    println("Map by name to age: " + heroes.associate { it.name to it.age })
}

fun operationsHeroesLazy() {
    println("\nLazy grouping:")
    //asSequence() - similar to Java stream - lazy operations
    println(heroes.asSequence().groupBy { it.age })
    // groupingBy - lazy version of groupBy. eachCount - terminal operation
    println(heroes.asSequence().groupingBy { it.age }.eachCount())
}

data class Hero(val name:String, val age:Int, val gender:Gender?)

enum class Gender {
    MALE,
    FEMALE
}

fun main() {
    operationsHeroes()
    println()
    operationsHeroes2()
    operationsHeroesLazy()
}
