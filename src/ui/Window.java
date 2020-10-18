package ui;

import data.Settings;
import task.Task;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Window {
    static JFrame frame;
    static Color mainColor = new Color(40, 40, 40);
    static Color notMainColor = new Color(240, 240, 240);
    static JButton currentTab;

    public static void startWindow(ArrayList<Task> tasks) {
        Settings settings = Settings.getInstance();
        int width = Integer.parseInt(settings.getValue("windowWidth"));
        int height = Integer.parseInt(settings.getValue("windowHeight"));
        frame = new JFrame("MotiveApp");
//        frame.setPreferredSize(new Dimension(width, height));
        frame.setResizable(false);
        frame.setUndecorated(true);

        MouseAdapter mouseAdapter = new MouseAdapter() {
            int prevX, prevY;

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                prevX = e.getXOnScreen();
                prevY = e.getYOnScreen();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                frame.setLocation(
                        frame.getLocationOnScreen().x - prevX + e.getXOnScreen(),
                        frame.getLocationOnScreen().y - prevY + e.getYOnScreen());
                prevX = e.getXOnScreen();
                prevY = e.getYOnScreen();
            }
        };

        JButton tasksButton = plainButton("Tasks");
        tasksButton.addMouseListener(mouseAdapter);
        tasksButton.addMouseMotionListener(mouseAdapter);
        JButton completedButton = plainButton("Completed");
        completedButton.addMouseListener(mouseAdapter);
        completedButton.addMouseMotionListener(mouseAdapter);
        JButton exitButton = plainButton("Exit");
        exitButton.addActionListener(e -> {
            frame.setVisible(false);
            // TODO save completed tasks
            System.exit(0);
        });

        currentTab = tasksButton;
        toggleButton(currentTab);
//        toggleButton(exitButton);

        JPanel navPanel = new JPanel();
        navPanel.setLayout(new GridLayout(1, 3));
        navPanel.add(tasksButton);
        navPanel.add(completedButton);
        navPanel.add(exitButton);

        MainPanel mainPanel = new MainPanel(tasks);

        Container contentPanel = frame.getContentPane();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(navPanel, BorderLayout.NORTH);
        contentPanel.add(mainPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    static JButton plainButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(mainColor);
        button.setBackground(notMainColor);
        Border line = new LineBorder(Color.WHITE);
        Border margin = new EmptyBorder(10, 15, 10, 15);
        Border compound = new CompoundBorder(line, margin);
        button.setBorder(compound);
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        return button;
    }

    static void toggleButton(JButton button) {
        if (button.isEnabled()) {
            button.setForeground(notMainColor);
            button.setBackground(mainColor);
        } else {
            button.setForeground(mainColor);
            button.setBackground(notMainColor);
        }
    }
}
