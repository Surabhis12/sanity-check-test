import java.util.*

fun main() {
    println("test")  // OK in main, but shows in output
    
    val password = "hardcoded123"  // ERROR: hardcoded password
    val result: String = getValue() as String  // ERROR: unsafe cast
}

fun getValue(): Any? {
    return null
}