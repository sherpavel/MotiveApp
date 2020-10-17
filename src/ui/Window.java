package ui;

import data.Settings;

import javax.swing.*;
import java.awt.*;

public class Window {
    static JFrame frame;

    public static void startWindow() {
        Settings settings = Settings.getInstance();
        int width = Integer.parseInt(settings.getValue("windowWidth"));
        int height = Integer.parseInt(settings.getValue("windowHeight"));

        frame = new JFrame("MotiveApp");
        frame.setSize(width, height);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setVisible(true);
    }
}
