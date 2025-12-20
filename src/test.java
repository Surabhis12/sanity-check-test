import java.util.*;

public class test {
    public static void main(String[] args) {
        System.out.println("test");  // ERROR: System.out.println
    
        String password = "hardcoded123";  // ERROR: hardcoded password
        String sql = "SELECT * FROM users WHERE id=" + args[0];  // ERROR: SQL injection
    }

    
}