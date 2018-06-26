package model.manager;

import java.util.ResourceBundle;

public class PropertyManager {
    private ResourceBundle resourceBundle;

    private PropertyManager() {
    }

    public PropertyManager(String filename) {
        resourceBundle = ResourceBundle.getBundle(filename);
    }

    public String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}