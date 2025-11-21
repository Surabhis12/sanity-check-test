class Calculator {
    fun add(a: Int, b: Int): Int = a + b
}

fun main() {
    val calc = Calculator()
    println(calc.add(2, 3))
}
