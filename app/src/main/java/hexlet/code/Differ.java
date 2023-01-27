package hexlet.code;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String content1 = readFile(filepath1);
        String content2 = readFile(filepath2);

        String dataType1 = getDataType(filepath1);
        String dataType2 = getDataType(filepath2);

        Map<String, Object> data1 = Parser.parse(content1, dataType1);
        Map<String, Object> data2 = Parser.parse(content2, dataType2);

        List<Map<String, Object>> result = DifferenceFinder.getDifference(data1, data2);

        return ..;
    }

    public static String readFile(String somePath) throws Exception {
        File file = new File(somePath);
        String absolutePath = file.getAbsolutePath();
        String content = Files.readString(Path.of(absolutePath));
        return content;
    }

    public static String getDataType(String filepath) {
        return filepath.substring(filepath.indexOf(".") + 1);
    }

}
