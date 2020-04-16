package week4.example1_assignment_rationals.rationals

import java.lang.IllegalArgumentException
import java.math.BigInteger
import java.math.BigInteger.ONE
import java.math.BigInteger.ZERO

data class Rational(private var n_: BigInteger, private var d_: BigInteger) : Comparable<Rational> {
    init {
        require(d != ZERO)
        val sign = d_.signum().toBigInteger()
        val g = n_.gcd(d_)
        n_ = n_ / g * sign
        d_ = d_ / g * sign
    }

    override fun toString(): String = if (d_ == ONE) "$n_" else "$n_/$d_"
    override fun compareTo(other: Rational): Int = (this - other).n_.signum()
    val n: BigInteger get() = n_
    val d: BigInteger get() = d_
}

/* If using non-data class:
class Rational(n_: BigInteger, d_: BigInteger) : Comparable<Rational> {
    val n : BigInteger
    val d : BigInteger
    init {
        val sign = d_.signum().toBigInteger()
        val g = n_.gcd(d_)
        n = n_ / g * sign
        d = d_ / g * sign
    }
    override fun toString(): String = if (d == ONE) "$n" else "$n/$d"
    override fun compareTo(other: Rational): Int = (this - other).n.compareTo(BigInteger.ZERO)
    //override equals & hashCode
}*/

infix fun Int.divBy(other: Int): Rational = Rational(this.toBigInteger(), other.toBigInteger())
infix fun Long.divBy(other: Long): Rational = Rational(this.toBigInteger(), other.toBigInteger())
infix fun BigInteger.divBy(other: BigInteger): Rational = Rational(this, other)
operator fun Rational.plus(other: Rational): Rational {
    val denominator = this.d * other.d
    val num1 = this.n * other.d
    val num2 = other.n * this.d
    val numerator = num1 + num2
    return Rational(numerator, denominator)
}

operator fun Rational.minus(other: Rational): Rational = this + (-other)

operator fun Rational.times(other: Rational): Rational {
    val numerator = this.n.multiply(other.n)
    val denominator = this.d.multiply(other.d)
    return Rational(numerator, denominator)
}

operator fun Rational.div(other: Rational): Rational {
    val upsideDown = Rational(other.d, other.n)
    return this * upsideDown
}

operator fun Rational.unaryMinus() = Rational(-this.n, this.d)

// 'this@toRational' - means String from outer function
fun String.toRational(): Rational {
    fun String.bigIntOrFail() = this.toBigIntegerOrNull()
            ?: throw IllegalArgumentException("Unexpected format: " + "${this@toRational}")
    this.split("/").let {
        return Rational(it[0].bigIntOrFail(), if (it.size > 1) it[1].bigIntOrFail() else ONE)
    }
}

fun main() {
    1 to 2
    val half = 1 divBy 2
    val third = 1 divBy 3

    val sum: Rational = half + third
    println(5 divBy 6 == sum)

    val difference: Rational = half - third
    println(1 divBy 6 == difference)

    val product: Rational = half * third
    println(1 divBy 6 == product)

    val quotient: Rational = half / third
    println(3 divBy 2 == quotient)

    val negation: Rational = -half
    println(-1 divBy 2 == negation)

    println((2 divBy 1).toString() == "2")
    println((-2 divBy 4).toString() == "-1/2")
    println("117/1098".toRational().toString() == "13/122")

    val twoThirds = 2 divBy 3
    println(half < twoThirds)

    println(half in third..twoThirds)

    println(2000000000L divBy 4000000000L == 1 divBy 2)

    println("912016490186296920119201192141970416029".toBigInteger() divBy
            "1824032980372593840238402384283940832058".toBigInteger() == 1 divBy 2)
}
