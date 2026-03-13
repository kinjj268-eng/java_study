package 은행만들기;

import java.util.Scanner;

public class BankMAin {
    public static void main(String[] args) {
        Bank kakao = new Bank("카카오",1000);
        Bank shinhan = new Bank("신한",1000);
        Scanner sc = new Scanner(System.in);

        //은행에 대해 입금,출금, 잔액 조회 메뉴 만들기
        // 개체 생성 개수 확인 : count 값 확인
        while (true) {
            System.out.println("\n--- 메뉴 선택 ---");
            System.out.println("1. 입금 | 2. 출금 | 3. 잔액조회 | 4. 총 계좌수 확인 | 5. 종료");
            System.out.print("선택: ");
            int choice = sc.nextInt();

            if (choice == 5) {
                System.out.println("프로그램을 종료합니다.");
                break; // while문을 빠져나감
            }

            switch (choice) {
                case 1: // 입금
                    System.out.print("카카오 계좌에 얼마를 넣으시겠어요? ");
                    int depMoney = sc.nextInt();
                    kakao.deposit(depMoney);
                    break;
                case 2: // 출금
                    System.out.print("카카오 계좌에서 얼마를 빼시겠어요? ");
                    int withMoney = sc.nextInt();
                    kakao.withdraw(withMoney);
                    break;
                case 3: // 잔액 조회
                    kakao.printAccount();
                    break;
                case 4: // 총 계좌수 (정적 메서드 활용!)
                    // 객체 이름(kakao)이 아니라 클래스 이름(Bank)으로 부르는 게 정석!
                    System.out.println("현재 개설된 총 계좌 수: " + Bank.getCount());
                    break;
                default:
                    System.out.println("잘못된 번호를 선택하셨습니다.");
            }
        }}}