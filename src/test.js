// BAD CODE FOR TESTING SANITY CHECK SCRIPT — DO NOT USE IN REAL PROJECTS!!

// 1. console.log
console.log("Debug message");

// 2. var usage
var count = 0;

// 3. ==
if (count == "0") {
    console.log("Loose equality used");
}

// 4. eval()
eval("console.log('Eval executed')");

// 5. debugger
debugger;

// 6. alert()
alert("Hello!");

// 7. Hard-coded secrets
const api_key = "12345-secret";
let password = "mypassword";

// 8. Math.random() for security-related value
let token = Math.random().toString(36).substring(2);

// 9. Prototype pollution patterns
obj.__proto__.malicious = true;
user.prototype["hack"] = "yes";

// 10. Command injection risky exec()
const { exec } = require("child_process");
exec(`ls ${process.env.USER}`);

// 11. Insecure TLS
const https = require("https");
https.request({ rejectUnauthorized: false });

// 12. SQL Injection
let userId = req.query.id;
let query = `SELECT * FROM users WHERE id = ${userId}`;

// 13. Deprecated Buffer()
let buf = new Buffer("bad");

// 14. Sync file operations
const fs = require("fs");
let data = fs.readFileSync("/tmp/test.txt");

// 15. RegExp from user input (ReDoS risk)
let reg = new RegExp(req.query.pattern);

// 16. Predictable temp file names
let tmpf = `/tmp/file_${Date.now()}`;

// 17. Logging secrets
console.log("User password: ", password);

// 18. Weak XOR obfuscation
let encoded = str.charCodeAt(0) ^ 0xAB;

// 19. innerHTML usage
document.getElementById("demo").innerHTML = req.query.user;

// 20. Wildcard CORS
response.setHeader("Access-Control-Allow-Origin", "*");
