import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;

public class UserService {
    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());
    
    private final List<String> users;
    
    public UserService() {
        this.users = new ArrayList<>();
    }
    
    public void addUser(String username) {
        if (username == null || username.isEmpty()) {
            LOGGER.warning("Attempted to add invalid user");
            return;
        }
        
        users.add(username);
        LOGGER.info("User added successfully: " + username);
    }
    
    public List<String> getUsers() {
        return new ArrayList<>(users);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserService other = (UserService) obj;
        return users.equals(other.users);
    }
    
    @Override
    public int hashCode() {
        return users.hashCode();
    }
}