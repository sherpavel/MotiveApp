package ui;

import javax.swing.*;
import java.awt.*;

public class Window {
    static JFrame frame;

    public static void startWindow(int width, int height) {
        frame = new JFrame("MotiveApp");
        frame.setPreferredSize(new Dimension(width, height));

    }
}
