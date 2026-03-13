package 택배배송시스템;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        // 각각의 배송 방식 생성
        Delivery parcel = new ParcelDelivery("우체국");
        Delivery quick = new QuickDelivery("생생퀵");
        Delivery air = new AirDelivery("대한항공");

        // 매니저가 하나씩 보냅니다
        manager.send(parcel);
        System.out.println("--------------------");
        manager.send(quick);
        System.out.println("--------------------");
        manager.send(air);
    }
}