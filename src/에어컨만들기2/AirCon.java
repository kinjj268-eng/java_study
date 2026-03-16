package 에어컨만들기2;
// 기능 설계
//- 전원 ON/OFF 기능
//- 온도 설정 기능 (1도 단위 설정)
//- 현재 온도 표시 기능
//- 냉방기 ON/OFF 기능
//- 난방기 ON/OFF 기능
//- 바람세기 설정 (1단계 / 2단계 / 3단계)

// 생성자 만들기
// 각각의 필드에 대한 게터와 세터 만들기
// 예어컨의 전체 정보 상태를 보여는 메서드 만들기

import java.util.Calendar;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class AirCon {
    private boolean power;  // 전원 : ON/OFF
    private int tempSet;    // 온도 설정
    private int tempNow;    // 현재 온도 표시
    private boolean cooler; // ON/OFF
    private boolean heater; // ON/OFF
    private int wind;       // 1/2/3

    public AirCon() {
        // 월별 평균 기온 (1월은 -5도, 2월은 3도... 이런 식)
        final int[] monthArr = {-5, 3, 10, 15, 22, 28, 32, 30, 24, 16, 8, 4};
        Calendar now = Calendar.getInstance(); // 현재 시스템의 날짜 정보를 가져옴
        int month = now.get(Calendar.MONTH); // 현재가 몇 월인지 알아냄 (0이 1월임)
        this.tempNow = monthArr[month];
        power = false;
        tempSet = 20;  // 설정 온도
        cooler = false;
        heater = false;
        wind = 1;
    }

    public void printAirCon() {
        final String[] step = {"", "1단계", "2단계", "3단계"};
        System.out.println("======= 에어컨 정보 =======");
        System.out.println("전원 " + (power ? "ON" : "OFF"));
        System.out.println("현재 온도 : " + tempNow);
        System.out.println("설정 온도 : " + tempSet);
        System.out.println("냉방 모드 : " + (cooler ? "ON" : "OFF"));
        System.out.println("난방 모드 : " + (heater ? "ON" : "OFF"));
        System.out.println("바람 세기 : " + step[wind]);
    }

    //에어컨 동작 메서드
    public void operate() {
        int elapaesdTime = 0; //경과시간을 계산하기 위한 변수
        boolean changedTemp = false; //온도를 변경해야하는 조건
        System.out.println("\n ===== 에어컨 작동을 시작 합니다. ===== ");
        printAirCon();

        try {
            while (true) {
                sleep(1000); //1초 잠재움
                elapaesdTime++;
                int getTimeThreshold = getTime(); //바람세기에 따른 시간값 가져옴

                if (elapaesdTime >= getTimeThreshold) { //온도를 바꿔야할 상황
                    changedTemp = true;
                }
                if (changedTemp) { //온도를 변경해야할 조건
                    if (cooler) setTempNow(-1);
                    if (heater) setTempNow(1);
                    printAirCon();
                    elapaesdTime = 0; //경과 시간을 초기화
                    changedTemp = false; //온도 변경 조건을 false로 변경
                }
                if (tempNow == tempSet) { //현재 온도와 설정온도가 같은 경우
                    System.out.println("\n 설정 온도에 도달하여 작동을 종료");
                    power = false;
                    break;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); //sleep() 에 대한 예외 처리
        }
    }

    //에어컨 설정
    public void setAirCon(Scanner sc) { //스캐너 객체를 전달 받음
        System.out.println("현재온도는 " + tempNow + " 도 입니다");
        System.out.print("온도설정: ");
        tempSet = sc.nextInt();
        System.out.print("바람세기: ");
        wind = sc.nextInt();

        if (tempNow > tempSet) { //온도를 내려야하는 경우
            System.out.println("Cooler가 동작합니다.");
            cooler = true;
            heater = false;
        } else if (tempNow < tempSet) {
            System.out.println("Heater가 동작합니다.");
            cooler = false;
            heater = true;
        } else {
            cooler = false;
            heater = false;
        }

    }

    //현재온도 변경메서드
    private void setTempNow(int temp) {
        tempNow += temp;
    }

    private int getTime() {
        switch (wind) {
            case 1:
                return 60;
            case 2:
                return 30;
            case 3:
                return 20;
            default:
                return 60;
        }
    }

    public void setPower(boolean powerb) {
        this.power = power;
    }

    public boolean isPower() {
        return power;
    }
}