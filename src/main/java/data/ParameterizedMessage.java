package data;

import org.apache.commons.lang3.text.StrLookup;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class ParameterizedMessage {
    private final String message;
    private Map<String, String> parametersMap = new HashMap<String, String>();
    private Logger log = LoggerFactory.getLogger(ParameterizedMessage.class);

    public ParameterizedMessage(String message) {
        this.message = message;
    }

    public ParameterizedMessage addParameter(String parameterName, String parameterValue) {
        parametersMap.put(parameterName, parameterValue);
        return this;
    }

    public String create() {
        StrSubstitutor sub = new StrSubstitutor(parametersMap);
        StrLookup<String> variableResolver = new StrLookup<String>() {
            @Override
            public String lookup(String key) {
                String keyValue = parametersMap.get(key);
                if (keyValue == null) {
                    throw new IllegalArgumentException("Your message:" + message + " don't have parameter value with name:" + key);
                }
                return keyValue;
            }
        };
        sub.setVariableResolver(variableResolver);
        String resolvedString = sub.replace(message);
        checkIfMessageUseAllParameters(parametersMap, message);
        return resolvedString;
    }

    private void checkIfMessageUseAllParameters(Map<String, String> parametersMap, String message) {
        for (Map.Entry<String, String> entry : parametersMap.entrySet()) {
            String parameterName = entry.getKey();
            String parameterValue = entry.getValue();
            if (findParameterInTheMessage(parameterName) < 0) {
                log.warn("In your message: " + message + " parameter with name: " + parameterName + " and value: " + parameterValue + " not used");
            }
        }
    }

    private int findParameterInTheMessage(String parameterName) {
        return message.indexOf(parameterName);
    }
}
