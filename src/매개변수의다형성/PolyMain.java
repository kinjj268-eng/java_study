package 매개변수의다형성;

import java.util.Scanner;

public class PolyMain {
    public static void main(String[] args) {
        Buyer buyer = new Buyer();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("1. TV");
            System.out.println("2. Phone");
            System.out.println("3. Computer");
            System.out.println("4. 정보보기");
            System.out.println("5. 종료");
            int menu = sc.nextInt();
            switch (menu){
                case 1:
                    buyer.buy(new TV());
                    break;
                case 2:
                    buyer.buy(new Phone());
                    break;
                case 3:
                    buyer.buy(new Computer());
                    break;
                case 4:
                    buyer.printInfo();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("메뉴선택이 잘못됨");
            }
        }
    }
}
