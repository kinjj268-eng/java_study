package 상속기본;

public class InheritanceBasic {
    public static void main(String[] args) {
        HouseDog dog = new HouseDog();
        dog.setName("댕댕이");
        System.out.println(dog.getName());
        dog.sleep(3);
    }
}

class Animal{
    String name;

    void setName(String name){
        this.name = name;
    }
    String getName(){
        return name;
    }
}

//Animal class로 부터 상속 받음
class Dog extends Animal{
    void sleep(){
        System.out.println(this.name + "zzz in house");
    }
}

class HouseDog extends Dog{
    @Override //오버라이딩 관계 성립 여부를 확인하는 어노테이션
    void sleep(){
        System.out.println(name + " 집에서 잠을 잡니다");
    }
    //오버로딩
    void sleep(int hour){
        System.out.println(name + "가 집에서 " + hour + "시간 동안 잠을 잡니다");
    }
}