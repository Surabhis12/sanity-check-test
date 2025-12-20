import java.util.logging.Logger

class DataRepository {
    private val logger = Logger.getLogger(DataRepository::class.java.name)
    private val cache = mutableMapOf<String, Any>()
    
    fun fetchData(key: String): Any? {
        logger.info("Fetching data for key: $key")
        return cache[key]
    }
    
    fun saveData(key: String, value: Any) {
        require(key.isNotEmpty()) { "Key cannot be empty" }
        cache[key] = value
        logger.info("Data saved for key: $key")
    }
    
    fun clearCache() {
        cache.clear()
        logger.info("Cache cleared")
    }
    
    fun <T> safeCast(value: Any?, type: Class<T>): T? {
        return if (type.isInstance(value)) {
            type.cast(value)
        } else {
            null
        }
    }
}