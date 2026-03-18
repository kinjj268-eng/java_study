package 자동차만들기;

/**
 * Sedan 클래스: Car를 상속받으며, 모든 부가 기능 인터페이스를 다중 구현(implements)합니다.
 */
public class Sedan extends Car implements CarInterface, AudioSupport, AutoPilotSupport {
    // 부가 기능들의 ON/OFF 상태를 기억할 멤버 변수들
    private boolean isAirconOn;
    private boolean isAudioOn;
    private boolean isAutoPilotOn;

    // 세단만의 특수 기능(트렁크 좌석화) 상태 변수
    private boolean isTrunkSeatOn = false;

    // [생성자]: 부모 클래스의 생성자를 호출하여 세단(BMW i7)의 기본 제원을 설정
    public Sedan(String name) {
        // super(최고속도, 연비, 연료탱크, 좌석수, 이름)
        super(200, 12.0, 45, 4, "BMW i7 M70");
    }

    /**
     * @Override: 부모 클래스(Car)의 추상 메서드 구현
     * 세단의 특수 기능: 부가기능 사용 시 트렁크 공간을 좌석으로 변환하여 승객 1명을 더 태움
     */
    @Override
    public void setMode(boolean isOn) {
        // isOn이 true이고 아직 좌석이 늘어나지 않은 상태라면
        if (isOn && !isTrunkSeatOn) {
            this.seat += 1;          // 좌석 수 1개 증가
            isTrunkSeatOn = true;    // 상태 업데이트
        }
        // isOn이 false이고 이미 좌석이 늘어난 상태라면 원복
        else if (!isOn && isTrunkSeatOn) {
            this.seat -= 1;          // 좌석 수 1개 감소
            isTrunkSeatOn = false;   // 상태 업데이트
        }
    }

    /**
     * @Override: CarInterface 구현 (에어컨 기능)
     */
    @Override
    public void setAircon(boolean isOn) {
        this.isAirconOn = isOn;
        if (isOn) {
            // 에어컨 가동 시 연비(mileage) 5% 감소
            this.mileage *= 0.95;
        }
    }

    /**
     * @Override: AudioSupport 구현 (오디오 기능)
     */
    @Override
    public void setAudio(boolean isOn) {
        this.isAudioOn = isOn; // 오디오는 계산에 영향을 주지 않고 상태만 저장
    }

    /**
     * @Override: AutoPilotSupport 구현 (자율주행 기능)
     */
    @Override
    public void setAutoPilot(boolean isOn) {
        this.isAutoPilotOn = isOn;
        if (isOn) {
            // 자율주행 모드 시 안전을 위해 최고속도(speed) 10% 감소
            this.speed *= 0.9;
        }
    }

    // --- 메인(CarMain)에서 현재 상태를 확인하기 위한 Getter 메서드들 ---

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