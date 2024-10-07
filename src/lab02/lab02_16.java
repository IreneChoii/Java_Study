package lab02;

import java.util.Scanner;

// Positive Average Calculator
// 양수 평균 계산 프로그램
public class lab02_16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 사용자 입력을 위한 Scanner 객체 생성

        System.out.println("양수들의 평균을 계산합니다. 숫자들을 입력하세요:");
        String input = scanner.nextLine(); // 사용자로부터 입력 받기
        String[] numbers = input.split(" "); // 입력받은 문자열을 공백을 기준으로 분리

        int sum = 0; // 양수들의 합
        int count = 0; // 양수의 개수

        for (String number : numbers) {
            try {
                int num = Integer.parseInt(number); // 문자열을 정수로 변환
                if (num > 0) { // 양수인 경우에만 처리
                    sum += num; // 합계에 추가
                    count++; // 양수 개수 증가
                } else {
                    System.out.println(num + " 제외"); // 0 또는 음수 제외 메시지 출력
                }
            } catch (NumberFormatException e) {
                System.out.println(number + " 제외"); // 숫자가 아닌 입력 제외 메시지 출력
            }
        }

        if (count > 0) {
            double average = (double) sum / count; // 평균 계산
            System.out.printf("양수들의 평균은 %.1f\n", average); // 소수점 첫째 자리까지 출력
        } else {
            System.out.println("입력된 양수가 없습니다.");
        }

        scanner.close(); // Scanner 객체 닫기
    }
}