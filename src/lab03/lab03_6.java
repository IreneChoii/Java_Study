package lab03; // lab03 패키지 선언

import java.awt.*; // Rectangle 클래스 사용을 위한 import

public class lab03_6 { // lab03_6 클래스 정의

    public static void main(String[] args) { // 메인 메서드
        Rectangle a = new Rectangle(3, 3, 6, 6); // 3,3 위치에 6x6 크기의 사각형 a 생성
        Rectangle b = new Rectangle(4, 4, 2, 3); // 4,4 위치에 2x3 크기의 사각형 b 생성

        a.show(); // a의 정보 출력
        if(a.isSquare()) System.out.println("a는 정사각형입니다."); // a가 정사각형인지 확인
        else System.out.println("a는 직사각형입니다.");
        if(a.contains(b)) System.out.println("a는 b를 포함합니다."); // a가 b를 포함하는지 확인
    }
}

class Rectangle { // Rectangle 클래스 정의
    private int x, y, width, height; // 사각형의 위치와 크기를 저장할 변수

    public Rectangle(int x, int y, int width, int height) { // Rectangle 생성자
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void show() { // 사각형 정보를 출력하는 메서드
        System.out.println("(" + x + ", " + y + ")에서 크기가 " + width + "X" + height + "인 사각형");
    }

    public boolean isSquare() { // 정사각형인지 확인하는 메서드
        return width == height;
    }

    public boolean contains(Rectangle r) { // 다른 사각형을 포함하는지 확인하는 메서드
        return (x <= r.x && y <= r.y &&
                x + width >= r.x + r.width &&
                y + height >= r.y + r.height);
    }
}