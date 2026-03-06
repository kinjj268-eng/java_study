package For문;

import java.util.Scanner;

public class Formain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.print("정수입력:");
//        int num = sc.nextInt();

//        for(int i =0; i < num; i++){
//            System.out.println("* ");
//        }
//
//        System.out.println();

//        int i =0;
//        for(;;){
//            System.out.print("* ");
//            i++;
//            if(i == num) break;
//        }
//        System.out.println(); 문제 끝

//        int count = 0;
//        for (int i = 1; i <= num; i++) {
//
//            if (i % 5 == 0) {
//                System.out.print(i + " ");이것도
//                System.out.printf("%4d",1);이것도 가넝
//                count++;
//                if (count % 10 == 0) {
//                    System.out.println(); 문제 끝
//                }
//        for (int i = 1; i <= num * num; i++) {
//            System.out.printf("%3d", i);
//            if (i % num == 0) {
//                System.out.println();
//            }

        System.out.println("문자열입력 :      ");
        String str = sc.nextLine();
        for(int i = str.length()-1; i>=0;i--){
            System.out.print(str.charAt(i));
        }


    }
}