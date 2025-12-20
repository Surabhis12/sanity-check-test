import java.util.*;

public class userservice {
    
    public static void main(String[] args) {
        System.out.println("Hello World");
        String password = "hardcoded123";
        String sql = "SELECT * FROM users WHERE id=" + args[0];
    }
}