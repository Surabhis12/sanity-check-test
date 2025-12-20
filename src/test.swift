// FIXED Swift File - src/UserManager.swift
import Foundation

struct User: Codable, Equatable {
    let id: Int
    let name: String
    let email: String
}

enum UserError: Error {
    case invalidData
    case userNotFound
    case networkError(String)
}

class UserManager {
    private var users: [Int: User] = [:]
    
    func addUser(_ user: User) throws {
        guard !user.name.isEmpty else {
            throw UserError.invalidData
        }
        
        guard !user.email.isEmpty else {
            throw UserError.invalidData
        }
        
        users[user.id] = user
    }
    
    func getUser(id: Int) throws -> User {
        guard let user = users[id] else {
            throw UserError.userNotFound
        }
        return user
    }
    
    func removeUser(id: Int) {
        users.removeValue(forKey: id)
    }
    
    func listUsers() -> [User] {
        return Array(users.values)
    }
    
    func safeCast<T>(_ value: Any?, to type: T.Type) -> T? {
        return value as? T
    }
    
    func processOptional(_ value: String?) -> String {
        // Safe optional handling - no force unwrapping
        if let unwrappedValue = value {
            return unwrappedValue
        }
        return "default"
    }
}

extension UserManager {
    func fetchUser(id: Int, completion: @escaping (Result<User, UserError>) -> Void) {
        DispatchQueue.global().async { [weak self] in
            guard let self = self else { return }
            
            do {
                let user = try self.getUser(id: id)
                DispatchQueue.main.async {
                    completion(.success(user))
                }
            } catch {
                DispatchQueue.main.async {
                    completion(.failure(.userNotFound))
                }
            }
        }
    }
}