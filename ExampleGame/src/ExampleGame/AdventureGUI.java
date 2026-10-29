package ExampleGame;

import javax.swing.*;
import java.awt.*;

public class AdventureGUI extends JFrame {

    private final JTextArea story;
    private final JTextField input;
    private final JButton sendButton;

    public AdventureGUI() {
        setTitle("My Text Adventure");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Color background = new Color(16, 24, 32);
        Color panelColor = new Color(25, 38, 48);
        Color accent = new Color(117, 214, 160);
        Color textColor = new Color(224, 232, 237);

        JPanel main = new JPanel(new BorderLayout(10, 10));
        main.setBackground(background);
        main.setBorder(
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        JLabel title = new JLabel("MY TEXT ADVENTURE");
        title.setForeground(accent);
        title.setFont(new Font("Monospaced", Font.BOLD, 24));
        main.add(title, BorderLayout.NORTH);

        story = new JTextArea();
        story.setEditable(false);
        story.setLineWrap(true);
        story.setWrapStyleWord(true);
        story.setBackground(panelColor);
        story.setForeground(textColor);
        story.setFont(new Font("Monospaced", Font.PLAIN, 15));
        story.setMargin(new Insets(15, 15, 15, 15));

        main.add(new JScrollPane(story), BorderLayout.CENTER);

        input = new JTextField();
        input.setFont(new Font("Monospaced", Font.PLAIN, 15));
        input.setBackground(panelColor);
        input.setForeground(textColor);
        input.setCaretColor(accent);

        sendButton = new JButton("Send");
        sendButton.setBackground(accent);

        sendButton.addActionListener(e -> submitCommand());
        input.addActionListener(e -> submitCommand());

        JPanel inputPanel = new JPanel(new BorderLayout(8, 8));
        inputPanel.setBackground(background);
        inputPanel.add(input, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        JPanel actions = new JPanel(new FlowLayout(FlowLayout.LEFT));
        actions.setBackground(background);

        addActionButton(actions, "Go north", "go north");
        addActionButton(actions, "Go south", "go south");
        addActionButton(actions, "Look", "look");
        addActionButton(actions, "Inventory", "i");

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBackground(background);
        bottom.add(actions, BorderLayout.NORTH);
        bottom.add(inputPanel, BorderLayout.SOUTH);

        main.add(bottom, BorderLayout.SOUTH);
        setContentPane(main);

        // Connect game output to the story window.
        runExampleGame.setGuiOutput(this::appendStory);

        appendStory("Welcome to your adventure!");
        appendStory("Type commands below to play.");
        appendStory("Try: go north, take key, look, or i.");
        appendStory("");

        appendStory(
            "Your current room is: "
            + runExampleGame.getCurrentRoom()
        );
    }

    private void addActionButton(
            JPanel panel, String label, String command) {

        JButton button = new JButton(label);
        button.addActionListener(e -> handleCommand(command));
        panel.add(button);
    }

    private void submitCommand() {
        String command = input.getText().trim();

        if (command.isEmpty()) {
            return;
        }

        input.setText("");
        handleCommand(command);
    }

    private void handleCommand(String command) {
        boolean keepPlaying =
            runExampleGame.processCommand(command);

        if (!keepPlaying) {
            input.setEnabled(false);
            sendButton.setEnabled(false);
        }
    }

    private void appendStory(String message) {
        story.append(message + "\n");
        story.setCaretPosition(
            story.getDocument().getLength()
        );
    }
}
