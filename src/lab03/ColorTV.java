package lab03;

public class ColorTV extends TV {  // ColorTV 클래스: TV 클래스를 상속받아 ColorTV 구현
    public int numColors; // TV의 색상 수

    public ColorTV(int size, int numColors) { // 생성자: TV 크기와 색상 수를 초기화
        super(size); // 부모 클래스의 생성자를 호출하여 TV 크기를 설정
        this.numColors = numColors;
    }

    public void printProperty() {   // TV의 크기와 색상 수를 출력하는 메소드
        System.out.printf("%d인치 %d컬러%n", getSize(), numColors);
    }

}