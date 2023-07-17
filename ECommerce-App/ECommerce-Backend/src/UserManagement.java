import java.util.HashMap;
import java.util.UUID;

public class UserManagement {
    HashMap<String, User> userMap  = new HashMap<String, User>();
    HashMap<String, Session> sessionMap = new HashMap<String, Session>();
    public void signUp(String firstName, String lastName, String email, String password) {

        if (userMap.containsKey(email)) {
            System.err.println("The user already exists! Please register with another email Id");
            return;
        }
        User newUser = new User(firstName, lastName, email, password);
        userMap.put(email, newUser);
        System.out.println("User successfully registered");
    }

    /**
     * This method allows user to login based on credenatials.
     * Every successful login will generate a swssion ID which is valid for next 30 mins
     * @param email
     * @param pass
     * @return a unique session
     */
    public String signIn (String email, String pass) {
        if(userMap.containsKey(email)){
            if(pass != null && !pass.isEmpty()){
                User user = userMap.get(email);
                String storedPassword = user.getPassword();
                if(storedPassword.equalsIgnoreCase(pass)){
                    String sessionId = generateSessionId(email);
                    Session session = new Session(sessionId,email);
                    sessionMap.put(sessionId,session);
                    System.out.println("Sign in successful");
                    return  sessionId;
                }
            } else {
                System.err.println("Password cannot be empty");
                return null;
            }
        }
            System.err.println("User does not exist. Please register");
            return null;

    }

    public String generateSessionId(String email){
        String sessionId = UUID.randomUUID().toString();
        return  sessionId;
    }

    public boolean validateSession(String sessionId){
        Session session =  sessionMap.get(sessionId);
        if(session != null && session.isValidSession()){
            session.updateLastLoginTime();
            return  true;
        }
        System.err.println("The session is expired. Please login again");
        return  false;

    }
}
