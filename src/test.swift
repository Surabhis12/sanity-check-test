import Foundation

struct Calculator {
    func add(_ a: Int, _ b: Int) -> Int { a + b }
}

let calc = Calculator()
print(calc.add(5, 6))
