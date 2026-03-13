package 영화표예매;

import java.util.Scanner;

public class MovieMain {
    public static void main(String[] args) {
        // TODO: 좌석당 가격을 생성자로 전달 (예: 12000)
        MovieTicket movieTicket = new MovieTicket(/* TODO: price */ 12000);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== 영화표 예매 시스템 ===");
            System.out.println("[1] 예매하기");
            System.out.println("[2] 취소하기");
            System.out.println("[3] 종료하기");
            System.out.print("메뉴 선택: ");

            // TODO: 정수 입력 받기
            int select = sc.nextInt();

            if (select == 1) {
                // TODO: 예매
                movieTicket.selectSeat();
            } else if (select == 2) {
                // TODO: 취소
                movieTicket.cancelSeat();
            } else if (select == 3) {
                // TODO: 총 판매 금액 출력 후 종료
                System.out.println("총 판매 금액: " + movieTicket.totalAmount() + "원");
                break;
            } else {
                System.out.println("메뉴 선택이 잘못되었습니다. 다시 입력하세요.");
            }
        }
    }
}