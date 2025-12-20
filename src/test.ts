interface User {
    id: number;
    name: string;
    email: string;
}

interface Config {
    apiUrl: string;
    timeout: number;
}

class AuthService {
    private config: Config;
    
    constructor(config: Config) {
        this.config = config;
    }
    
    async authenticateUser(credentials: { email: string; password: string }): Promise<User> {
        const response = await fetch(`${this.config.apiUrl}/auth`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(credentials),
        });
        
        if (!response.ok) {
            throw new Error('Authentication failed');
        }
        
        return response.json();
    }
    
    validateToken(token: string): boolean {
        return token.length > 0;
    }
}

export default AuthService;