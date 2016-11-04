package dto;

import exception.ParameterizedMessageParameterNotFoundException;

public class ParameterizedMessageBuilder {

    private String user;
    private String userName;
    private String userPassword;

    public ParameterizedMessageBuilder userCalled(String user) {
        this.user = user;
        return this;
    }

    public ParameterizedMessageBuilder withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public ParameterizedMessageBuilder withUserPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }

    public ParameterizedMessage build() throws ParameterizedMessageParameterNotFoundException {
        ParameterizedMessage parameterizedMessage = new ParameterizedMessage();
        if (user != null) {
            parameterizedMessage.setUser(user);
        } else {
            throw new ParameterizedMessageParameterNotFoundException("You can't build ParametrizedMessage without user value");
        }
        if (userName != null) {
            parameterizedMessage.setUserName(userName);
        } else {
            throw new ParameterizedMessageParameterNotFoundException("You can't build ParametrizedMessage without username value");
        }
        if (userPassword != null) {
            parameterizedMessage.setUserPassword(userPassword);
        } else {
            throw new ParameterizedMessageParameterNotFoundException("You can't build ParametrizedMessage without userpassword value");
        }
        return parameterizedMessage;
    }
}
