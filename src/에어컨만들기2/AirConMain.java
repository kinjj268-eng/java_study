package 에어컨만들기2;

import java.util.Scanner;

public class AirConMain {
    public static void main(String[] args) {
        AirCon myAirCon = new AirCon();
        Scanner sc = new Scanner(System.in);

        System.out.print("에어컨을 켜시겠습니다?(yes / no): ");
        String onOff = sc.nextLine();
        if (onOff.equalsIgnoreCase("yes")) {
            myAirCon.setPower(true); //원래는 getter 사용이 원칙
            myAirCon.setAirCon(sc);
            myAirCon.operate();
        } else {
            System.out.print("에어컨을 켜지 않습니다.");
        }
    }
}
