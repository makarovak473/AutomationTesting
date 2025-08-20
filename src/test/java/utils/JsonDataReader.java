package utils;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {
    public static <T> T readJson(String filePath, Class<T> clazz) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, clazz);
        } catch (IOException e) {
            throw new RuntimeException("Nu s-a putut citi fișierul: " + filePath, e);
        }
    }
}
