package 조건문실습;

import java.util.Scanner;

public class ConditionEx2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = "=".repeat(32); // 아까 물어보신 구분선 출력!
        while(true){
        // 1. 메뉴 보여주기
        System.out.println(line);
        System.out.println("       🥤 자판기에 오신걸 환영합니다!");
        System.out.println(line);
        System.out.println("1. 콜라      - 1,500원");
        System.out.println("2. 사이다    - 1,500원");
        System.out.println("3. 커피      - 1,000원");
        System.out.println("4. 생수      -   500원");
        System.out.println(line);

        // 2. 입력 받기
        System.out.print("투입 금액 입력 : ");
        int inputMoney = sc.nextInt();
        System.out.print("메뉴 번호 선택 : ");
        int choice = sc.nextInt();

        // 3. 메뉴 정보 설정 (변수에 담아두기)
        String menuName = "";
        int price = 0;

        switch (choice) {
            case 1: menuName = "콜라";   price = 1500; break;
            case 2: menuName = "사이다"; price = 1500; break;
            case 3: menuName = "커피";   price = 1000; break;
            case 4: menuName = "생수";   price = 500;  break;
            default:
                System.out.println("❌ 없는 메뉴입니다.");
                continue; // 여기서 프로그램 종료!
        }

        // 4. 결과 출력
        System.out.println(line);
        if (inputMoney >= price) {
            // 성공 케이스
            System.out.println("✅ " + menuName + " 가 나왔습니다!");
            System.out.println("투입 금액 : " + inputMoney + "원");
            System.out.println("상품 금액 : " + price + "원");
            System.out.println("거스름돈  : " + (inputMoney - price) + "원");
        } else {
            // 부족 케이스
            System.out.println("❌ 잔액이 부족합니다.");
            System.out.println("투입 금액 : " + inputMoney + "원");
            System.out.println("필요 금액 : " + price + "원");
            System.out.println("부족 금액 : " + (price - inputMoney) + "원");
        }
        System.out.println(line);
    }
}}