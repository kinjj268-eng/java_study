package 자동차만들기;

public class Bus extends Car {
    private boolean isTankOn = false; // 상태 저장용 변수 추가

    public Bus(String name) {
        super(150, 5.0, 100, 20, name);
    }

    @Override
    public void setMode(boolean isOn) {
        if (isOn && !isTankOn) {
            this.tank += 30;
            isTankOn = true;
            System.out.println("보조 연료탱크가 추가되었습니다. 현재 탱크: " + tank + "L");
        } else if (!isOn && isTankOn) {
            this.tank -= 30;
            isTankOn = false;
            System.out.println("보조 연료탱크 사용을 중지합니다.");
        }
    }
}