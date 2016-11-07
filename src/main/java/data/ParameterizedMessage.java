package data;


import org.apache.commons.lang3.text.StrSubstitutor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ParameterizedMessage {

    public String replaceParametrizedMessage(String message, Map<String, String> parametersMap) {
        StrSubstitutor sub = new StrSubstitutor(parametersMap);
        checkIfMessageHaveAllParameters(parametersMap, message);
        String resolvedString = sub.replace(message);
        return resolvedString;
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
}
