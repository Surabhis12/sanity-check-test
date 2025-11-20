#include <stdio.h>
#include <stdlib.h>

int main() {
    char* buffer = (char*)malloc(100);  // ERROR: malloc without free
    
    gets(buffer);  // ERROR: unsafe gets()
    
    strcpy(buffer, "test");  // ERROR: strcpy without bounds
    
    return 0;
}