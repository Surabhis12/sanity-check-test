import java.io.*;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import java.util.Random;
import javax.net.ssl.X509TrustManager;

// 1. Class name starting with lowercase (class naming violation)
class badclass {

    // 2. Hard-coded credentials
    String password = "mypassword";
    String secret = "topsecret";
    String apiKey = "12345";

    public void test() throws Exception {

        // 3. System.out.println usage
        System.out.println("Debug info");
        System.out.println("Password: " + password);

        // 4. Wildcard import (import java.util.*; included above)

        // 5. SQL injection via concatenation
        String id = "admin";
        String sql = "SELECT * FROM users WHERE id = " + id;

        // 6. Command injection
        Runtime.getRuntime().exec("sh -c ls");
        ProcessBuilder pb = new ProcessBuilder("sh", "-c", "echo hello");

        // 7. Insecure TLS trust manager
        X509TrustManager trustAll = new X509TrustManager() {
            public void checkClientTrusted(java.security.cert.X509Certificate[] c, String a) {}
            public void checkServerTrusted(java.security.cert.X509Certificate[] c, String a) {}
            public java.security.cert.X509Certificate[] getAcceptedIssuers() { return new java.security.cert.X509Certificate[0]; }
        };

        // 8. Insecure deserialization
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.ser"));
        Object obj = ois.readObject();

        // 9. Weak randomness
        Random r = new Random(System.currentTimeMillis());

        // 10. Null dereference pattern
        String x = null;
        if (x == null) {
            x.length(); // dereference
        }

        // 11. Resource leak (no close())
        FileInputStream fis = new FileInputStream("test.txt");
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));

        // 12. String == comparison
        String s1 = new String("hello");
        if (s1 == "hello") {}

        // 13. equals() without hashCode()
        equals(new Object());

        // 14. Weak MD5 and DES usage
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        Cipher cipher = Cipher.getInstance("DES");

        // 15. AES/ECB usage
        Cipher c2 = Cipher.getInstance("AES/ECB/PKCS5Padding");

        // 16. Predictable temp files
        File tmp = new File("/tmp/" + System.currentTimeMillis() + ".log");

        // 17. Unsafe reflection
        Class<?> clazz = Class.forName("java.lang.String");
        clazz.getDeclaredConstructor().setAccessible(true);

        // 18. Integer overflow pattern
        int big = Integer.MAX_VALUE + 1;

        // 19. Logging secrets
        System.out.println("Secret: " + secret);
    }

    // equals overridden but hashCode missing
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}

public class test_bad {
    public static void main(String[] args) throws Exception {
        new badclass().test();
    }
}
