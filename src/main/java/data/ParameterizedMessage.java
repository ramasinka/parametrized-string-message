package data;

import org.apache.commons.lang3.text.StrLookup;
import org.apache.commons.lang3.text.StrSubstitutor;

import java.util.HashMap;
import java.util.Map;

public class ParameterizedMessage {
    private String parameterName;
    private String parameterValue;
    private final String message;
    private Map<String, String> parametersMap = new HashMap<String, String>();

    public ParameterizedMessage(String message) {
        this.message = message;
    }

    public ParameterizedMessage addParameter(String name, String value) {
        this.parameterValue = value;
        this.parameterName = name;
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
                    throw new IllegalArgumentException("Your message don't have parameter with name:" + keyValue);
                }
                return keyValue;
            }
        };
        sub.setVariableResolver(variableResolver);
        String resolvedString = sub.replace(message);
        return resolvedString;
    }
}
