package data;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ParameterizedMessageTest {

    @Test
    public void parametrizedStringReplace() {
        Map paramsMap = new HashMap();
        paramsMap.put("user", "jonas");
        paramsMap.put("username", "john");
        paramsMap.put("password", "abs123");
        ParameterizedMessage parameterizedMessage = new ParameterizedMessage(paramsMap);
        String message = "Hello ${user}, your username is ${username} and password ${password}";
        String replacedParametrizedMessage = "Hello jonas, your username is john and password abs123";
        assertEquals(replacedParametrizedMessage, parameterizedMessage.replaceParametrizedMessage(message, paramsMap));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotReplaceParametrizedMessageWithoutParameter() {
        String message = "Hello ${user}, your username is ${username} and password ${password}";
        Map paramsMap = new HashMap();
        paramsMap.put("user", "jonas");
        paramsMap.put("username", "john");
        paramsMap.put("password", "abs123");
        paramsMap.put("email", "abs123@gmail.com");
        ParameterizedMessage parameterizedMessage = new ParameterizedMessage(paramsMap);
        parameterizedMessage.replaceParametrizedMessage(message, paramsMap);
    }
}
