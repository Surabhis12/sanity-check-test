// Bad JS code for sanity testing

function test() {
  name = "Surabhi";              // ❌ implicit global variable
  console.log("Test started");   // ❌ console.log usage
  eval("console.log('eval')");   // ❌ eval usage (security risk)
}


test();
