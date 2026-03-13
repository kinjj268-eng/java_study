package 접근제한자;

public class PrivateMain {
    public static void main(String[] args) {
        Child child = new Child();
        System.out.println(child.getName());
        System.out.println(child.getAddress());
        System.out.println(child.getMoney());

        Parent parent = new Parent();
    }
}
class Child extends Parent{
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public int getMoney(){
        return money;
    }
}
