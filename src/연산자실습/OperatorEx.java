package 연산자실습;

import java.util.Scanner;

public class OperatorEx {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("년도를 입력하세요");
            int year = in.nextInt();
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                System.out.println(year + "년은 윤년입니다.");
                break;
            } else {
                System.out.println("윤년이 아닙니다.");
            }
        }


        System.out.println("정수를 입력 하세요: ");
        int num = in.nextInt();
        int a = num/100;
        int b = (num % 100) /10;
        int c = num%10;
        int max = Math.max(a, Math.max(b, c));

        System.out.println("가장 큰 수는: " + max);



        int val1 = 5, val2 = 5, val3 = 5;
        int rst1=val1 + val2 * val3;//30
        int rst2=(val1+val2)*val3;//50
        int rst3=val1 + (++val2)*val3;//35


    }}
