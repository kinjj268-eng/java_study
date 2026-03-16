package 자동차만들기;

import java.util.Scanner;

public class CarMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Car car = null;

        // 1. 이동 지역 선택 (임유리: fuel 매개변수로 쓰일 값)
        int[] distances = {0, 400, 150, 200, 300};
        System.out.print("이동 지역 [1]부산 [2]대전 [3]강릉 [4]광주 : ");
        int fuel = distances[sc.nextInt()]; // 팀 약속대로 'fuel'에 거리 저장

        // 2. 승객 수 입력 (hoomin: passCnt)
        System.out.print("이동할 승객 수 입력 : ");
        int passCnt = sc.nextInt();

        // 3. 차량 선택 (유리님 담당)
        System.out.print("차량 선택 [1]스포츠카 [2]승용차 [3]버스 : ");
        int type = sc.nextInt();
        System.out.print("차량 이름 입력 : ");
        String name = sc.next();

        if (type == 1) car = new SportCar(name);
        else if (type == 2) car = new Sedan(name);
        else if (type == 3) car = new Bus(name);

        // 4. 부가 기능 ON/OFF (isMode)
        System.out.print("부가 기능 [1]ON [2]OFF : ");
        boolean isMode = (sc.nextInt() == 1);
        car.setMode(isMode);

        // 5. 날씨 선택
        System.out.print("날씨 [1]맑음 [2]비 [3]눈 : ");
        int weather = sc.nextInt();

        // 6. 결과 출력 (팀 약속 변수명 총출동!)
        int moveCnt = car.moveCnt(passCnt); // 이동 횟수

        System.out.println("====== " + car.getName() + " ======");
        System.out.println("총 비용 : " + car.cost(fuel, moveCnt) + "원");
        System.out.println("주유 횟수 : " + car.refuel(fuel, moveCnt) + "회");
        System.out.println("이동 시간 : " + car.time(fuel, moveCnt, weather));
        System.out.println("총 이동 횟수 : " + moveCnt + "회");
    }
}