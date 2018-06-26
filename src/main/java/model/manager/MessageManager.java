package model.manager;

import java.util.ResourceBundle;

public class MessageManager {

    private final static ResourceBundle BUNDLE = ResourceBundle.getBundle("messages");

    public static String getMessage(String key) {
        return BUNDLE.getString(key);
    }
}
