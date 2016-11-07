package data;


import org.apache.commons.lang3.text.StrSubstitutor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ParameterizedMessage {

    Map<String, String> parametersMap = new HashMap<String, String>();

    public ParameterizedMessage(Map<String, String> parametersMap) {
        this.parametersMap = parametersMap;
    }

    public String replaceParametrizedMessage(String message, Map<String, String> parametersMap) {
        String resolvedString = null;
        this.parametersMap = parametersMap;
        StrSubstitutor sub = new StrSubstitutor(parametersMap);
        if (checkIfMessageHaveAllParameters(parametersMap, message)) {
            resolvedString = sub.replace(message);
        }
        return resolvedString;
    }

    public boolean checkIfMessageHaveAllParameters(Map<String, String> parametersMap, String message) {
        this.parametersMap = parametersMap;
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
        return true;
    }

    private int findParameterInTheMessage(String parameter, String message) {
        return message.indexOf(parameter);
    }
}
