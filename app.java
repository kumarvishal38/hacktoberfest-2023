import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessTheNumberGame {
    private int targetNumber;
    private int attempts;

    public GuessTheNumberGame() {
        targetNumber = (int) (Math.random() * 100) + 1;
        attempts = 0;

        JFrame frame = new JFrame("Guess the Number Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        frame.add(panel);

        JLabel instructionsLabel = new JLabel("Guess a number between 1 and 100:");
        panel.add(instructionsLabel);

        JTextField guessField = new JTextField(10);
        panel.add(guessField);

        JButton guessButton = new JButton("Guess");
        panel.add(guessButton);

        JLabel resultLabel = new JLabel("");
        panel.add(resultLabel);

        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int userGuess = Integer.parseInt(guessField.getText());
                    attempts++;

                    if (userGuess == targetNumber) {
                        resultLabel.setText("Congratulations! You guessed the number in " + attempts + " attempts.");
                        guessButton.setEnabled(false);
                    } else if (userGuess < targetNumber) {
                        resultLabel.setText("Try a higher number.");
                    } else {
                        resultLabel.setText("Try a lower number.");
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input. Enter a number.");
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GuessTheNumberGame());
    }
}
