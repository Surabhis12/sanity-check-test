#include <iostream>
#include <cstring>
#include <cstdlib>

class Sensor {
public:
    void readData() {
        // Memory leak - malloc without free
        int* data = (int*)malloc(100 * sizeof(int));  // BAD!
        
        // Uninitialized variable
        int temperature;  // BAD!
        std::cout << "Temperature: " << temperature << std::endl;
        
        // Unsafe gets()
        char buffer[10];
        gets(buffer);  // DANGEROUS!
        
        // Buffer overflow with strcpy
        strcpy(buffer, "This string is way too long");  // BAD!
        
        // No free(data) - memory leak!
    }
    
    void processCommand(const char* cmd) {
        char command[50];
        strcpy(command, cmd);  // No bounds checking - BAD!
    }
};