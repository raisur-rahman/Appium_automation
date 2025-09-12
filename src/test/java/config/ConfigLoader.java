package config;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Paths;

public class ConfigLoader {

    public static CapabilitiesConfig load(String envPathOrSysProp) {
        try {
            String path = System.getProperty("env", envPathOrSysProp);
            if (path == null || path.trim().isEmpty()) {
                throw new IllegalArgumentException("Missing -Denv=<path to json> and no default provided.");
            }
            File file = Paths.get(path).toFile();
            if (!file.exists()) {
                throw new IllegalArgumentException("Env JSON not found: " + file.getAbsolutePath());
            }
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(file, CapabilitiesConfig.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load capabilities config JSON: " + e.getMessage(), e);
        }
    }
}
