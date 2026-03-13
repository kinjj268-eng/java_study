package 에어컨실습; // '에어컨실습'이라는 주머니(패키지)에 담겨 있어요

import java.util.Calendar; // 날짜와 시간 정보를 가져오는 도구
import java.util.InputMismatchException; // 숫자를 넣어야 하는데 문자를 넣는 등 '잘못된 입력' 에러 처리 도구
import java.util.Scanner; // 키보드 입력 도구
import static java.lang.Thread.sleep; // 시간을 잠깐 멈추게 하는 마법(실시간 시뮬레이션용)

public class AirCon {
    // [인스턴스 필드] 에어컨의 상태값들 (Heap 영역에 저장)
    private boolean isPower;  // 전원 상태 (ON/OFF)
    private int setTemp;      // 사용자가 맞춘 '희망 온도'
    private int currTemp;     // 지금 현재의 '실내 온도'
    private boolean isCooler; // 냉방기 작동 여부
    private boolean isHeater; // 난방기 작동 여부
    private int windStep;     // 바람 세기 (1단, 2단, 3단)

    // [상수] 절대 변하지 않는 기준값 (초 단위)
    private static final int TIME_PER_DEGREE_STEP_1 = 60; // 1단일 땐 60초마다 1도 바뀜
    private static final int TIME_PER_DEGREE_STEP_2 = 30; // 2단일 땐 30초마다 1도 바뀜
    private static final int TIME_PER_DEGREE_STEP_3 = 20; // 3단일 땐 20초마다 1도 바뀜

    // [생성자] 에어컨이 처음 만들어질 때 세팅
    public AirCon() {
        // 월별 평균 기온 (1월은 -5도, 2월은 3도... 이런 식)
        final int[] monthArr = {-5, 3, 10, 15, 22, 28, 32, 30, 24, 16, 8, 4};
        Calendar now = Calendar.getInstance(); // 현재 시스템의 날짜 정보를 가져옴
        int month = now.get(Calendar.MONTH); // 현재가 몇 월인지 알아냄 (0이 1월임)

        this.currTemp = monthArr[month]; // 현재 월에 맞는 온도로 실내 온도 초기화! (디테일하네요!)
        this.isPower = false;
        this.setTemp = 22; // 기본 설정 온도는 22도
        this.isCooler = false;
        this.isHeater = false;
        this.windStep = 1; // 처음엔 약풍(1단)
    }

    // [메서드] 에어컨을 실제로 가동시키는 엔진 부분
    public void operate() {
        int elapsedTime = 0; // 시간이 얼마나 흘렀는지 재는 초시계
        boolean changedTemp = false; // 온도를 바꿀 타이밍인지 체크

        System.out.println("\n===== 에어컨 작동을 시작합니다. =====");
        airConInfo(); // 현재 상태 한 번 보여주기

        try {
            while (true) { // 설정 온도에 도달할 때까지 무한 반복
                sleep(1000); // 1000밀리초(1초) 동안 프로그램을 멈춤 (실제 시간 흐름 흉내)
                elapsedTime++; // 1초씩 증가

                // 지금 바람 세기라면 몇 초마다 온도를 바꿔야 하는지 기준값을 가져옴
                int timeThreshold = getTimeThreshold();

                // 흐른 시간이 기준값(예: 60초)에 도달하면?
                if (elapsedTime >= timeThreshold) {
                    changedTemp = true; // "이제 온도 바꿀 시간이다!"
                }

                if (changedTemp) {
                    if (isCooler) setCurrTemp(-1); // 냉방 중이면 온도 1도 낮춤
                    if (isHeater) setCurrTemp(1);  // 난방 중이면 온도 1도 높임

                    System.out.println("\n[온도 변경!]");
                    airConInfo(); // 바뀐 온도 보여주기
                    elapsedTime = 0; // 초시계 초기화
                    changedTemp = false; // 상태 초기화
                }

                // 현재 온도가 드디어 설정 온도와 같아지면?
                if (currTemp == setTemp) {
                    System.out.println("\n설정 온도에 도달하여 에어컨 작동을 종료합니다.");
                    break; // 가동 중지!
                }
            }
        } catch (InterruptedException e) {
            // 자고 있는데 누가 깨우면(에러 나면) 처리하는 부분
            Thread.currentThread().interrupt();
        }
    }

    // [도우미 메서드] 바람 세기에 따라 온도가 변하는 '속도'를 결정
    private int getTimeThreshold() {
        switch (windStep) {
            case 1: return TIME_PER_DEGREE_STEP_1; // 1단은 60초
            case 2: return TIME_PER_DEGREE_STEP_2; // 2단은 30초
            case 3: return TIME_PER_DEGREE_STEP_3; // 3단은 20초 (제일 빠름)
            default: return TIME_PER_DEGREE_STEP_1;
        }
    }

    // [메서드] 현재 에어컨의 상태(전원, 온도, 모드 등)를 예쁘게 출력
    public void airConInfo() {
        final String[] step = {"", "1단계", "2단계", "3단계"};
        System.out.println("=".repeat(10) + " 에어컨 정보 " + "=".repeat(10));
        System.out.println("전원 : " + (isPower ? "ON" : "OFF"));
        System.out.println("현재 온도 : " + currTemp + "℃");
        System.out.println("설정 온도 : " + setTemp + "℃");
        System.out.println("냉방 모드 : " + (isCooler ? "ON" : "OFF"));
        System.out.println("난방 모드 : " + (isHeater ? "ON" : "OFF"));
        System.out.println("바람 세기 : " + step[windStep]);
        System.out.println("=".repeat(32));
    }

    // [메서드] 사용자로부터 온도시 설정과 바람 세기를 입력받는 부분
    public void setAirCon(Scanner sc) {
        System.out.println("현재 온도는 " + currTemp + "℃ 입니다.");

        // 온도 설정 반복 (잘못 입력하면 다시 물어봄)
        while (true) {
            try {
                System.out.print("온도 설정 : ");
                setSetTemp(sc.nextInt()); // 입력받은 숫자를 설정 온도로!
                System.out.println("설정 온도는 " + getSetTemp() + "℃ 입니다.");
                break; // 잘 입력했으면 탈출
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자로만 입력해주세요.");
                sc.next(); // 스캐너에 남아있는 잘못된 찌꺼기 문자열을 비워줌
            }
        }

        // 바람 세기 설정 반복
        while (true) {
            try {
                System.out.print("바람 세기 설정(1/2/3) : ");
                int step = sc.nextInt();
                if (step > 0 && step < 4) { // 1, 2, 3 중 하나라면
                    setWindStep(step);
                    break;
                } else {
                    System.out.println("1, 2, 3 중에서만 선택해주세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자로만 입력해주세요.");
                sc.next();
            }
        }

        // [자동 모드 결정] 현재 온도와 설정 온도를 비교해서 냉방/난방 결정
        if (currTemp > setTemp) {
            System.out.println("Cooler가 동작합니다."); // 현재가 더 더우면 냉방
            isCooler = true;
            isHeater = false;
        } else if (currTemp < setTemp) {
            System.out.println("Heater가 동작합니다."); // 현재가 더 추우면 난방
            isCooler = false;
            isHeater = true;
        } else {
            isCooler = false; // 온도가 같으면 아무것도 안 함
            isHeater = false;
        }
    }

    // [Getter/Setter] private 필드에 안전하게 접근하기 위한 통로들
    public void setPower(boolean power) { this.isPower = power; }
    public void setWindStep(int step) { this.windStep = step; }
    public void setSetTemp(int temp) { this.setTemp = temp; }
    private void setCurrTemp(int n) { this.currTemp += n; }
    public int getSetTemp() { return setTemp; }
}