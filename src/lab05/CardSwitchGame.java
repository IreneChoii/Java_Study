package lab05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CardSwitchGame extends JFrame {
    private JLabel[] cards = new JLabel[12];
    private int firstSelected = -1;    // 첫 번째 선택된 카드
    private Color defaultColor = new Color(255, 255, 200);  // 연한 노란색
    private Color selectedColor = new Color(128, 0, 128);   // 보라색

    public CardSwitchGame() {
        setTitle("카드 스위치 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);

        // 메인 패널 (4x3 그리드)
        JPanel mainPanel = new JPanel(new GridLayout(3, 4, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 카드 생성
        for (int i = 0; i < 12; i++) {
            int number = i + 1;
            cards[i] = new JLabel(String.valueOf(number), SwingConstants.CENTER);
            cards[i].setOpaque(true);
            cards[i].setBackground(defaultColor);
            cards[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));

            // 카드 클릭 이벤트
            int currentIndex = i;
            cards[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    handleCardClick(currentIndex);
                }
            });

            mainPanel.add(cards[i]);
        }

        add(mainPanel);
    }

    private void handleCardClick(int index) {
        if (firstSelected == -1) {
            // 첫 번째 카드 선택
            firstSelected = index;
            cards[index].setBackground(selectedColor);
        } else if (firstSelected != index) {
            // 두 번째 카드 선택 및 스위치
            String temp = cards[firstSelected].getText();
            cards[firstSelected].setText(cards[index].getText());
            cards[index].setText(temp);

            // 색상 초기화
            cards[firstSelected].setBackground(defaultColor);
            firstSelected = -1;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CardSwitchGame().setVisible(true);
        });
    }
}