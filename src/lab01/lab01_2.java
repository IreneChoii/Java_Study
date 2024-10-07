package lab01;

import java.util.Scanner;

public class lab01_2 {
    // Travel
    // Scanner, 변수와 연산자, if, 화면 출력 등 종합 연습

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 여행지
        System.out.print("여행지 : ");
        String place = sc.nextLine();
        // 인원수
        System.out.print("인원수 : ");
        int person = sc.nextInt();
        // 숙박일
        System.out.print("숙박일 : ");
        int day = sc.nextInt();
        // 1인 항공료
        System.out.print("1인당 항공료 : ");
        int flight = sc.nextInt();
        // 방 1개 숙박료
        System.out.print("1방 숙박비 : ");
        int sleep = sc.nextInt();

        // 필요한 방 개수
        int room = (person + 1) / 2;  // 올림 나눗셈

        // 총 경비 = (비행기값 * 인원수) + (숙소값 * 방개수 * 숙박일)
        int cost = (flight * person) + (sleep * room * day);

        System.out.println(person + "명의 " + place + " " + day + "박" + (day + 1) + "일 여행에는 방이 " + room + "개 필요합니다.");
        System.out.println("총 경비는 " + cost + "원입니다.");
        sc.close();
    }
}
