package lab02;

import java.util.Scanner;
import java.util.Random;

// Gambling Game
// 갬블링 게임 프로그램
public class lab02_14 {
    public static void main(String[] args) {
        System.setProperty("file.encoding", "UTF-8");
        Scanner scanner = new Scanner(System.in, "UTF-8"); // 사용자 입력을 위한 Scanner 객체 생성
        Random random = new Random(); // 난수 생성을 위한 Random 객체 생성

        System.out.print("갬블링 게임을 시작합니다. 엔터를 입력하세요");

        while (true) {
            scanner.nextLine(); // 사용자가 엔터를 입력할 때까지 대기

            int[] numbers = new int[3]; // 3개의 숫자를 저장할 배열
            for (int i = 0; i < 3; i++) {
                numbers[i] = random.nextInt(3); // 0, 1, 2 중 랜덤하게 숫자 생성
            }

            System.out.print(numbers[0] + " " + numbers[1] + " " + numbers[2] + " "); // 생성된 숫자 출력

            if (numbers[0] == numbers[1] && numbers[1] == numbers[2]) {
                System.out.println("성공, 대박났어요!"); // 3개의 숫자가 모두 같을 경우
                break; // 게임 종료
            } else {
                System.out.println("\n아쉽군요. 다시 도전하세요."); // 3개의 숫자가 다를 경우
            }
        }

        scanner.close(); // Scanner 객체 닫기
    }
}