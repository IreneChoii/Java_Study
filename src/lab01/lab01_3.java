package lab01;

import java.util.Scanner;

public class lab01_3 {
    // Candle
    // 연산자(/, %)와 if연습
    // 빨간 초는 10살
    // 파란 초는 5살
    // 노란 초는 1살

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("나이 : ");
        int age = sc.nextInt();

        if(age <= 0) {
            System.out.println("나이는 양수로만 입력하세요.");
            sc.close(); // Scanner 종료
            return;
        }

        int redCandle = age / 10;
        int blueCandle = age % 10 / 5;
        int yellowCandle = (age % 10) % 5;
        int totalCandle = redCandle + blueCandle + yellowCandle;


        System.out.println("빨간초 : " + redCandle + "개");
        System.out.println("파란초 : " + blueCandle + "개");
        System.out.println("노랑초 : " + yellowCandle + "개");
        System.out.print("총 : " + totalCandle + "개 필요합니다.");

        sc.close();
    }
}
