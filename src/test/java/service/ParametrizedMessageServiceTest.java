package service;

import data.ParameterizedMessage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ParametrizedMessageServiceTest {
    private ParameterizedMessage parameterizedMessage;
    private ParametrizedMessageService parametrizedMessageService;

    @Before
    public void setUp() throws Exception {
        parameterizedMessage = new ParameterizedMessage("jonas", "john", "abs123");
        parametrizedMessageService = new ParametrizedMessageService();
    }

    @Test
    public void checkIfMessageParameterUsedInTheReplacedMessage() {
        String replacedParametrizedMessage = "Hello jonas, your username is john and password abs123";
        assertEquals(true, parametrizedMessageService.isMessageParameterUsedInTheReplacedMessage("jonas", "john", "abs123", replacedParametrizedMessage));
    }

    @Test
    public void checkIfMessageParameterNotUsedInTheReplacedMessage() {
        String replacedParametrizedMessage = "Hello, your username is john and password abs123";
        assertEquals(false, parametrizedMessageService.isMessageParameterUsedInTheReplacedMessage("jonas", "john", "abs123", replacedParametrizedMessage));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotReplaceParametrizedMessageWithoutParameter() {
        String parametrizedMessage = "Hello ${user}, your password is ${password}";
        String replacedParametrizedMessage = "Hello, your username is john and password abs123";
        parameterizedMessage.replaceParametrizedMessage(parametrizedMessage);
        assertEquals(false, parametrizedMessageService.isMessageParameterUsedInTheReplacedMessage("jonas", "john", "abs123", replacedParametrizedMessage));
    }

}