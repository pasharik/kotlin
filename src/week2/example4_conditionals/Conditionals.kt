package week2.example4_conditionals

import week2.example1_hello.Color;
import week2.example1_hello.Color.*;
import java.lang.Exception

fun getColorDescription(color: Color): String =
    when (color) {
        BLUE -> "cold"
        ORANGE -> "mild"
        //RED -> "hot"
        else -> "hot"
    }

fun response(msg: String) =
    when (msg) {
        "y", "yes" -> println("It's nice to hear!")
        "n", "no" -> println("Sorry to hear that :(")
        else -> println("I didn't understand you...")
    }

//when(...) calls equals()
fun colorMix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(BLUE, RED) -> println("Black")
        setOf(RED, ORANGE) -> println("Still orange...")
        else -> throw Exception("Dirty color")
    }

fun makeSound(pet: Pet) =
    when (pet) {
        is Cat -> pet.meow() //Don't need to cast ((Cat)pet).meow() like in Java
        is Dog -> pet.bark()
        else -> println("Unknown animal")
    }
