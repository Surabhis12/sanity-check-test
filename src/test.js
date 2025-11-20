// Test file with intentional errors for sanity check

var oldVariable = "bad";  // ERROR: var usage
console.log("Debug output");  // ERROR: console.log

const apiKey = "sk-1234567890";  // ERROR: hardcoded secret

if (value == 5) {  // ERROR: loose equality
    eval("dangerous code");  // ERROR: eval usage
}

alert("Hello");  // ERROR: alert usage