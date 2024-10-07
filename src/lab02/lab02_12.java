package lab02;

import java.util.Scanner;
import java.util.Random;

// Naming Program
// 이름 작명 프로그램
public class lab02_12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 사용자 입력을 위한 Scanner 객체 생성
        Random random = new Random(); // 랜덤 선택을 위한 Random 객체 생성

        System.out.println("이름 작명 프로그램을 시작합니다.");

        while (true) {
            System.out.print("성별을 입력하세요 (남/여/그만): ");
            String gender = scanner.nextLine(); // 사용자로부터 성별 입력 받기

            if (gender.equals("그만")) {
                System.out.println("프로그램을 종료합니다.");
                break; // 반복문 종료
            }

            if (!gender.equals("남") && !gender.equals("여")) {
                System.out.println("잘못된 입력입니다. '남' 또는 '여'를 입력하세요.");
                continue; // 반복문의 처음으로 돌아가기
            }

            System.out.print("성을 입력하세요: ");
            String lastName = scanner.nextLine(); // 사용자로부터 성 입력 받기

            String[] maleNames = {"준호", "민수", "성민", "지훈", "현우"}; // 남자 이름 목록
            String[] femaleNames = {"미나", "수진", "지은", "예은", "서연"}; // 여자 이름 목록

            String firstName;
            if (gender.equals("남")) {
                firstName = maleNames[random.nextInt(maleNames.length)]; // 남자 이름 중 랜덤 선택
            } else {
                firstName = femaleNames[random.nextInt(femaleNames.length)]; // 여자 이름 중 랜덤 선택
            }

            String fullName = lastName + firstName; // 성과 이름을 합쳐 전체 이름 생성
            System.out.println("추천하는 이름: " + fullName); // 추천 이름 출력
        }

        scanner.close(); // Scanner 객체 닫기
    }
}