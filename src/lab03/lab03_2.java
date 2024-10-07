package lab03; // lab03 패키지 선언

public class lab03_2 { // lab03_2 클래스 정의

    public static void main(String[] args) { // 메인 메서드
        Cube cube = new Cube(1, 2, 3); // 1x2x3 크기의 Cube 객체 생성
        System.out.println("큐브의 부피는 " + cube.getVolume()); // 큐브의 부피 출력
        cube.increase(1, 2, 3); // 큐브의 크기를 각 차원별로 1, 2, 3만큼 증가
        System.out.println("큐브의 부피는 " + cube.getVolume()); // 증가된 큐브의 부피 출력
        if(cube.isZero()) // 큐브의 부피가 0인지 확인
            System.out.println("큐브의 부피는 0");
        else
            System.out.println("큐브의 부피는 0이 아님");
    }
}

class Cube { // Cube 클래스 정의
    private int width, length, height; // 큐브의 가로, 세로, 높이를 저장할 변수

    public Cube(int width, int length, int height) { // Cube 생성자
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public int getVolume() { // 부피를 계산하여 반환하는 메서드
        return width * length * height;
    }

    public void increase(int w, int l, int h) { // 큐브의 크기를 증가시키는 메서드
        width += w;
        length += l;
        height += h;
    }

    public boolean isZero() { // 부피가 0인지 확인하는 메서드
        return getVolume() == 0;
    }
}