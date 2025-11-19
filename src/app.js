// API module - WITH ISSUES

var axios = require('axios');  // var - BAD!
var API_KEY = "pk_live_1234567890";  // Hard-coded API key - BAD!

function fetchUserData(userId) {
    console.log("Fetching user: " + userId);  // console.log - BAD!
    
    if (userId == 123) {  // Loose equality - BAD!
        console.log("Special user");  // console.log - BAD!
    }
}


debugger;  // debugger - BAD!

module.exports = { fetchUserData };