import 'package:flutter/foundation.dart';

class Calculator {
  int add(int a, int b) => a + b;
}

void main() {
  final calc = Calculator();
  final result = calc.add(10, 20);
  debugPrint('Result: $result'); // Allowed
}
