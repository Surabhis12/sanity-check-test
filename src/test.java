import java.util.logging.Logger;

public class Test {

    private static final Logger LOGGER = Logger.getLogger(Test.class.getName());

    public static void main(String[] args) {

        LOGGER.info("Application started");

        String userName = System.getenv("APP_USER");

        if (userName == null || userName.isBlank()) {
            LOGGER.warning("APP_USER environment variable not set");
        } else {
            LOGGER.info("Welcome " + userName);
        }
    }
}
