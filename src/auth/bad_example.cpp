#include <stdio.h>
#include <string.h>

int main() {
    char buffer[10];
    char* input = gets(buffer);      // ERROR: unsafe gets()
    
    strcpy(buffer, "This is way too long");  // ERROR: buffer overflow
    
    int x;                           // ERROR: uninitialized
    printf("%d", x);                 // ERROR: using uninitialized
    
    char* ptr = (char*)malloc(100);  // ERROR: no free()
    
    return 0;
}