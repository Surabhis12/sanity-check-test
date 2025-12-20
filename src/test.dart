import 'dart:convert';

class myWidget {  // Error: lowercase class name
  final apiKey = "secret-key-123";  // Error: hardcoded secret
  
  void loadData() {
    print("Loading data");  // Error: print() used
    
    var result = data as String;  // Error: unsafe cast
    
    
    String sql = "SELECT * FROM users WHERE id=$userId";  // Error: SQL injection
  }
}