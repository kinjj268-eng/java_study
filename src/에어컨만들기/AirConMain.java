package 에어컨만들기;

import java.util.Scanner;
public class AirConMain {
    public static void main(String[] args) {
        에어컨만들기.AirCon lgAirCon = new 에어컨만들기.AirCon();
        Scanner sc = new Scanner(System.in);

        System.out.print("에어컨을 켜시겠습니까? (yes / no) : ");
        String isON = sc.nextLine();

        if (isON.equalsIgnoreCase("yes")) {
            lgAirCon.setPower(true); // 전원 켜기
            lgAirCon.setAirCon(sc);  // 사용자 설정 받기 (Scanner 객체 전달)
            lgAirCon.operate();      // 에어컨 동작 시작 (모든 로직은 이제 AirCon 클래스에 위임)
        } else {
            System.out.println("에어컨을 켜지 않고 종료합니다.");
        }
    }
}
