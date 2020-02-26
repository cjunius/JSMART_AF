package jsmart.utils;

import jsmart.core.Environments;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertiesReader {

    public static Properties forEnvironment(Environments environment) {
        Properties properties = new Properties();
        String filename = environment.toString() + ".properties";
        try (InputStream inputStream = PropertiesReader.class.getClassLoader().getResourceAsStream(filename)) {
            properties.load(inputStream);
        } catch (IOException ex) {
            Logger.getLogger("PropertiesReader")
                    .severe("Failed to read properties file for environment " + environment + ": " + ex.getMessage());
        } finally {
            return properties;
        }
    }

}
