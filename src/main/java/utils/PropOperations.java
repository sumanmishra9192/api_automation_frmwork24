package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropOperations {

    public static String getEnvData(String key){

        String env = "qa";
        String filePath = "src/main/resources/"+env+".properties";


        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties properties = new Properties();
        try {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);


    }
}
