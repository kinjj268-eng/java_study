package 자동차만들기;

public class SportCar extends Car implements CarInterface, AudioSupport {
    private boolean isAirconOn;
    private boolean isAudioOn;

    public SportCar(String name) {
        // 속도 250, 연비 8.0, 탱크 60, 좌석 2
        super(250, 8.0, 60, 2, name);
    }

    @Override
    public void setMode(boolean isOn) {
        // 스포츠카의 특수 모드 (예: 부스트 모드 등 자유롭게 설정 가능)
        if (isOn) {
            this.speed += 20;
            System.out.println("스포츠 모드가 활성화되었습니다. 최고속도가 증가합니다.");
        }
    }

    @Override
    public void setAircon(boolean isOn) {
        this.isAirconOn = isOn;
        if (isOn) this.mileage *= 0.95; // 연비 -5%
    }

    @Override
    public void setAudio(boolean isOn) {
        this.isAudioOn = isOn;
    }

    // 결과 출력용 Getter
    public boolean isAirconOn() {
        return isAirconOn;
    }

    public boolean isAudioOn() {
        return isAudioOn;
    }
}