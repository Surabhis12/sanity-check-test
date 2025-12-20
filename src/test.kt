import java.util.*

class Test {
    fun main() {
        // Force unwrap
        val value: String? = null
        println(value!!)
        
        // Hard-coded password
        val password = "hardcoded123"
        
        // SQL injection
        val userId = "input"
        val query = "SELECT * FROM users WHERE id=$userId"
    }
}