package 택배배송시스템;

class Delivery {
    String company;

    Delivery(String company){
        this.company = company;
    }
    void deliver(){
        System.out.println("배송을 시작합니다.");
    }
}
class ParcelDelivery extends Delivery{
    ParcelDelivery(String company){super(company);}

    @Override
    void deliver() {
        System.out.println("택배 배송을 시작합니다.2~3일 소요됩니다.");
    }
}
class QuickDelivery extends Delivery{
    QuickDelivery(String company) {super(company);}
    @Override
    void deliver(){
        System.out.println("퀵 배송을 시작합니다. 당일 도착 예정입니다.");
    }
}
class AirDelivery extends Delivery{
    AirDelivery(String company){super(company);}

    @Override
    void deliver() {
        System.out.println("항공 배송을 시작합니다.해외로 출발합니다.");
    }
}
class Manager{
    void send (Delivery d){
        System.out.println(d.company + "회사가 배송을 진행합니다.");
        d.deliver();
    }
}