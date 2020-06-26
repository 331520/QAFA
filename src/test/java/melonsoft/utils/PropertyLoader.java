package test.java.melonsoft.utils;

import java.util.ResourceBundle;

public class PropertyLoader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
    public static String loadProperty(String key){
        return resourceBundle.getString(key);
    }
}
