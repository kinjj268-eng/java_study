package 자동차만들기;

public class Bus extends Car implements CarInterface, AutoPilotSupport {
    private boolean isAirconOn;
    private boolean isAutoPilotOn;

    public Bus(String name) {
        // 속도 100, 연비 5.0, 탱크 100, 좌석 20
        super(100, 5.0, 100, 20, name);
    }

    @Override
    public void setMode(boolean isOn) {
        // 버스의 특수 기능 (예: 보조 탱크 등)
        if (isOn) {
            this.tank += 30;
            System.out.println("보조 연료 탱크를 사용합니다. 탱크 용량이 증가합니다.");
        }
    }

    @Override
    public void setAircon(boolean isOn) {
        this.isAirconOn = isOn;
        if (isOn) this.mileage *= 0.95; // 연비 -5%
    }

    @Override
    public void setAutoPilot(boolean isOn) {
        this.isAutoPilotOn = isOn;
        if (isOn) this.speed *= 0.9; // 최고속도 -10%
    }

    // 결과 출력용 Getter
    public boolean isAirconOn() {
        return isAirconOn;
    }

    public boolean isAutoPilotOn() {
        return isAutoPilotOn;
    }
}