package 싱글톤;

public class SingleTonMain {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();

        student1.setInfo("임유리", 29);
        student2.printInfo();
    }
}
