"use strict";

/**
 * Safely prints a greeting message
 */
function greetUser(name) {
  if (typeof name !== "string" || name.trim() === "") {
    throw new Error("Invalid name");
  }

  return `Hello, ${name}`;
}

try {
  const message = greetUser("Surabhi");
  console.info(message);
} catch (error) {
  console.error("Application error:", error.message);
}
