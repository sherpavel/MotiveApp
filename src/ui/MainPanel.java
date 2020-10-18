package ui;

import data.Settings;
import task.Task;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.util.ArrayList;

public class MainPanel extends JPanel {
    ArrayList<Task> tasks;
    ArrayList<Task> visualTasks;

    public MainPanel(ArrayList<Task> tasksArray) {

        Settings settings = Settings.getInstance();
        int width = Integer.parseInt(settings.getValue("windowWidth"));
        int height = Integer.parseInt(settings.getValue("windowHeight"));
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Window.mainColor);

        tasks = tasksArray;
        visualTasks = new ArrayList<>();

        this.setLayout(new GridLayout(0, 3));

        updateList();
    }

    private void updateList() {
        int i = 0;
        visualTasks.clear();
        this.removeAll();
        while (visualTasks.size() <= 5 && i < tasks.size()) {
            if (tasks.get(i).getCompleted()) {
                i++;
                continue;
            }
            visualTasks.add(tasks.get(i));
            String text = tasks.get(i).getName();

            JTextPane textPane = new JTextPane();
            textPane.setText(text);
            textPane.setEditable(false);
            textPane.setFont(new Font("Arial", Font.PLAIN, 18));
            StyledDocument doc = textPane.getStyledDocument();
            SimpleAttributeSet center = new SimpleAttributeSet();
            StyleConstants.setAlignment(center, StyleConstants.ALIGN_JUSTIFIED);
            doc.setParagraphAttributes(0, doc.getLength(), center, false);
            textPane.setBackground(Window.mainColor);
            textPane.setForeground(Window.notMainColor);
            this.add(textPane);

            JTextPane scorePane = new JTextPane();
            scorePane.setText(tasks.get(i).getPointValue() + " points");
            scorePane.setEditable(false);
            scorePane.setFont(new Font("Arial", Font.PLAIN, 18));
            doc = scorePane.getStyledDocument();
            center = new SimpleAttributeSet();
            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
            doc.setParagraphAttributes(0, doc.getLength(), center, false);
            scorePane.setBackground(Window.mainColor);
            scorePane.setForeground(Window.notMainColor);
            this.add(scorePane);

            JButton completeButton = Window.plainButton("Completed!");
            Window.toggleButton(completeButton);
            int finalI = i;
            completeButton.addActionListener(e -> {
                tasks.get(finalI).setCompleted(true);
                updateList();
            });
            this.add(completeButton);

            i++;
        }

        for (int e = visualTasks.size(); e < 6; e++) {
            this.add(new JLabel());
            this.add(new JLabel());
            this.add(new JLabel());
        }
    }
}
