package 자동차만들기;

public abstract class Car {
    // protected: 자식 클래스(Bus, Sedan 등)에게는 오픈하지만 외부에서는 숨기는 변수들
    protected int speed;
    protected double mileage;
    protected int tank;
    protected int seat;
    protected String name;

    // [생성자]: 자동차가 처음 만들어질 때(new) 필수 정보를 주입받는 통로
    public Car(int speed, double mileage, int tank, int seat, String name) {
        this.speed = speed; // 매개변수로 받은 speed를 클래스의 변수에 저장
        this.mileage = mileage;
        this.tank = tank;
        this.seat = seat;
        this.name = name;

    }

    // [Getter/Setter]: 변수를 안전하게 읽거나 수정하기 위한 '보호된 버튼'들
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public int getTank() {
        return tank;
    }

    public void setTank(int tank) {
        this.tank = tank;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // [공통 기능 1] moveCnt: 총 몇 번 이동해야 하는지 계산
    public int moveCnt(int passCnt) {
        return (int) Math.ceil((double) passCnt / seat);
    }

    // [공통 기능 2] refuel: 주유를 총 몇 번 해야 하는지 계산
    public int refuel(double distance, int moveCnt) {
        double totalDistance = distance * moveCnt; // 한 번 가는 거리 * 총 횟수 = 전체 거리
        double totalFuelConsumption = totalDistance / mileage;// 전체 거리 / 연비 = 소모된 연료량
        // 소모된 연료 / 탱크 용량 후 올림 처리하여 주유 횟수 도출
        return (int) Math.ceil(totalFuelConsumption / tank);
    }

    // [공통 기능 3] cost: 총 연료 비용 계산
    public int cost(double distance, int moveCnt) {
        double totalDistance = distance * moveCnt;// 총 이동 거리
        double totalFuelConsumption = totalDistance / mileage;// 총 연료량
        // 연료량에 2000원(상수)을 곱하고 정수(int)로 변환
        return (int) (totalFuelConsumption * 2000);
    }

    // [공통 기능 4] distanceTime: 총 이동 시간 계산
    public double distanceTime(double distance, double speed, int moveCnt, double weather) {
        // (거리 / 속도): 한 번 갈 때 시간. 거기에 횟수(moveCnt)와 날씨 가중치(weather)를 곱함
        return (distance / speed) * moveCnt * weather;
    }

    // [추상 메서드] setMode: 자식들마다 기능이 다르므로 이름만 정해둠(반드시 구현해야 함)
    // abstract void: 몸체 { }가 없음. 구현은 자식(Bus, Sedan 등)이 알아서 함
    public abstract void setMode(boolean isOn);

}