package data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParameterizedMessageTest {

    @Test
    public void parametrizedStringReplace() {
        String message = "Hello ${user}, your username is ${username} and password ${password}";
        String parameterizedMessage = new ParameterizedMessage(message).addParameter("user", "jonas").addParameter("username", "john").addParameter("password", "abs123").create();
        String replacedParametrizedMessage = "Hello jonas, your username is john and password abs123";
        assertEquals(replacedParametrizedMessage, parameterizedMessage);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotReplaceParametrizedMessageWithoutParameter() {
        String message = "Hello ${user}, your username is ${username} and password ${password}";
        String parameterizedMessage = new ParameterizedMessage(message).addParameter("user", "jonas").addParameter("username", "john").addParameter("password", "abs123")
                .addParameter("email", "abs123@gmail.com").create();
    }

    @Test
    public void shouldReplaceParameterizedMessageWithTwoSameParameters() {
        String message = "Hello ${user}, your username is ${username} and password is ${password}. You can change your username ${username} if you want.";
        String parameterizedMessage = new ParameterizedMessage(message).addParameter("user", "jonas").addParameter("username", "john").addParameter("password", "abs123").create();
        String replacedParametrizedMessage = "Hello jonas, your username is john and password is abs123. You can change your username john if you want.";
        assertEquals(replacedParametrizedMessage, parameterizedMessage);
    }
}
