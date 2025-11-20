import Foundation
import CommonCrypto

// 1. Global mutable state
var GLOBAL_CACHE = 10
var GLOBAL = 5

// 2. Class using implicitly unwrapped optional
class BadClass {
    var name: String!   // implicitly unwrapped optional
    let id: Int!        // implicitly unwrapped optional
    
    init() {
        self.name = "test"
        self.id = 123
    }
    
    func run() {
        // 3. Force unwrap
        let x = name! 
        
        // 4. Force cast
        let anyValue: Any = "123"
        let forcedVal = anyValue as! String
        
        // 5. Hard-coded secrets
        let apiKey = "abcd1234"
        let password = "mypassword"
        let token = "token_secret"
        
        // 6. Storing secrets in UserDefaults
        UserDefaults.standard.set(password, forKey: "pass")
        UserDefaults.standard.set(token, forKey: "token")
        
        // 7. Insecure TLS
        let challenge = URLAuthenticationChallenge()
        let _ = challenge.protectionSpace.serverTrust!   // force unwrap
        
        // 8. Weak randomness for security
        let randomToken = "\(arc4random())_token"
        
        // 9. Weak MD5 hashing
        let digest = CC_MD5("hello", 5, nil)
        print("MD5:", digest as Any)
        
        // 10. Weak XOR obfuscation
        let value = 0xAB ^ 0x10
        
        // 11. SQL injection
        let user = "admin"
        let query = "SELECT * FROM users WHERE name = \(user)"
        
        // 12. Force try
        let file = try! String(contentsOfFile: "/tmp/test.txt")
        
