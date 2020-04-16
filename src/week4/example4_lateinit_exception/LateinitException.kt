package week4.example4_lateinit_exception


class A {
    lateinit var foo: String //Should be vaR
    fun setUp() {
        foo = "abc"
    }
}

fun main() {
    val a = A()
    a.setUp() //Need to be called. Otherwise UninitializedPropertyAccessException
    println(a.foo)
}