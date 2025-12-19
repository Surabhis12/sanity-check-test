// This file has INTENTIONAL errors to test detection

console.log("This will be detected");  // ERROR: console.log

var x = 5;  // ERROR: var keyword

if (x == 5) {  // ERROR: loose equality
  alert("test");  // ERROR: alert
}


eval("some code");  // ERROR: eval usage


const apiKey = "hardcoded-key-12345";  // ERROR: hardcoded secret