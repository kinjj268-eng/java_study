package 더블for문;

import java.util.Scanner;

public class DoubleMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("정수입력: ");
        int num = sc.nextInt();
//        for (int i =0; i <num; i++){
//            System.out.printf("|I=%2d|",i);
//            for (int j = 0; j <num;j++){
//                System.out.print("* ");
//            }
//            System.out.println();


        for (int i = 3; i <= 9; i++) {
            System.out.printf("[%d단]\n",i);
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%2d x %2d = %2d\n",i,j,i*j);
            }
//            System.out.println("-".repeat(count:32));
        }
    }
}