package lab01;

import java.util.Scanner;

public class lab01_1 {
    // Birthday
    // Scanner로 키 입력, /와 % 등 연산자 연습

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("생일 입력 (8자리) : ");
        int birthday = sc.nextInt();

        int year = birthday / 10000;
        int month = (birthday % 10000) / 100;
        int day = birthday % 100;


        System.out.println(year + "년" + month + "월" + day + "일");
        sc.close();
    }
}
