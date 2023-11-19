package Utilities.CommonUtils;

import io.qameta.allure.internal.shadowed.jackson.databind.JsonNode;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LoadTestData {

    public static Map<String, Object> convertJsonToDictionary(JsonNode jsonNode) throws IOException {
        Map<String, Object> dictionary = new HashMap<>();
        // Iterate through the fields of the JSON object
        Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> entry = fields.next();
            String fieldName = entry.getKey();
            JsonNode fieldValue = entry.getValue();

            // Check if the field value is a nested object
            if (fieldValue.isObject()) {
                Map<String, Object> nestedDictionary = convertJsonToDictionary(fieldValue);
                dictionary.put(fieldName, nestedDictionary);
            } else {
                // Handle other types of fields
                if (fieldValue.isTextual()) {
                    dictionary.put(fieldName, fieldValue.asText());
                } else if (fieldValue.isNumber()) {
                    dictionary.put(fieldName, fieldValue.numberValue());
                } // Add more cases as needed
            }
        }

        return dictionary;
    }

    public static Map<String, Object> loadJsonFromFile(String loadPropertyFile) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        String filePath=System.getProperty("user.dir") + "/src/test/resources/" + loadPropertyFile;
        JsonNode jsonNode= objectMapper.readTree(new File(filePath));
        return convertJsonToDictionary(jsonNode);

    }
}
