package 새로운TV만들기;

public class Main {
    public static void main(String[] args) {
        // 같은 패키지이므로 패키지명을 뺀 이름만 써도 됩니다!
        PrototypeTV money = new PrototypeTV();
        TV lgTV = new TV("우리집 TV");

        lgTV.setPower(true);
        lgTV.setVolume(120);
        lgTV.setChannel(1500, false);
        lgTV.viewTV();
    }
}

// 부모 클래스가 같은 패키지에 있으므로 상속 시 패키지명 생략 가능
class TV extends PrototypeTV {
    String name;
    boolean isInternet;

    TV() {
        super(true, 30, 30);
        name = "LG TV";
    }

    TV(String name) {
        // 부모의 기본 생성자 super()가 자동으로 호출됩니다.
        isPower = false;
        channel = 10;
        volume = 10;
        isInternet = false;
        this.name = name;
    }

    void setPower(boolean isPower) {
        this.isPower = isPower;
    }

    void setVolume(int vol) {
        if(vol >= 0 && vol <= 100) {
            this.volume = vol;
        } else {
            System.out.println("볼륨 설정 범위를 벗어 났습니다.");
        }
    }

    @Override // 오버라이딩임을 명시 (생략 가능하지만 붙이는 게 좋음)
    public void setChannel(int cnl) {
        if(cnl > 0 && cnl < 2000) {
            channel = cnl;
            System.out.println("채널을 " + channel + "변경 했습니다.");
        } else System.out.println("채널 설정 범위가 아닙니다.");
    }

    public void setChannel(int cnl, boolean isInternet) {
        if(isInternet) {
            System.out.println("인터넷 모드 입니다.");
            this.isInternet = true;
        } else {
            this.isInternet = false;
            if(cnl > 1 && cnl < 2000) {
                channel = cnl;
                System.out.println("채널을 " + channel + "변경 했습니다.");
            } else System.out.println("채널 설정 범위가 아닙니다.");
        }
    }

    void viewTV() {
        System.out.println("이름 : " + name);
        System.out.println("전원 : " + isPower);
        System.out.println("채널 : " + channel);
        System.out.println("볼륨 : " + volume);
        System.out.println("인터넷모드 : " + isInternet);
    }
}