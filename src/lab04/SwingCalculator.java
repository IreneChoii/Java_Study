package lab04;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// SwingCalculator 클래스, JFrame을 상속하여 계산기 GUI를 구성
public class SwingCalculator extends JFrame {
    public SwingCalculator() {
        super("자바 스윙 계산기"); // 타이틀 설정
        setSize(350, 300); // 프레임 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 동작 설정
        Container contentPane = getContentPane(); // 프레임에서 컨텐트팬 받아오기
        contentPane.add(new NorthPanel(), BorderLayout.NORTH); // 북쪽 패널 추가
        contentPane.add(new CenterPanel(), BorderLayout.CENTER); // 가운데 패널 추가
        contentPane.add(new SouthPanel(), BorderLayout.SOUTH); // 남쪽 패널 추가
        setVisible(true); // 프레임을 화면에 표시
    }
    public static void main(String[] args) {
        new SwingCalculator(); // SwingCalculator 인스턴스 생성
    }
}

// 상단 패널 클래스, 수식 입력 영역을 구성
class NorthPanel extends JPanel {
    public NorthPanel() {
        setBackground(Color.LIGHT_GRAY); // 배경색 설정
        setLayout(new FlowLayout()); // FlowLayout 배치 방식 지정
        add(new JLabel("수식")); // "수식" 레이블 추가
        add(new JTextField(20)); // 입력 필드 추가
    }
}

// 중앙 패널 클래스, 계산 버튼들을 그리드 형태로 구성
class CenterPanel extends JPanel {
    private JButton calcButton; // 계산 버튼 정의
    public CenterPanel() {
        setBackground(Color.WHITE); // 배경색 설정
        setLayout(new GridLayout(5, 4, 5, 5)); // 5x4 그리드 레이아웃, 간격 5px
        // 버튼 생성 및 배열에 추가
        JButton[] buttons = {
                new JButton("C"), new JButton("UN"), new JButton("BK"), new JButton("/"),
                new JButton("7"), new JButton("8"), new JButton("9"), new JButton("x"),
                new JButton("4"), new JButton("5"), new JButton("6"), new JButton("-"),
                new JButton("1"), new JButton("2"), new JButton("3"), new JButton("+"),
                new JButton("0"), new JButton("."), new JButton("="), new JButton("%")
        };

        // 버튼 추가 및 "=" 버튼 배경색 설정
        for (JButton button : buttons) {
            add(button); // 패널에 버튼 추가
            if (button.getText().equals("=")) { // "=" 버튼일 때 배경색 지정
                button.setBackground(Color.CYAN);
                calcButton = button; // 계산 버튼 참조 저장
            }
        }
    }
}
// 하단 패널 클래스, 계산 결과 영역을 구성
class SouthPanel extends JPanel {
    public SouthPanel() {
        setBackground(Color.YELLOW); // 배경색 설정
        setLayout(new FlowLayout(FlowLayout.LEFT)); // 왼쪽 정렬로 FlowLayout 설정
        add(new JLabel("계산 결과")); // "계산 결과" 레이블 추가
        add(new JTextField(20)); // 결과 표시 필드 추가
    }
}