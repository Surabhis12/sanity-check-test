import 'dart:async';

class User {
  final int id;
  final String name;
  final String email;
  
  const User({
    required this.id,
    required this.name,
    required this.email,
  });
  
  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'name': name,
      'email': email,
    };
  }
  
  factory User.fromJson(Map<String, dynamic> json) {
    return User(
      id: json['id'] as int,
      name: json['name'] as String,
      email: json['email'] as String,
    );
  }
  
  @override
  bool operator ==(Object other) {
    if (identical(this, other)) return true;
    return other is User &&
        other.id == id &&
        other.name == name &&
        other.email == email;
  }
  
  @override
  int hashCode => id.hashCode ^ name.hashCode ^ email.hashCode;
}

class UserRepository {
  final Map<int, User> _cache = {};
  
  Future<void> saveUser(User user) async {
    if (user.name.isEmpty) {
      throw ArgumentError('User name cannot be empty');
    }
    
    if (user.email.isEmpty) {
      throw ArgumentError('User email cannot be empty');
    }
    
    await Future.delayed(const Duration(milliseconds: 100));
    _cache[user.id] = user;
  }
  
  Future<User?> getUser(int id) async {
    await Future.delayed(const Duration(milliseconds: 50));
    return _cache[id];
  }
  
  Future<List<User>> getAllUsers() async {
    await Future.delayed(const Duration(milliseconds: 50));
    return _cache.values.toList();
  }
  
  void clearCache() {
    _cache.clear();
  }
  
  T? safeCast<T>(dynamic value) {
    if (value is T) {
      return value;
    }
    return null;
  }
}