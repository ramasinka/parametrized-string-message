package data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParameterizedMessageTest {

    @Test
    public void parametrizedStringReplace() {
        ParameterizedMessage parameterizedMessage = new ParameterizedMessage();
        parameterizedMessage.addParameters("user", "jonas");
        parameterizedMessage.addParameters("username", "john");
        parameterizedMessage.addParameters("password", "abs123");
        String message = "Hello ${user}, your username is ${username} and password ${password}";
        String replacedParametrizedMessage = "Hello jonas, your username is john and password abs123";
        assertEquals(replacedParametrizedMessage, parameterizedMessage.replaceParametrizedMessage(message));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotReplaceParametrizedMessageWithoutParameter() {
        String message = "Hello ${user}, your username is ${username} and password ${password}";
        ParameterizedMessage parameterizedMessage = new ParameterizedMessage();
        parameterizedMessage.addParameters("user", "jonas");
        parameterizedMessage.addParameters("username", "john");
        parameterizedMessage.addParameters("password", "abs123");
        parameterizedMessage.addParameters("email", "abs123@gmail.com");
        parameterizedMessage.replaceParametrizedMessage(message);
    }
}
