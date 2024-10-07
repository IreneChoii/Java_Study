package lab03;

class ColorPoint extends Point { // Point 클래스를 상속받는 ColorPoint 클래스 정의
    private String color; // 색상을 저장하는 private 변수

    public ColorPoint(int x, int y, String color) { // x, y 좌표와 색상을 받는 생성자
        super(x, y); // 부모 클래스의 생성자 호출
        this.color = color; // 색상 초기화
    }

    public void setXY(int x, int y) { // x, y 좌표를 설정하는 메소드
        move(x, y); // 부모 클래스의 move 메소드 호출
    }

    public void setColor(String color) { // 색상을 설정하는 메소드
        this.color = color; // 새로운 색상으로 업데이트
    }

    @Override
    public String toString() { // 객체의 문자열 표현을 반환하는 메소드
        return color + "색의 (" + getX() + "," + getY() + ")의 점"; // 색상과 좌표 정보를 포함한 문자열 반환
    }

    public static void main(String[] args) { // 메인 메소드 (테스트용)
        ColorPoint cp = new ColorPoint(5, 5, "RED"); // (5,5) 위치에 빨간색 점 생성
        cp.setXY(10, 20); // 좌표를 (10,20)으로 변경
        cp.setColor("BLUE"); // 색상을 파란색으로 변경
        String str = cp.toString(); // 객체의 문자열 표현 얻기
        System.out.println(str + "입니다."); // 결과 출력
    }
}