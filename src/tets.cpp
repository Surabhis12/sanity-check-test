#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Missing include guard is **NOT** needed because this is .cpp (your script checks only .h/.hpp)

int unusedFunction(int x) {     // Unused function
    int y;                      // uninitialized variable (cppcheck)
    return y + x;               // undefined behavior
}

// Function missing return statement
int noReturn(int x) { 
    int t = x * 2;              // unused variable
}                               // Missing return → cppcheck error

int buffer_overflow() {
    char buf[5];
    strcpy(buf, "HELLO123");    // strcpy → warning & overflow
    return buf[0];
}

void null_deref() {
    int *p = NULL;
    int x = *p;                 // null pointer dereference
    printf("%d\n", x);
}

void array_oob() {
    int a[3] = {1,2,3};
    a[10] = 99;                 // out-of-bounds write
}

void memory_leak() {
    int *ptr = (int*)malloc(sizeof(int) * 10);  // malloc
    ptr[0] = 10;
    // No free(ptr) → memory leak warning from script
}

void insecure_gets() {
    char input[10];
    gets(input);                // gets() is unsafe → ERROR
}

int type_mismatch() {
    char *str = (char*)12345;   // invalid pointer cast
    return (int)str;            // suspicious conversion
}
int main() {
    int uninitialized;          // uninitialized variable
    int result = uninitialized + 5;

    printf("Result: %d\n", result);

    malloc(50);                 // malloc but not freed

    buffer_overflow();
    null_deref();
    array_oob();
    insecure_gets();
    memory_leak();

    return 0;
}
