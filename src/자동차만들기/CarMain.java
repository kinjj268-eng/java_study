package 자동차만들기;

import java.util.Scanner;

public class CarMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //지역 선택: 정해진 정수 선택지 중 하나를 고르므로 가독성이 좋은 switch문 사용
        System.out.println("\n[1] 부산(400km) [2] 대전(150km) [3] 강릉(200km) [4] 광주(300km)");
        System.out.print("이동 지역을 선택하세요 : ");
        int cityChoice = sc.nextInt();
        int distance = 0; // 선택한 번호에 따른 실제 거리(km)를 저장할 변수
        switch (cityChoice) {
            case 1:
                distance = 400;
                break;
            case 2:
                distance = 150;
                break;
            case 3:
                distance = 200;
                break;
            case 4:
                distance = 300;
                break;
            default:
                System.out.println("잘못된 지역 선택입니다.");
                return; // 잘못된 입력 시 프로그램 조기 종료(안전장치)
        }

        // 승객 수 입력: 이동 횟수(moveCnt)를 결정짓는 핵심 데이터
        int passCnt = 0; // 변수를 미리 선언해둡니다.

        while (true) { // 무한 루프: 제대로 입력할 때까지 반복!
            System.out.print("이동할 승객 수를 입력하세요 (1~100명) : ");
            passCnt = sc.nextInt();

            // 입력받은 passCnt가 1보다 크거나 같고, 100보다 작거나 같은지 확인
            if (passCnt >= 1 && passCnt <= 100) {
                break; // 올바른 범위라면 루프를 탈출(break)합니다.
            } else {
                // 범위를 벗어났을 때 출력할 메시지
                System.out.println("[오류] 승객 수는 1명에서 100명 사이여야 합니다. 다시 입력해주세요.");
            }
        }
// 루프를 탈출하면 여기에 담긴 passCnt는 무조건 1~100 사이의 숫자가 됩니다!
        //차량 선택: 부모 클래스(Car) 타입의 변수를 선언하여 '다형성' 활용
        System.out.print("차량 선택 [1]스포츠카 [2]승용차 [3]버스 : ");
        Car car = null; // 선택된 차량 객체를 담을 부모 타입의 변수
        while (car == null) {
            int carChoice = sc.nextInt();

            switch (carChoice) {
                case 1:
                    car = new SportCar("스포츠카");
                    break;
                case 2:
                    car = new Sedan("승용차");
                    break;
                case 3:
                    car = new Bus("버스");
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 1~3 사이의 숫자를 입력해주세요.");
                    sc.nextLine();
            }
        }

        //부가기능 설정: 온/오프 두 상태만 존재하므로 boolean 타입으로 처리
        boolean isMode = false; // 선택 결과를 저장할 변수

        while (true) { // 1 또는 2를 입력할 때까지 무한 반복
            System.out.print("부가기능을 사용하시겠습니까? [1]YES [2]NO : ");
            int modeChoice = sc.nextInt(); // 일단 숫자로 입력받음

            if (modeChoice == 1) {
                isMode = true;  // 1번이면 true 저장
                break;          // 루프 탈출
            } else if (modeChoice == 2) {
                isMode = false; // 2번이면 false 저장
                break;          // 루프 탈출
            } else {
                // 1, 2 이외의 숫자가 들어온 경우
                System.out.println("[오류] 1번(YES) 또는 2번(NO)만 선택 가능합니다. 다시 입력해주세요.");
            }
        }

        // 1. 차량 전용 특수 기능 설정 (setMode)
        System.out.print(car.getName() + " 특수 기능을 사용하시겠습니까? [1]YES [2]NO : ");
        car.setMode(sc.nextInt() == 1);

        // 2. 인터페이스 기능 설정 (에어컨, 오디오, 자율주행)
        if (car instanceof CarInterface) {
            System.out.print(car.getName() + " 에어컨을 켜시겠습니까? [1]ON [2]OFF : ");
            ((CarInterface) car).setAircon(sc.nextInt() == 1);
        }

        if (car instanceof AudioSupport) {
            System.out.print(car.getName() + " 오디오를 켜시겠습니까? [1]ON [2]OFF : ");
            ((AudioSupport) car).setAudio(sc.nextInt() == 1);
        }

        if (car instanceof AutoPilotSupport) {
            System.out.print(car.getName() + " 자율주행을 켜시겠습니까? [1]ON [2]OFF : ");
            ((AutoPilotSupport) car).setAutoPilot(sc.nextInt() == 1);
        }
        double weather = 1.0; // 날씨 보정 계수를 담을 변수 (기본값: 맑음)

        while (true) {
            System.out.print("날씨 선택 [1]맑음 [2]비 [3]눈 : ");
            int weatherInput = sc.nextInt();

            if (weatherInput == 1) {
                weather = 1.0; // 맑음: 시간 변동 없음
                break;
            } else if (weatherInput == 2) {
                weather = 1.2; // 비: 시간 20% 증가
                break;
            } else if (weatherInput == 3) {
                weather = 1.4; // 눈: 시간 40% 증가
                break;
            } else {
                // 1, 2, 3 이외의 숫자를 입력한 경우
                System.out.println("[오류] 잘못된 날씨 선택입니다. 1~3번 사이의 숫자를 입력해주세요.");
            }
        }
        sc.nextLine();
        // 결과 출력: 매개변수로 사용자 데이터(거리)와 계산 데이터(이동횟수)를 전달
        System.out.println("\n========= 이동 결과 =========");
        // car.moveCnt(passCnt)를 매개변수로 넣어 '총 이동 횟수'를 실시간으로 배달
        System.out.println("총 비용 : " + car.cost(distance, car.moveCnt(passCnt)) + "원");
        System.out.println("주유 횟수 : " + car.refuel(distance, car.moveCnt(passCnt)) + "회");

        // 매개변수 순서 주의: distance, speed, moveCnt, weatherWeight
        // 1. 소수점이 포함된 전체 시간 계산 (예: 4.52)
        double totalTime = car.distanceTime(distance, car.getSpeed(), car.moveCnt(passCnt), weather);

// 2. 전체 시간을 '분' 단위로 환산 (예: 4.52 * 60 = 271.2분)
        int totalMinutes = (int) (totalTime * 60);

// 3. '시간'과 '분'으로 나누기
        int hours = totalMinutes / 60;   // 271 / 60 = 4시간
        int minutes = totalMinutes % 60; // 271 % 60 = 31분

// 4. 출력하기
        System.out.println("총 이동 시간 : " + (totalMinutes / 60) + "시간 " + (totalMinutes % 60) + "분");
        System.out.println("총 이동 횟수 : " + car.moveCnt(passCnt) + "회");
        if (car instanceof CarInterface) {
            System.out.println("에어컨 : " + (((Sedan) car).isAirconOn() ? "ON" : "OFF"));
        }
        if (car instanceof AudioSupport) {
            System.out.println("오디오 : " + (((Sedan) car).isAudioOn() ? "ON" : "OFF"));
        }
        if (car instanceof AutoPilotSupport) {
            System.out.println("자율주행 : " + (((Sedan) car).isAutoPilotOn() ? "ON" : "OFF"));
        }
        System.out.println("============================");
    }
}