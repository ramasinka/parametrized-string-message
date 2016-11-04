package dto;

public class ParameterizedMessage {

    private String user;
    private String userName;
    private String userPassword;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "Hello " + user + ", your username is " + userName + " and password " + userPassword;
    }
}
