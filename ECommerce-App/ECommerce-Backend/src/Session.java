public class Session {
    private String sessionId;
    private  String emailId;
    private long lastLoginTime ;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Session(String sessionId, String emailId) {
        this.sessionId = sessionId;
        this.emailId = emailId;
        updateLastLoginTime();
    }

    public void updateLastLoginTime() {
        this.lastLoginTime = System.currentTimeMillis();
    }

    //Method to check if session is valid i.e within 30 mins
    public boolean isValidSession(){
        long currentTime = System.currentTimeMillis();
        long sessionTime = currentTime - lastLoginTime;

        if(sessionTime < 30*60*1000 ){
            return true;
        }
        return false;
    }
}
