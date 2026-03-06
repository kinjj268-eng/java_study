package 변수와자료형;

import java.util.Scanner;

public class DataTypeMain {
    public static void main(String[] args) {
   int age=29;
   String name = "임유리";
   String phone = "010-9956-6770";
   boolean isAdult = true;
        System.out.println("나이: " +age);
        System.out.println("이름: " +name);
        System.out.println("전화번호: " +phone);
        System.out.println("성인여부: " + isAdult);

        char gender = '해';
        System.out.println((int)gender);
        String addr = "경기도 평택시 장당동";

//        final double TAX_RATE = 0.10;
//        Scanner sc = new Scanner(System.in);
//        System.out.print("수입을 입력 하세요 : ");
//        int income = sc.nextInt();
//        System.out.println("당신의 내야 할 세금은 " + (income * TAX_RATE) + "입니다.");

        int kor=99, eng= 88, mat =77;
        double avg= (kor+eng+mat)/3;
        System.out.println(avg);

        String val1 = "0100.234" ;
        System.out.println(300+Double.parseDouble(val1));


    }

}