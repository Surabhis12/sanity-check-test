use std::collections::HashMap;
use std::error::Error;

#[derive(Debug, Clone)]
pub struct User {
    pub id: u32,
    pub name: String,
    pub email: String,
}

pub struct UserService {
    users: HashMap<u32, User>,
}

impl UserService {
    pub fn new() -> Self {
        Self {
            users: HashMap::new(),
        }
    }
    
    pub fn add_user(&mut self, user: User) -> Result<(), Box<dyn Error>> {
        if user.name.is_empty() {
            return Err("User name cannot be empty".into());
        }
        
        if user.email.is_empty() {
            return Err("User email cannot be empty".into());
        }
        
        self.users.insert(user.id, user);
        Ok(())
    }
    
    pub fn get_user(&self, id: u32) -> Option<&User> {
        self.users.get(&id)
    }
    
    pub fn remove_user(&mut self, id: u32) -> Option<User> {
        self.users.remove(&id)
    }
    
    pub fn list_users(&self) -> Vec<&User> {
        self.users.values().collect()
    }
}

impl Default for UserService {
    fn default() -> Self {
        Self::new()
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    
    #[test]
    fn test_add_user() {
        let mut service = UserService::new();
        let user = User {
            id: 1,
            name: String::from("John Doe"),
            email: String::from("john@example.com"),
        };
        
        assert!(service.add_user(user).is_ok());
    }
}