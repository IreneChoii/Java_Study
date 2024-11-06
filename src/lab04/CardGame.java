package lab04;
import javax.swing.*;
import java.awt.*;

// lab04_01
public class CardGame extends JFrame {
    private static final int ROWS = 4;
    private static final int COLS = 4;
    private static final int TOTAL_CARDS = 16;

    public CardGame() {
        // 프레임 타이틀 설정
        setTitle("16장의 카드의 뒷면에 숨겨진 이미지 찾기");

        // 레이아웃 설정
        setLayout(new BorderLayout());

        // 상단 레이블
        JLabel topLabel = new JLabel("숨겨진 이미지 찾기", SwingConstants.CENTER);
        topLabel.setBackground(Color.PINK);
        topLabel.setOpaque(true);
        add(topLabel, BorderLayout.NORTH);

        // 카드 패널
        JPanel cardPanel = new JPanel(new GridLayout(ROWS, COLS, 5, 5));
        cardPanel.setBackground(Color.WHITE);

        // 16개의 카드 버튼 생성
        for (int i = 0; i < TOTAL_CARDS; i++) {
            JButton card = new JButton(String.valueOf(i));
            card.setBackground(new Color(144, 238, 144)); // 연한 녹색
            card.setPreferredSize(new Dimension(80, 80));
            cardPanel.add(card);
        }

        add(cardPanel, BorderLayout.CENTER);

        // 하단 시작 버튼
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.PINK);
        JButton startButton = new JButton("Exit");
        bottomPanel.add(startButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // 프레임 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CardGame game = new CardGame();
            game.setVisible(true);
        });
    }
}