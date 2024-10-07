package lab03; // lab03 패키지 선언

import java.util.ArrayList; // ArrayList 사용을 위한 import

public class lab03_4 { // lab03_4 클래스 정의

    public static void main(String[] args) { // 메인 메서드
        Average avg = new Average(); // Average 객체 생성
        avg.put(10); // 10 추가
        avg.put(15); // 15 추가
        avg.put(100); // 100 추가
        avg.showAll(); // 모든 값 출력
        System.out.println("평균은 " + avg.getAvg()); // 평균 출력
    }
}

class Average { // Average 클래스 정의
    private ArrayList<Integer> list; // 정수를 저장할 ArrayList

    public Average() { // Average 생성자
        list = new ArrayList<>();
    }

    public void put(int n) { // 값을 추가하는 메서드
        list.add(n);
    }

    public void showAll() { // 모든 값을 출력하는 메서드
        for (int n : list) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public double getAvg() { // 평균을 계산하여 반환하는 메서드
        int sum = 0;
        for (int n : list) {
            sum += n;
        }
        return (double) sum / list.size();
    }
}