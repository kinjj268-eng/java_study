package 인터페이스;

public class Television implements Remocon {
    private int volume;
    private int channel;

    @Override
    public void turnON() {
        System.out.println("TV를 켭니다");

    }

    @Override
    public void turnOFF() {
        System.out.println("TV를 끕니다");
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
        System.out.println("현재 TV볼륨은 " + this.volume);
    }

    public void setChannel(int channel) {
        if (channel >= 1 & channel <= 999) {
            this.channel = channel;
        } else {
            System.out.println("채널설정범위가 아닙니다");
        }
    }
}