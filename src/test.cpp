#include <stdio.h>

int main() {
    
    char* ptr;  // Uninitialized
    printf("%s", ptr);  // ERROR: uninitialized pointer
    char buffer[10];
    gets(buffer);  // ERROR: unsafe gets()
    return 0;

}