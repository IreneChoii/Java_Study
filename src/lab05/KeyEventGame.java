package lab05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyEventGame extends JFrame {
    private static final int GRID_SIZE = 5;    // 5x5 바둑판
    private static final int CELL_SIZE = 80;   // 각 칸의 크기
    private int blockX = 2;    // 초기 X 위치
    private int blockY = 2;    // 초기 Y 위치

    public KeyEventGame() {
        // 프레임 기본 설정
        setTitle("바둑판 이동 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);  // 창 크기 고정

        // 게임 패널 생성
        JPanel gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // 바둑판 그리기
                g.setColor(Color.BLACK);
                for (int i = 0; i < GRID_SIZE; i++) {
                    for (int j = 0; j < GRID_SIZE; j++) {
                        g.drawRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                    }
                }
                // 파란색 블록 그리기
                g.setColor(Color.BLUE);
                g.fillRect(blockX * CELL_SIZE, blockY * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }

            @Override
            public Dimension getPreferredSize() {
                // 패널의 크기를 그리드 크기에 맞게 설정
                return new Dimension(GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE);
            }
        };
        gamePanel.setBackground(Color.WHITE);

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

        // 패널을 프레임에 추가
        add(gamePanel);

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
            KeyEventGame game = new KeyEventGame();
            game.setVisible(true);
            game.requestFocusInWindow();
        });
    }
}