package 인터페이스;

public class PlayStation5 implements Remocon {
    private int volume;
    private String title;

    @Override
    public void turnON() {
        System.out.println("플스5의 전원을 켭니다");

    }

    @Override
    public void turnOFF() {
        System.out.println("플스5의 전원을 끕니다");
    }

    @Override
    public void setVolume(int volume) {
        if (volume > Remocon.MAX_VOLUME) {
            this.volume = Remocon.MAX_VOLUME;
        } else if (volume < Remocon.MIN_VOLUME) {
            this.volume = Remocon.MIN_VOLUME;
        } else {
            this.volume = volume;
        }
        System.out.println("현재 TV볼륨은 " + this.volume + "입니다");
    }

    public void playGame(String title) {
        System.out.printf("게임 [%s]를 실행합니다.\n", title);
    }
}