package lab03;

import java.awt.*;

class ColorPoint2 extends Point {
    private String color;

    // 기본 생성자
    public ColorPoint2() {
        super(0, 0);
        this.color = "WHITE";
    }

    // x, y 좌표만 받는 생성자
    public ColorPoint2(int x, int y) {
        super(x, y);
        this.color = "BLACK";
    }

    // x, y 좌표와 색상을 받는 생성자
    public ColorPoint2(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    // 위치 변경 메소드
    public void set(int x, int y) {
        move(x, y);
    }

    // 색상 변경 메소드
    public void set(String color) {
        this.color = color;
    }

    // 두 점 사이의 거리 계산 메소드
    public double getDistance(ColorPoint2 other) {
        int dx = getX() - other.getX();
        int dy = getY() - other.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return color + "색의 (" + getX() + "," + getY() + ")의 점";
    }

    public static void main(String[] args) {
        // (0,0) 위치의 "WHITE" 색 점
        ColorPoint2 zeroPoint = new ColorPoint2();
        System.out.println(zeroPoint.toString() + "입니다.");

        // (10,10) 위치의 "RED" 색 점
        ColorPoint2 cp = new ColorPoint2(10, 10, "RED");
        cp.set("BLUE"); // 색상 변경
        cp.set(10, 20); // 위치 변경
        System.out.println(cp.toString() + "입니다.");

        // (100, 100) 위치의 "BLACK" 점
        ColorPoint2 thresholdPoint = new ColorPoint2(100, 100);
        System.out.println("cp에서 임계점까지의 거리는 " + cp.getDistance(thresholdPoint));
    }
}
