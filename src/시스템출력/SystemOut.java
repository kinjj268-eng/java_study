package 시스템출력;

public class SystemOut {
    public static void main(String[] args) {
        String name = "임유리";
        String addr = "경기도 평택시 장당동";
        char gender = 'W';
        int kor = 100, eng = 90, mat = 95;
       int total = kor + eng+ mat;
        double avg = (kor + eng + mat)/3;

        // 이스케이프 시퀀스 :  화면 출력 제어
        System.out.println("안녕\n");
        System.out.println(name + "님");
        System.out.println("딸기\r바나나\r키위");
        System.out.println("\r바나나\r키위");


        System.out.printf("이름: %s\n", name);
        System.out.printf("주소: %s\n", addr);
        System.out.printf("성별: %c\n", gender);
        System.out.printf("총점: %d\n", total);
        System.out.printf("평균: %.2f\n", avg);

        System.out.println("이름: " +name);
        System.out.println("주소: " +addr);
        System.out.println("성별: " + ((gender=='M' ? "남성" : "여성")));
        System.out.println("총점: " + total);
        System.out.println("평균: " +avg);

        System.out.println("JDK" + 17 + 8);
        System.out.println(17+8 +"JDK");
    }


}

