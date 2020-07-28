package week5.example5_lambda_with_receiver

import java.lang.StringBuilder

fun exampleLambdaWithReceiver() {
    val isEven: (Int) -> Boolean = { it % 2 == 0 }    //regular lambda
    val isOdd: Int.() -> Boolean = { this % 2 == 1 }  //lambda with receiver (extension lambda)
    isEven(2)
    2.isOdd()

    //////
    with (StringBuilder()) {
        append("line1")
    }

    //library function with SB inside
    buildString { append("String1\n") }
}

fun main() = exampleLambdaWithReceiver()
