package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String data, String dataType) throws Exception {
        ObjectMapper objectMapper;
        if (dataType.equalsIgnoreCase("json")) {
            objectMapper = new ObjectMapper();
        } else {
            objectMapper = new ObjectMapper(new YAMLFactory());
        }
        return objectMapper.readValue(data, new TypeReference<>() { });
    }
}
