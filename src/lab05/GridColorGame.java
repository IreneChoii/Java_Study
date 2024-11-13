package lab05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GridColorGame extends JFrame {
    private static final int GRID_SIZE = 5;        // 5x5 바둑판
    private static final int CELL_SIZE = 80;       // 각 칸의 크기
    private static final int BUTTON_WIDTH = 60;    // 버튼 너비
    private static final int NUM_BUTTONS = 10;     // 버튼 개수

    private int blockX = 2;    // 초기 X 위치
    private int blockY = 2;    // 초기 Y 위치
    private Color blockColor = Color.BLUE;  // 초기 블록 색상
    private JPanel gamePanel;  // 게임 패널

    public GridColorGame() {
        setTitle("바둑판 색상 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);  // 창 크기 고정

        // 게임 패널 생성
        gamePanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                // 바둑판 그리기
                g.setColor(Color.BLACK);
                for (int i = 0; i < GRID_SIZE; i++) {
                    for (int j = 0; j < GRID_SIZE; j++) {
                        g.drawRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                    }
                }
                // 블록 그리기
                g.setColor(blockColor);
                g.fillRect(blockX * CELL_SIZE, blockY * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE);
            }
        };
        gamePanel.setBackground(Color.WHITE);

        // 색상 버튼 패널 생성
        JPanel buttonPanel = new JPanel(new GridLayout(NUM_BUTTONS, 1, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        buttonPanel.setPreferredSize(new Dimension(BUTTON_WIDTH, GRID_SIZE * CELL_SIZE));

        // 10가지 색상 정의
        Color[] colors = {
                Color.RED,          // 빨강
                Color.GREEN,        // 초록
                Color.BLUE,         // 파랑
                Color.YELLOW,       // 노랑
                Color.CYAN,         // 하늘
                Color.MAGENTA,      // 자주
                Color.ORANGE,       // 주황
                Color.PINK,         // 분홍
                Color.GRAY,         // 회색
                new Color(128, 0, 128)  // 보라
        };

        // 색상 버튼 생성
        for (Color color : colors) {
            JButton btn = new JButton();
            btn.setBackground(color);
            btn.setOpaque(true);
            btn.setBorderPainted(false);

            // 버튼 클릭 이벤트
            btn.addActionListener(e -> {
                blockColor = color;
                gamePanel.repaint();
                requestFocusInWindow();
            });

            buttonPanel.add(btn);
        }

        // 키보드 이벤트 처리
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        if (blockX > 0) blockX--;
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (blockX < GRID_SIZE - 1) blockX++;
                        break;
                    case KeyEvent.VK_UP:
                        if (blockY > 0) blockY--;
                        break;
                    case KeyEvent.VK_DOWN:
                        if (blockY < GRID_SIZE - 1) blockY++;
                        break;
                }
                gamePanel.repaint();
            }
        });

        // 레이아웃 설정
        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        mainPanel.add(buttonPanel);
        mainPanel.add(gamePanel);
        add(mainPanel);

        // 키보드 입력을 위한 포커스 설정
        setFocusable(true);
        requestFocusInWindow();

        // 프레임 크기를 컴포넌트에 맞게 설정
        pack();
        // 화면 중앙에 위치
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GridColorGame game = new GridColorGame();
            game.setVisible(true);
            game.requestFocusInWindow();
        });
    }
}