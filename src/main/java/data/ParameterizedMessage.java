package data;

public class ParameterizedMessage {

    private String user;
    private String name;
    private String password;

    public ParameterizedMessage(String user, String name, String password) {
        this.user = user;
        this.name = name;
        this.password = password;

    }

    public String replaceParametrizedMessage(String parametrizedMessage) {
        parametrizedMessage = parametrizedMessage.replace("${user}", user).replace("${username}", name).replace("${password}", password);
        return parametrizedMessage;
    }
}
