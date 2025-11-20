import java.io.*
import java.security.MessageDigest
import javax.crypto.Cipher
import kotlin.random.Random

// 1. Wildcard import
import java.util.*

var GLOBAL = "global mutable"     // 17. global mutable state
var CACHE_DATA = "cache"          // 17. global mutable state

fun main() {

    // 2. Multiple statements per line
    val a = 1; val b = 2;

    // 3. Hard-coded secrets
    val apiKey = "12345"
    val password = "mypassword"
    val secret_key = "secret"

    // 4. Weak randomness
    val r1 = Random(System.currentTimeMillis())
    val r2 = Random(java.time.Instant.now().toEpochMilli())

    // 5. Logging secrets
    println("User password is: $password")
    println("Secret key => $secret_key")

    // 6. SQL injection
    val userId = "bob"
    val query = "SELECT * FROM users WHERE id = $userId"

    // 7. Insecure TLS (TrustManager bypass)
    val trustManager = object : javax.net.ssl.X509TrustManager {
        override fun checkServerTrusted(p0: Array<java.security.cert.X509Certificate>, p1: String) {}
        override fun checkClientTrusted(p0: Array<java.security.cert.X509Certificate>, p1: String) {}
        override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate>? = arrayOf()
    }

    // 8. Insecure deserialization
    val ois = ObjectInputStream(FileInputStream("bad.data"))
    val obj = ois.readObject()

    // 9. Force unwrap !!
    val text: String? = null
    println(text!!)

    // 10. Unsafe cast
    val anyValue: Any = "Hello"
    val number = anyValue as Int

    // 11. Command injection
    Runtime.getRuntime().exec("sh -c ls /tmp")
    Runtime.getRuntime().exec("sh -c echo $(date)")

    // 12. Weak MD5 hashing
    val md = MessageDigest.getInstance("MD5")
    val hash = md.digest("hello".toByteArray())

    // 13. Predictable temp file
    val tmp = "/tmp/file_${System.currentTimeMillis()}"

    // 14. RegExp from user input
    val inputPattern = ".*(abc)+"
    val regex = Regex(inputPattern)

    // 15. Unsafe reflection
    val clazz = Class.forName("java.lang.String")
    val instance = clazz.getDeclaredConstructor().newInstance()

    // 16. Blocking I/O
    val content = File("test.txt").readText()
    val bytes = File("test.txt").readBytes()
    File("test_output.txt").writeText("Hello")

    // 18. Weak AES/ECB
    val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    cipher.init(Cipher.ENCRYPT_MODE, javax.crypto.spec.SecretKeySpec(ByteArray(16), "AES"))
}
