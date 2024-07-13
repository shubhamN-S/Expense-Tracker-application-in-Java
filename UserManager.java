import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, String> users; // username -> password

    public UserManager() {
        this.users = new HashMap<>();
    }

    public boolean registerUser(String username, String password) {
        if (users.containsKey(username)) {
            return false; // Username already exists
        }
        users.put(username, password);
        return true;
    }

    public boolean login(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return true; // Login successful
        }
        return false; // Invalid username or password
    }
}
