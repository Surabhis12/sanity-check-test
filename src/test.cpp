#include <stdio.h>
#include <string.h>

int main() {
    // ERROR: Uninitialized pointer
    char* ptr;
    printf("%s", ptr);
    
    // ERROR: Unsafe gets()
    char buffer[10];
    gets(buffer);
    // ERROR: Unsafe strcpy
    char dest[10];
    char source[20] = "This is too long";
    strcpy(dest, source);
    
    return 0;
}