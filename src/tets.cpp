#include <iostream>
#include <vector>

int add(int a, int b) {
    return a + b;
}

int main() {
    std::vector<int> nums = {1, 2, 3};
    std::cout << add(nums[0], nums[1]) << std::endl;
    return 0;
}
