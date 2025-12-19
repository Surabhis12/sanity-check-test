import java.util.*;

public class Test {

    public static void main(String[] args) {

        System.out.println("Application started");  // ❌ print instead of logger

        String password = "hardcoded123";            // ❌ hardcoded secret
        String token = "abcd-1234-xyz";               // ❌ another secret

        if (password == "hardcoded123") {             // ❌ string comparison using ==
            System.out.println("Password matched");
        }
    }
}
