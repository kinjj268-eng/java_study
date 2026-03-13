package 테레비젼;
//전원 on/off
//볼륨 조절
//채널변경


public class Television {
    //인스턴스 필드 생성, TV의 상태값을 저장
//    boolean power; //전원 on/off
//    int volume;
//    int channel;

    //접근제한자: private, default(키워드없음), protected, public
    private  boolean power;
    private  int volume;
    private int channel;


    //생성자 : 클래스가 객체로 만들어 질때 호출, 클래스 이름과 동일,반환 타입이 없음,
    // 오버로딩가능, 생성자를 만들지 않으면 숨겨진 기본생성자가 동작 함.
    //생성자의 역할은 인스턴스 필드값을 초기화 하는 목적

    Television(){
        power = false;
        volume = 10;
        channel = 11;
    }
    //생성자 오버로딩: 매개변수의 갯수나 타임에 따라 자동으로 호출됨.(정적 다형성)
    Television(boolean onOff, int vol, int ch){
     power = onOff;
     volume = vol;
     channel = ch;
    }
        //세터 메서드: 외부에서 접근 불가능한 인스턴스 필드의 값을 변경하기 위해 사용하는 메서드
    public void setPower(boolean power){
        this.power = power; //매개변수 이름과 인스턴스 필드 이름이 동일하면 this키워드 사용해야함
        System.out.println("전원을" + (power ? "ON":"OFF")+"합니다.");
    }
    //게터 메서드 : 외부에서 접근 불가능한 필드의 값을 읽기 위해 사용하는 메서드
    public boolean getPower(){
        return power;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("볼륨을"+volume+"으로 변경 합니다");
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println("채널을 " + channel + "으로 변경합니다.");
    }
    public void printTV() {
        System.out.println("==== TV 정보 출력 ====");
        System.out.println("전원 : " +  (power ? "ON" : "OFF"));
        System.out.println("채널: " + channel);
        System.out.println("볼륨: " + volume);
    }
}
