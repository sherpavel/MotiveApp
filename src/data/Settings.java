package data;

import java.io.*;
import java.util.HashMap;

public class Settings {
    static Settings settingsObject;
    static String filename;
    static BufferedReader fileReader;
    static HashMap<String, String> settingsMap;

    public static Settings getInstance() {
        if (settingsObject == null) {
            settingsObject = new Settings();
        }
        return settingsObject;
    }

    private Settings() {
        settingsMap = new HashMap<>();
        filename = "src" + File.separator + "data" + File.separator + "settings.dat";
        try {
            fileReader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = fileReader.readLine()) != null) {
                String[] map = line.split(":");
                String key = map[0];
                String value = map[1];
                settingsMap.put(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        if (!settingsMap.containsKey(key))
            throw new IllegalArgumentException("No such setting found");
        return settingsMap.get(key);
    }

    public void setValue(String key, String value) {
        if (!settingsMap.containsKey(key))
            throw new IllegalArgumentException("No such setting found");
        settingsMap.replace(key, value);
    }

    public void saveSettings() {

    }
}
