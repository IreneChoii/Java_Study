package lab02;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

// Monster Game
public class lab02_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 사용자 입력을 위한 Scanner 객체
        Random random = new Random(); // 난수 생성을 위한 Random 객체

        // 문제 1.4 : 통계 출력
        int totalDamageTaken = 0; // 플레이어가 받은 총 데미지
        int totalDamageDealt = 0; // 몬스터에게 가한 총 데미지

        // 플레이어와 몬스터 설정
        int playerHP = 100; // 플레이어 초기 체력 설정
        int numberOfMonsters = 2;  // 몬스터 2마리
        int[] monsterHPs = new int[numberOfMonsters];  // 몬스터들 체력 저장 배열
        int[] monsterAttacks = new int[numberOfMonsters]; // 몬스터들 공격력 저장 배열

        // 각 몬스터의 체력을 50~100 사이에서 랜덤하게 설정
        for (int i = 0; i < numberOfMonsters; i++) {
            monsterHPs[i] = random.nextInt(51) + 50;  // 50 ~ 100 사이의 체력
        }

        // 문제 1.1 : 사용자 입력 예외 처리
        // 사용자로부터 힐링 아이템 개수를 입력받기
        int healingItems; // 회복 아이템 개수 변수 선언
        do {
            System.out.print("회복 아이템의 개수를 입력하세요: ");
            try {
                healingItems = scanner.nextInt();  // 회복 아이템 개수 입력 받기
                scanner.nextLine();  // 입력 버퍼 정리
                if (healingItems < 0) {
                    System.out.println("회복 아이템의 개수는 0 이상의 숫자를 입력하세요 : ");
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                scanner.nextLine();  // 입력 버퍼 정리
                healingItems = -1;
            }
        } while (healingItems < 0);


        // 전투 시작 안내 메시지
        System.out.println("\n==================== 전투 시작 ====================");
        System.out.println("당신의 체력: " + playerHP);
        System.out.println("회복 아이템: " + healingItems + "개");
        System.out.println("==================================================");

        // 게임 진행
        for (int i = 0; i < numberOfMonsters; i++) {
            System.out.println("현재 몬스터 #" + (i + 1) + "과 싸우고 있습니다!");

            // 현재 몬스터와 싸움
            while (monsterHPs[i] > 0 && playerHP > 0) {
                System.out.println("\n현재 몬스터 #" + (i + 1) + "의 체력: " + monsterHPs[i]);
                System.out.println("당신의 체력: " + playerHP);
                System.out.println("==================================================");
                System.out.print("\n공격하려면 'a'를 입력! 종료하려면 'q' 입력! 회복하려면 'h' 입력! > ");
                String action = scanner.nextLine();

                if (action.equals("a")) { // "a" 입력 : 공격하기
                    // 플레이어의 공격
                    int playerAttack = random.nextInt(11) + 10;  // 10 ~ 20의 데미지
                    monsterHPs[i] -= playerAttack;
                    totalDamageDealt += playerAttack; // 몬스터에게 가한 공격 축적
                    System.out.println("\n==================================================");
                    System.out.println("당신이 몬스터 #" + (i + 1) + "에게 " + playerAttack + "의 데미지를 입혔습니다!");

                    // 문제 1.2 : [배열] 몬스터 공격력 추가
                    // 몬스터의 공격
                    if (monsterHPs[i] > 0) {
                        for (int j = 0; j < numberOfMonsters; j++) {
                            monsterAttacks[i] = random.nextInt(11) + 5; // 5 ~ 15의 데미지
                            playerHP -= monsterAttacks[j];
                            totalDamageTaken += monsterAttacks[j]; // 플레이어가 받은 데미지 축적
                        }
                        System.out.println("몬스터 #" + (i + 1) + "이 당신에게 " + monsterAttacks[i] + "의 데미지를 입혔습니다!");
                    } else {
                        System.out.println("몬스터 #" + (i + 1) + "을 퇴치했습니다!");
                    }

                    // 문제 1.3 : [배열] 회복 아이템의 회복량 저장
                } else if (action.equals("h")) { // "h" 입력 : 회복하기
                    int[] healingAmounts = {10, 20, 30}; // 회복량 배열 설정

                    // 플레이어가 회복 아이템을 사용
                    if (healingItems > 0) {
                        int randomHeal = healingAmounts[random.nextInt(healingAmounts.length)]; // 랜덤 회복량 선택
                        playerHP += randomHeal; // random 회복량만큼 회복
                        healingItems--;  // 회복 아이템 소모
                        System.out.println("당신은 체력을 " + randomHeal + "만큼 회복했습니다!");
                        System.out.println("남은 체력 : " + playerHP);
                        System.out.println("남은 회복 아이템 : " + healingItems + "개");
                    } else {
                        System.out.println("\n회복 아이템이 없습니다!");
                    }
                } else if (action.equals("q")) {  // "q" 입력 : 게임종료하기
                    System.out.println("\n게임을 종료합니다.");
                    scanner.close();
                    return;
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                }
            }

            // 게임 종료 조건: 플레이어 HP가 0 이하일 경우 패배
            if (playerHP <= 0) {
                System.out.println("\n당신의 체력이 모두 소진되었습니다. 패배했습니다.");
                scanner.close();
                return;
            }
        }

        // 모든 몬스터를 퇴치했을 경우 승리
        if (playerHP > 0) {
            System.out.println("\n축하합니다! 모든 몬스터를 물리쳤습니다. 승리!");
        }

        System.out.println("==================================================");

        System.out.println("총 받은 데미지 : " + totalDamageTaken);
        System.out.println("총 가한 데미지 : " + totalDamageDealt);
        System.out.println("\n각 괴물의 공격력");

        for(int i = 0; i < numberOfMonsters; i++) {
            System.out.println(" - 괴물 # " + (i + 1) + "의 공격력 : " + monsterAttacks[i]);
        }

        scanner.close(); // Scanner 객체 닫기
    }
}