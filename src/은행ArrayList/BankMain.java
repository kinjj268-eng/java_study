package 은행ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        ArrayList<NewBank> banklist = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("=".repeat(32));
            System.out.print("1. 계좌개설 | 2. 계좌선택 | 3. 전체조회 | 4. 총 계좌수 확인 | 5. 종료");
            System.out.print("\n선택: ");
            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    System.out.print("은행명 입력: ");
                    String bankName = sc.next();
                    sc.nextLine();
                    System.out.print("예금주 입력: ");
                    String name = sc.next();
                    System.out.print("초기 입금액: ");
                    int money = sc.nextInt();
                    banklist.add(new NewBank(bankName, name, money));
                    System.out.println("계좌 개설이 완료되었습니다.");
                    break;
                //전체 계좌 목록 보여주기
                case 2:
                    System.out.println("----- 계좌 목록 -----");
                    for(NewBank bank : banklist){
                        bank.printAccount();
                        System.out.println("-".repeat(32));
                    }
                    System.out.print("계좌번호입력: ");
                    int id = sc.nextInt();
                    NewBank selectedBank = null; //가리키는 대상이 없음
                    for(NewBank bank : banklist) {
                        if (bank.getId() == id) { //입력받은 계좌 번호와 일치하는 계좌의 객체를 반환
                            selectedBank = bank;
                            break;
                        }
                    }
                    while(true){
                        System.out.print("1. 입금 | 2. 출금 | 3. 잔액조회 | 4. 이전메뉴 : ");
                        int subMenu = sc.nextInt();
                        switch (subMenu){
                            case 1:
                                System.out.print(" 입금 금액 입력: ");
                                int deposit = sc.nextInt();
                                if(selectedBank != null){
                                    selectedBank.deposit(deposit);
                                }else{
                                    System.out.println("입금 계좌가 없습니다.");
                                }
                                break;
                            case 2:
                                System.out.print("출금 금액 입력: ");
                                int withDraw = sc.nextInt();
                                if(selectedBank != null){
                                    selectedBank.withdraw(withDraw);
                                }else{
                                    System.out.println("출금 계좌가 없습니다.");
                                }
                                break;
                            case 3:
                                if(selectedBank != null){
                                    selectedBank.printAccount();
                                }else {
                                    System.out.println("잔액 조회 할 계좌가 없습니다.");
                                }
                                break;
                            case 4:
                                System.out.println();
                                break;
                        }
                        if(subMenu == 4 ) break;
                    }
                    break;
                case 3:
                    for(NewBank bank : banklist){
                        bank.printAccount();
                        System.out.println("-".repeat(32));
                    }
                    break;
                case 4:
                    System.out.println("계좌 생성 개수: " + NewBank.getCount());
                    break;
                case 5:
                    System.out.println("프로그램을 종료 합니다");
                    sc.close();
                    return;
                default:
                    System.out.println("잘 못된 메뉴 입니다.");
            }
        }
    }
}