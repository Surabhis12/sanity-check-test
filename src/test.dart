import 'dart:convert';
import 'dart:io';
import 'dart:math';

void main() {
  // 1. print()
  print("Debug message");
  print("Another debug");

  // 2. lowercase class name
  // This file includes one lowercase class name
}

class badclass {
  // 3. hard-coded secrets
  String apiKey = "12345";
  String password = "mypassword";
  String secret_key = "secret123";

  // 4. weak randomness
  Random r1 = Random(DateTime.now().millisecondsSinceEpoch);
  Random r2 = Random(DateTime.now().microsecondsSinceEpoch);

  void run() {
    // 5. logging secrets
    print("Password is $password");
    print("Secret => $secret_key");

    // 6. insecure TLS
    HttpClient client = HttpClient();
    client.badCertificateCallback = (cert, host, port) => true;

    // 7. predictable temp files
    var tmp = "/tmp/file_${Platform.pid}";
    var tmp2 = "/tmp/data_${DateTime.now().millisecondsSinceEpoch}";

    // 8. unsafe JSON
    var jsonData = json.decode('{"name": "test"}');
    Map<String, dynamic> map = jsonData as Map;

    // 9. SQL injection
    var id = "user1";
    var query = "SELECT * FROM users WHERE id = $id";

    // 10. RegExp from user input (ReDoS)
    String userPattern = ".*(abc)+";
    RegExp r = RegExp(userPattern);

    // 11. unawaited futures
    Future.delayed(Duration(seconds: 3));
    Future(() => print("Doing something"));

    // 12. null assertion operator !
    String? data;
    print(data!);

    // 13. dynamic misuse
    dynamic value = "123";
    int number = value as int;

    // 14. XOR obfuscation
    int x = 123 ^ 0xAB;
    var encrypted = "text".codeUnits.map((c) => c ^ 0xFF);

    // 15. Sync blocking I/O
    File file = File("test.txt");
    var content = file.readAsStringSync();

    // 16. MD5 hashing
    print("md5 hash: 098f6bcd4621d373cade4e832627b4f6");

    // 17. late variable
    late int count;

    // 18. Command execution (command injection)
    Process.run("sh", ["-c", "echo \$(date)"]);
    Process.start("sh", ["-c", "rm -rf /tmp/test"]);
}
