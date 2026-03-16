package 싱글톤;

public class SingleTon {
    String name;
    int id;
    private static SingleTon singleTon = new SingleTon();

    private SingleTon() {
        name = "임유리";
        id = 100;
    }

    static SingleTon getSingleTon() {
        return singleTon;
    }
}

