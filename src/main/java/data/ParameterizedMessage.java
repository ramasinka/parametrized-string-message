package data;


import org.apache.commons.lang3.text.StrSubstitutor;

import java.util.HashMap;
import java.util.Iterator;
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

    private void checkIfMessageHaveAllParameters(Map<String, String> parametersMap, String message) {
        Iterator entries = parametersMap.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            String key = (String) entry.getKey();
            if (findParameterInTheMessage(key, message) >= 0) {
                continue;
            } else {
                throw new IllegalArgumentException("Your message don't have parameter with name:" + key);
            }
        }
    }

    private int findParameterInTheMessage(String parameter, String message) {
        return message.indexOf(parameter);
    }

    public String create() {
        StrSubstitutor sub = new StrSubstitutor(parametersMap);
        checkIfMessageHaveAllParameters(parametersMap, message);
        String resolvedString = sub.replace(message);
        return resolvedString;
    }
}
