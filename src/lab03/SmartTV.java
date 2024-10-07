package lab03;

// 실습 문제 1: SmartTV 클래스 작성
public class SmartTV extends ColorTV { // SmartTV 클래스 정의, ColorTV 클래스 상속
    private String ipAddress; // IP 주소를 저장할 private 변수 선언

    public SmartTV(String ipAddress, int size, int numColors) { // SmartTV 생성자
        super(size, numColors); // 부모 클래스 ColorTV의 생성자 호출
        this.ipAddress = ipAddress; // IP 주소 초기화
    }

    @Override
    public void printProperty() { // printProperty 메서드 Override
        System.out.printf("나의 SmartTV는 %s 주소의 %d인치 %d컬러", ipAddress, getSize(), numColors); // TV 속성 출력
    }

    public static void main(String[] args) { // 메인 메서드
        SmartTV smartTV = new SmartTV("192.168.0.5", 77, 20000000); // SmartTV 객체 생성
        // 192.168.0.5 주소의 77인치 20000000컬러 TV
        smartTV.printProperty(); // TV 속성 출력 메서드 호출
    }
}