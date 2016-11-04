
import dto.ParameterizedMessage;
import dto.ParameterizedMessageBuilder;
import exception.ParameterizedMessageParameterNotFoundException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParameterizedMessageTest {

    @Test
    public void parametrizedStringReplace() throws ParameterizedMessageParameterNotFoundException {
        ParameterizedMessage parameterizedMessage = new ParameterizedMessageBuilder().userCalled("Jonas").withUserName("john").withUserPassword("abc123").build();
        String parametrizedReplacedMessage = "Hello Jonas, your username is john and password abc123";
        assertEquals(parametrizedReplacedMessage, parameterizedMessage.toString());
    }

    @Test(expected = ParameterizedMessageParameterNotFoundException.class)
    public void checkIfParametrizedMessageUserNotEmpty() throws ParameterizedMessageParameterNotFoundException {
        ParameterizedMessage parameterizedMessage = new ParameterizedMessageBuilder().withUserName("john").withUserPassword("abc123").build();
    }

    @Test(expected = ParameterizedMessageParameterNotFoundException.class)
    public void checkIfParametrizedMessageUserNameNotEmpty() throws ParameterizedMessageParameterNotFoundException {
        ParameterizedMessage parameterizedMessage = new ParameterizedMessageBuilder().userCalled("Jonas").withUserPassword("abc123").build();
    }

    @Test(expected = ParameterizedMessageParameterNotFoundException.class)
    public void checkIfParametrizedMessageUserPasswordNotEmpty() throws ParameterizedMessageParameterNotFoundException {
        ParameterizedMessage parameterizedMessage = new ParameterizedMessageBuilder().userCalled("Jonas").withUserName("john").build();
    }
}
