package 자동차만들기;

public abstract class Car {
    protected int speed; // 최고 속도
    protected double mileage; // 연비
    protected int tank; // 연료탱크 크기
    protected int seat; // 좌석 수
    protected String name; // 자동차 이름

    public Car(int Speed, double mileage, int tank, int seat, String name) {
        this.speed = Speed;
        this.mileage = mileage;
        this.tank = tank;
        this.seat = seat;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    int moveCnt(int passCnt) {
        return (int) Math.ceil((double) passCnt / seat);
    }

    public int refuel(int fuel, int moveCnt) {
        double totalDist = (double) fuel * moveCnt;
        double consum = totalDist / this.mileage;
        return (int) Math.ceil(consum / this.tank);
    }

    // 총 비용 계산
    public long cost(int fuel, int moveCnt) {
        double consum = (double) (fuel * moveCnt) / this.mileage;
        return (long) (consum * 2000);
    }

    // 총 이동 시간 계산
    public String time(int fuel, int moveCnt, int weather) {
        double totalDist = (double) fuel * moveCnt;
        double timeValue = totalDist / this.speed;

        if (weather == 2) timeValue = 1.2;      // 비
        else if (weather == 3) timeValue = 1.4; // 눈

        int totalMin = (int) (timeValue * 60);
        return (totalMin / 60) + "시간 " + (totalMin % 60) + "분";
    }

    abstract void setMode(boolean isOn);


}