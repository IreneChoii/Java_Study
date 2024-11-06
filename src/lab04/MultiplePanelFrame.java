package lab04;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// MultiplePanelFrame 클래스는 여러 패널을 포함하는 JFrame으로 구성된 UI 프레임
public class MultiplePanelFrame extends JFrame {
    public MultiplePanelFrame() {
        setTitle("랜덤한 별을 가진 프레임"); // 프레임 타이틀 설정
        setSize(300, 300); // 프레임 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료 시 프로그램 종료
        Container contentPane = getContentPane(); //프레임에서 컨텐트팬 받아오기
        contentPane.add(new NorthPanel(), BorderLayout.NORTH); // 북쪽 패널 추가
        contentPane.add(new CenterPanel(), BorderLayout.CENTER); // 가운데 패널
        contentPane.add(new SouthPanel(), BorderLayout.SOUTH); // 남쪽 패널 추가
        setVisible(true); // 프레임을 화면에 표시
    }
    // 상단 패널 클래스 - 별 개수 입력 및 버튼 추가
    class NorthPanel extends JPanel {
        public NorthPanel() {
            setBackground(Color.LIGHT_GRAY); // 배경색 설정
            add(new JLabel("별 개수")); // "별 개수" 레이블 추가
            add(new JTextField(10)); // 입력 필드 추가 (10글자 크기)
            add(new JButton("별 만들기")); // "별 만들기" 버튼 추가
        }
    }
    // 중앙 패널 클래스 - 랜덤 위치에 별을 표시하고 새로고침 버튼 추가
    class CenterPanel extends JPanel {
        private JLabel[] starList = new JLabel[15]; //15개의 별을 위한 JLabel 배열
        public CenterPanel() {
            setBackground(Color.WHITE); // 배경색 설정
            setLayout(null); // 자유 배치 (null 레이아웃)
// 랜덤한 위치에 별 배치
            for (int i = 0; i < starList.length; i++) {
                JLabel star = new JLabel("*"); // 별 모양의 레이블 생성
                starList[i] = star;
                star.setSize(10, 10); // 별의 크기 설정
                int x = (int) (Math.random() * 280); // x 위치 (랜덤)
                int y = (int) (Math.random() * 180); // y 위치 (랜덤)
                star.setLocation(x, y); // 별의 위치 설정
                star.setForeground(Color.RED); // 별의 색상 설정
                add(star); // 패널에 별 추가
            }
// 새로고침 버튼 추가
            JButton refreshBtn = new JButton("Refresh"); // "Refresh" 버튼 생성
            refreshBtn.setSize(80, 20); // 버튼 크기 설정
            refreshBtn.setLocation(10, 10); // 버튼 위치 설정
            add(refreshBtn); // 패널에 버튼 추가
        }
    }
    // 하단 패널 클래스 - 종료 버튼 추가
    class SouthPanel extends JPanel {
        public SouthPanel() {
            setBackground(Color.YELLOW); // 배경색 설정
            add(new JButton("Exit")); // "Exit" 버튼 추가
        }
    }
    public static void main(String[] args) {
        new MultiplePanelFrame(); // 프레임 인스턴스 생성
    }
}
