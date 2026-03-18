package 자동차만들기;

public interface CarInterface {
    void setAircon(boolean isOn);

    boolean isAirconOn(); // 현재 상태를 가져오는 메서드 추가
}

interface AudioSupport {
    void setAudio(boolean isOn);

    boolean isAudioOn(); // 추가
}

interface AutoPilotSupport {
    void setAutoPilot(boolean isOn);

    boolean isAutoPilotOn(); // 추가
}