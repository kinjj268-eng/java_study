package 매개변수의다형성;

public class Product {
    int price;
    int bounsPoint;
}
class TV extends Product{
    TV() {
        this.price = 100;
        this.bounsPoint =10;
    }
}
class Phone extends Product{
    Phone(){
        this.price = 200;
        this.bounsPoint =20;
    }
}
class Computer extends Product{
    Computer(){
        this.price = 300;
        this.bounsPoint =30;
    }
}
class Buyer{
    int money = 1000;
    int bounsPoint = 0;
    void buy(Product product){//product 클래스의 참조 변수 =
        money -= product.price;
        bounsPoint +=  product.bounsPoint;
    }
    void printInfo(){
        System.out.println("잔액: " +money);
        System.out.println("포인트: " +bounsPoint);
    }
}