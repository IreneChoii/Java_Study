package lab06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

// 메인 프레임 클래스
public class ImageViewer extends JFrame {
    public static void main(String[] args) {
        // Swing GUI는 이벤트 디스패치 스레드에서 실행
        SwingUtilities.invokeLater(() -> {
            new ImageViewer();
        });
    }

    public ImageViewer() {
        // 프레임 기본 설정
        setTitle("이미지 그리기 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // 이미지 패널 생성 및 프레임에 추가
        ImagePanel imagePanel = new ImagePanel();
        add(imagePanel);

        // 화면 중앙에 프레임 배치
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

// 이미지를 표시할 패널 클래스
class ImagePanel extends JPanel {
    private Image backgroundImage;    // 배경 이미지 저장
    private boolean showImage = true; // 이미지 표시 여부
    private JButton toggleButton;     // 이미지 표시/숨김 버튼

    public ImagePanel() {
        // FlowLayout으로 버튼 배치
        setLayout(new FlowLayout());
        loadImage();
        createToggleButton();
        // 패널 기본 크기 설정
        setPreferredSize(new Dimension(800, 600));
    }

    // 이미지 파일 로드 메소드
    private void loadImage() {
        try {
            // 현재 작업 경로 확인
            String currentPath = new File(".").getCanonicalPath();
            System.out.println("현재 경로: " + currentPath);

            // 여러 경로에서 이미지 파일 찾기
            File imageFile = new File("src/lab06/back.jpg");
            if (!imageFile.exists()) {
                imageFile = new File("lab06/back.jpg");
            }
            if (!imageFile.exists()) {
                imageFile = new File("back.jpg");
            }

            System.out.println("이미지 파일 경로: " + imageFile.getAbsolutePath());

            // 이미지 파일 존재 확인 및 로드
            if (imageFile.exists()) {
                backgroundImage = new ImageIcon(imageFile.getAbsolutePath()).getImage();
                System.out.println("이미지 로드 성공");
            } else {
                // 이미지를 찾지 못한 경우 시도한 경로들 출력
                System.out.println("이미지 파일을 찾을 수 없습니다. 다음 경로들을 시도했습니다:");
                System.out.println("1. " + new File("src/lab06/back.jpg").getAbsolutePath());
                System.out.println("2. " + new File("lab06/back.jpg").getAbsolutePath());
                System.out.println("3. " + new File("back.jpg").getAbsolutePath());
            }
        } catch (Exception e) {
            System.out.println("이미지 로드 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Hide/Show 버튼 생성 및 이벤트 처리
    private void createToggleButton() {
        toggleButton = new JButton("Hide/Show");
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 버튼 클릭시 이미지 표시 상태 토글
                showImage = !showImage;
                repaint(); // 화면 다시 그리기
            }
        });
        add(toggleButton);
    }

    // 패널에 이미지 그리기
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 이미지가 있고 표시 상태가 true일 때만 그리기
        if (showImage && backgroundImage != null) {
            // 패널 크기에 맞게 이미지 크기 조절하여 그리기
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}