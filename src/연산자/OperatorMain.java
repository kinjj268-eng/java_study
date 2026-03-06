package 연산자;

import java.util.Scanner;

public class OperatorMain {
    public static void main(String[] args) {
        int x =10, y =4;
        System.out.println(x + y);
        System.out.println(x - y);
        System.out.println(x * y);
        System.out.println(x / y);
        System.out.println((double) x/y);
        System.out.println(x % y);

        int num1 = 10;
        System.out.println(num1 +=2); //num1 = num1 +2, 12
        System.out.println(num1 -=2); //num1 = num1 - 10
        System.out.println(num1 *=2); //20
        System.out.println(num1 /=2); //10
        System.out.println(num1 %=2); //0

        int num2 = 10;
        System.out.println(++num2); //선증가 후대입 ,11
        System.out.println(num2); //11

        int num3 =10, num4=20;
        System.out.println(num3 == num4); //false
        System.out.println(num3 != num4); //ture
        System.out.println(num3 > num4); //false
        System.out.println(num3 < num4); //ture
        System.out.println(num3 >= num4); //false
        System.out.println(num3 <= num4); //ture

        int num5 =10, num6 =20;
        System.out.println(num5 > 0 && num5 > num6); //false,산술연산자 >(우선순위) 논리연산자
        System.out.println(num5 > 0 || num5 > num6); //ture
        System.out.println(!(num5 > 0 || num5 > num6)); //false


        //3항연산자
        Scanner sc = new Scanner(System.in);
        System.out.println("나이입력: ");
        int age = sc.nextInt();
//        if(age >= 18){
//            System.out.println("당신은 성인입니다.");
//        }else{
//            System.out.println("당신은 미성년자입니다.");
//        }

        System.out.println("당신은 " + ((age>=18 ? "성인" : "미성년자") + "입니다."));
    }
}
