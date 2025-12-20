class UserService {
    constructor(config) {
        this.config = config;
    }
    
    async fetchUserData(userId) {
        if (!userId) {
            throw new Error('User ID is required');
        }
        
        const response = await fetch(`/api/users/${userId}`);
        
        if (!response.ok) {
            throw new Error('Failed to fetch user data');
        }
        
        return response.json();
    }
    
    validateUser(user) {
        return user && user.id && user.email;
    }
}

module.exports = UserService;