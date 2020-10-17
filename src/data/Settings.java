package data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Settings {
    String filename;
    BufferedReader fileReader;
    HashMap<String, String> settings;

    public Settings(String filename) throws FileNotFoundException {
        if (this.filename.equals(filename))
            return;
        this.filename = filename;
        fileReader = new BufferedReader(new FileReader(filename));
        String line;
        try {
            while ((line = fileReader.readLine()) != null) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
