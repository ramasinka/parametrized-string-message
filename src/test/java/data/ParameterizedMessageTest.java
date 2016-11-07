package data;

import org.junit.Before;
import org.junit.Test;
import service.ParametrizedMessageService;

import static org.junit.Assert.assertEquals;

public class ParameterizedMessageTest {
    private ParameterizedMessage parameterizedMessage;
    private ParametrizedMessageService parametrizedMessageService;

    @Before
    public void setUp() throws Exception {
        parameterizedMessage = new ParameterizedMessage("jonas", "john", "abs123");
        parametrizedMessageService = new ParametrizedMessageService();
    }

    @Test
    public void parametrizedStringReplace() {
        String parametrizedMessage = "Hello ${user}, your username is ${username} and password ${password}";
        String replacedParametrizedMessage = "Hello jonas, your username is john and password abs123";
        assertEquals(replacedParametrizedMessage, parameterizedMessage.replaceParametrizedMessage(parametrizedMessage));
    }
}
