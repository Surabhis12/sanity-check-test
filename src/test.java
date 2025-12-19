import java.util.logging.Logger;

public class Test {

    private static final Logger LOGGER = Logger.getLogger(Test.class.getName());

    public static void main(String[] args) {

        LOGGER.info("Application started");

        String password = System.getenv("APP_PASSWORD");

        if (password == null || password.isBlank()) {
            LOGGER.warning("Required environment variable is missing");
        }

        
        // No logging related to sensitive data
        // Application continues safely
    }
}
