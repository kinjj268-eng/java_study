package 다형성2번;

import java.util.Scanner;

public class PolyMain2 {
    public static void main(String[] args) {
        Driver driver = new Driver("임유리");
        Bus bus = new Bus();
        Taxi taxi = new Taxi();
        SportCar sportsCar = new SportCar();
        Bentley bentley = new Bentley();
        Scanner sc = new Scanner(System.in);
        System.out.print("운전하고 싶은 차를 선택 하세요[1]버스, [2]택시, [3]스포츠카, [4]벤틀리: ");
        int selMenu = sc.nextInt();
        switch(selMenu) {
            case 1 : driver.drive(bus); break;
            case 2 : driver.drive(taxi); break;
            case 3 : driver.drive(sportsCar); break;
            case 4 : driver.drive(bentley);break;
        }

    }
}