package week2.example7_playground_regex

fun regexTest(s: String) {
    //With triple quotes don't need to escape back slashes
    //toRegex() is an extension function
    val reg = """\d{2}\.\d{2}\.\d{4}""".toRegex()
    reg.matches("12.10.2019") //true
    reg.matches("12.10.19")   //false
}