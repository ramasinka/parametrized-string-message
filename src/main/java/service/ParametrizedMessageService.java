package service;

public class ParametrizedMessageService {
    private String parametrizedMessage;

    public boolean isMessageParameterUsedInTheReplacedMessage(String parameterUser, String parameterName, String parameterPassword, String parametrizedMessage) {
        try {
            this.parametrizedMessage = parametrizedMessage;
            if (findParameterInTheMessage(parameterUser) >= 0 &&
                    findParameterInTheMessage(parameterName) >= 0 && findParameterInTheMessage(parameterPassword) >= 0) {
                return true;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("The specified index does not exist " +
                    "in array. Please correct the error.");
        }
        return false;
    }
//

    private int findParameterInTheMessage(String parameter) {
        return this.parametrizedMessage.indexOf(parameter);
    }
}
