#include <iostream>
#include <string>
#include <memory>

class UserService {
private:
    std::string username;
    
public:
    explicit UserService(const std::string& name) : username(name) {}
    
    void processData() {
        std::cout << "Processing data for user: " << username << std::endl;
    }
    
    ~UserService() {
        // Proper cleanup
    }
};

int main() {
    auto service = std::make_unique<UserService>("admin");
    service->processData();
    return 0;
}