package week4.example1_assignment_rationals

import java.math.BigInteger
import java.math.BigInteger.ONE

class Rational(val n: BigInteger, val d: BigInteger) : Comparable<Rational> {
    override fun toString(): String = with(normalize()) {
        if (d == ONE) "$n" else "$n/$d"
    }

    override fun compareTo(other: Rational): Int = (this - other).n.compareTo(BigInteger.ZERO)
    override fun equals(other: Any?): Boolean = with(normalize()) {
        val otherNum = (other as? Rational)?.normalize() ?: return false
        return n == otherNum.n && d == otherNum.d
    }
}

infix fun Int.divBy(other: Int): Rational = Rational(this.toBigInteger(), other.toBigInteger())
infix fun Long.divBy(other: Long): Rational = Rational(this.toBigInteger(), other.toBigInteger())
infix fun BigInteger.divBy(other: BigInteger): Rational = Rational(this, other)
operator fun Rational.plus(other: Rational): Rational {
    val denominator = this.d.multiply(other.d)
    val num1 = this.n.multiply(other.d)
    val num2 = other.n.multiply(this.d)
    val numerator = num1.plus(num2)
    return Rational(numerator, denominator)
}

operator fun Rational.minus(other: Rational): Rational {
    return this + Rational(other.n.negate(), other.d)
}

operator fun Rational.times(other: Rational): Rational {
    val numerator = this.n.multiply(other.n)
    val denominator = this.d.multiply(other.d)
    return Rational(numerator, denominator)
}

operator fun Rational.div(other: Rational): Rational {
    val upsideDown = Rational(other.d, other.n)
    return this * upsideDown
}

operator fun Rational.unaryMinus(): Rational {
    return Rational(this.n.negate(), this.d)
}

fun String.toRational(): Rational =
        this.split("/").let {
            return Rational(BigInteger(it[0]), if (it.size > 1) BigInteger(it[1]) else ONE)
        }

fun Rational.normalize(): Rational {
    var (n2, d2) = if (d.signum() < 0) {
        (n.negate() to d.negate())
    } else {
        (n to d)
    }
    val gcd = n2.gcd(d2)
    n2 = n2.divide(gcd)
    d2 = d2.divide(gcd)
    return Rational(n2, d2)
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
