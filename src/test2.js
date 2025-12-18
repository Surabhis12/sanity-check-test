/**
 * Simple utility to greet a user
 */

function greetUser(name) {
  if (typeof name !== "string" || name.trim() === "") {
    throw new Error("Invalid name provided");
  }
  return `Hello, ${name}!`;
}

try {
  const message = greetUser("Surabhi");
  console.info(message);
} catch (error) {
  console.error("Error occurred:", error.message);
}
