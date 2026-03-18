package 자동차만들기;

/**
 * Bus 클래스는 Car를 상속받고, 에어컨과 자율주행 인터페이스를 구현합니다.
 */
public class Bus extends Car implements CarInterface, AutoPilotSupport {
    // 부가 기능의 현재 상태를 저장할 멤버 변수 (ON/OFF 상태값)
    private boolean isAirconOn;
    private boolean isAutoPilotOn;

    // [생성자]: 메인에서 차량 이름을 받아올 때 기본 성능(속도, 연비 등)을 설정
    public Bus(String name) {
        // super(): 부모 클래스인 Car의 생성자를 호출하여 기본값 세팅
        // 순서: 속도(100), 연비(5.0), 연료탱크(100), 좌석수(20), 이름(name)
        super(100, 5.0, 100, 20, name);
    }

    /**
     * @Override: 부모 클래스(Car)의 추상 메서드를 버스에 맞게 구현
     * 버스의 특수 기능: 보조 연료 탱크 활성화
     */
    @Override
    public void setMode(boolean isOn) {
        if (isOn) {
            this.tank += 30; // 보조 탱크 연결 시 연료 용량 30L 증가
            System.out.println("보조 연료 탱크를 사용합니다. 탱크 용량이 증가합니다.");
        }
    }

    /**
     * @Override: CarInterface의 에어컨 설정 기능을 구현
     */
    @Override
    public void setAircon(boolean isOn) {
        this.isAirconOn = isOn; // 현재 상태 저장
        if (isOn) {
            // 에어컨 가동 시 연비(mileage)가 5% 감소함 (계산식: 현재연비 * 0.95)
            this.mileage *= 0.95;
        }
    }

    /**
     * @Override: AutoPilotSupport의 자율주행 설정 기능을 구현
     */
    @Override
    public void setAutoPilot(boolean isOn) {
        this.isAutoPilotOn = isOn; // 현재 상태 저장
        if (isOn) {
            // 자율주행 가동 시 안전을 위해 최고속도가 10% 감소함 (계산식: 현재속도 * 0.9)
            this.speed *= 0.9;
        }
    }

    // --- 결과 출력을 위한 Getter 메서드들 ---

    // 현재 에어컨이 켜져 있는지 확인 (Main에서 출력용으로 사용)
    public boolean isAirconOn() {
        return isAirconOn;
    }

    // 현재 자율주행이 켜져 있는지 확인 (Main에서 출력용으로 사용)
    public boolean isAutoPilotOn() {
        return isAutoPilotOn;
    }
}