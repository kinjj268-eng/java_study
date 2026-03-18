package 자동차만들기;

public class Sedan extends Car implements CarInterface, AudioSupport, AutoPilotSupport {
    private boolean isAirconOn;
    private boolean isAudioOn;
    private boolean isAutoPilotOn;
    private boolean isTrunkSeatOn = false;
    private boolean seatOn = false;

    public Sedan(String name) {
        super(200, 12.0, 45, 4, name);
    }

    @Override
    public void setMode(boolean isOn) {
        if (isOn && !isTrunkSeatOn) {
            this.seat += 1;
            isTrunkSeatOn = true;
        } else if (!isOn && isTrunkSeatOn) {
            this.seat -= 1;
            isTrunkSeatOn = false;
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

    @Override
    public void setAutoPilot(boolean isOn) {
        this.isAutoPilotOn = isOn;
        if (isOn) this.speed *= 0.9; // 최고속도 -10%
    }

    // 결과 출력을 위한 Getter
    public boolean isAirconOn() {
        return isAirconOn;
    }

    public boolean isAudioOn() {
        return isAudioOn;
    }

    public boolean isAutoPilotOn() {
        return isAutoPilotOn;
    }
}