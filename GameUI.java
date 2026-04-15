import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameUI extends JFrame {
    private int targetNumber;
    private int currentSum = 0;
    private JButton[] bitTiles = new JButton[8];
    private JLabel targetLabel, sumLabel, statusLabel;
    private BinaryEngine engine = new BinaryEngine();

    public GameUI() {
        setTitle("Binary Master v1.0");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(20, 20));
        getContentPane().setBackground(new Color(30, 30, 30)); // Dark Mode

        // --- TOP PANEL: The Goal ---
        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.setOpaque(false);
        
        targetNumber = new Random().nextInt(256);
        targetLabel = new JLabel("TARGET: " + targetNumber, SwingConstants.CENTER);
        targetLabel.setFont(new Font("Verdana", Font.BOLD, 40));
        targetLabel.setForeground(new Color(0, 255, 150)); // Neon Green
        
        sumLabel = new JLabel("CURRENT SUM: 0", SwingConstants.CENTER);
        sumLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
        sumLabel.setForeground(Color.WHITE);
        
        topPanel.add(targetLabel);
        topPanel.add(sumLabel);
        add(topPanel, BorderLayout.NORTH);

        // --- CENTER PANEL: The Bit Tiles ---
        JPanel centerPanel = new JPanel(new GridLayout(1, 8, 10, 10));
        centerPanel.setOpaque(false);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        for (int i = 0; i < 8; i++) {
            int weight = (int) Math.pow(2, 7 - i);
            
            // Container for each tile to show the weight above the button
            JPanel tileContainer = new JPanel(new BorderLayout(5, 5));
            tileContainer.setOpaque(false);
            
            JLabel weightLabel = new JLabel(String.valueOf(weight), SwingConstants.CENTER);
            weightLabel.setForeground(Color.GRAY);
            
            JButton btn = new JButton("0");
            btn.setFont(new Font("Arial", Font.BOLD, 30));
            btn.setFocusPainted(false);
            btn.setBackground(new Color(60, 60, 60));
            btn.setForeground(Color.WHITE);
            btn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

            btn.addActionListener(e -> {
                if (btn.getText().equals("0")) {
                    btn.setText("1");
                    btn.setBackground(new Color(0, 120, 215)); // Blue for Active
                } else {
                    btn.setText("0");
                    btn.setBackground(new Color(60, 60, 60));
                }
                updateGame();
            });

            bitTiles[i] = btn;
            tileContainer.add(weightLabel, BorderLayout.NORTH);
            tileContainer.add(btn, BorderLayout.CENTER);
            centerPanel.add(tileContainer);
        }
        add(centerPanel, BorderLayout.CENTER);

        // --- BOTTOM PANEL: Status ---
        statusLabel = new JLabel("Match the bits to reach the target number!", SwingConstants.CENTER);
        statusLabel.setForeground(Color.LIGHT_GRAY);
        add(statusLabel, BorderLayout.SOUTH);
    }

    private void updateGame() {
        int[] bits = new int[8];
        for (int i = 0; i < 8; i++) {
            bits[i] = bitTiles[i].getText().equals("1") ? 1 : 0;
        }

        currentSum = engine.calculateSum(bits);
        sumLabel.setText("CURRENT SUM: " + currentSum);

        if (currentSum == targetNumber) {
            targetLabel.setText("MATCHED!");
            JOptionPane.showMessageDialog(this, "Success! " + targetNumber + " in binary is exactly what you entered.");
            resetGame();
        } else if (currentSum > targetNumber) {
            sumLabel.setForeground(Color.RED);
            statusLabel.setText("Oops! You exceeded the target.");
        } else {
            sumLabel.setForeground(Color.WHITE);
            statusLabel.setText("Keep going...");
        }
    }

    private void resetGame() {
        targetNumber = new Random().nextInt(256);
        targetLabel.setText("TARGET: " + targetNumber);
        targetLabel.setForeground(new Color(0, 255, 150));
        for (JButton btn : bitTiles) {
            btn.setText("0");
            btn.setBackground(new Color(60, 60, 60));
        }
        updateGame();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameUI().setVisible(true));
    }
}