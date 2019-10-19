package week2.example9_extension_functions

//import week2.example9_extension_functions.definition.lastChar
//import week2.example9_extension_functions.definition.repeat
import week2.example9_extension_functions.definition.* //Or can import all functions at once

fun main() {
    //Need to IMPORT extension function. Or have it in the same package
    println("abc".lastChar())
    println("Abc".repeat(3))
}