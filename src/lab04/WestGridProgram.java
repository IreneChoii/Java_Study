package lab04;

import javax.swing.*;
import java.awt.*;

// lab04_02
public class WestGridProgram extends JFrame {
    private static final Color[] COLORS = {
            Color.WHITE, // White
            new Color(255, 87, 51),  // Red
            new Color(255, 189, 51), // Orange
            new Color(252, 245, 95), // Yellow
            new Color(92, 201, 144), // Green
            new Color(165, 211, 250), // Skyblue
            new Color(56, 132, 200), // Blue
            new Color(255, 192, 203), // Pink
            new Color(155, 90, 224), // Purple
            Color.GRAY // Gray
    };

    public WestGridProgram() {
        setTitle("West Grid 프레임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // WEST 영역 설정
        JPanel westPanel = new JPanel(new GridLayout(10, 1, 2, 2));
        westPanel.setBackground(Color.WHITE);
        westPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton() {
                @Override
                protected void paintComponent(Graphics g) {
                    if (getModel().isPressed()) {
                        g.setColor(getBackground().darker());
                    } else {
                        g.setColor(getBackground());
                    }
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            };
            btn.setBackground(COLORS[i]);
            btn.setOpaque(true);
            btn.setBorderPainted(false);
            btn.setFocusPainted(false);
            btn.setPreferredSize(new Dimension(50, 30));
            westPanel.add(btn);
        }
        add(westPanel, BorderLayout.WEST);

        // CENTER 영역 설정
        JPanel centerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(Color.WHITE);
            }
        };
        centerPanel.setLayout(null);

        // 0-9까지의 숫자를 랜덤 위치에 배치
        for (int i = 0; i < 10; i++) {
            JLabel label = new JLabel(String.valueOf(i));
            int x = (int)(Math.random() * 151) + 50;  // 50 ~ 200
            int y = (int)(Math.random() * 151) + 50;  // 50 ~ 200
            label.setLocation(x, y);
            label.setSize(20, 20);
            label.setForeground(Color.RED);
            centerPanel.add(label);
        }

        add(centerPanel, BorderLayout.CENTER);

        // 프레임 설정
        setSize(400, 400);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WestGridProgram frame = new WestGridProgram();
            frame.setVisible(true);
        });
    }
}