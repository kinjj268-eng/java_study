package 싱글톤;

public class Student {
    SingleTon singleTon = SingleTon.getSingleTon();

    void setInfo(String name, int id) {
        singleTon.name = name;
        singleTon.id = id;
    }

    void printInfo() {
        System.out.println("이름 : " + singleTon.name);
        System.out.println("아이디: " + singleTon.id);
    }
}
