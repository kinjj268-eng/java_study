package 더블for실습;

import java.util.Scanner;

public class DoubleForEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수입력: ");
        int num = sc.nextInt();

        for(int i=0; i<num ; i++){
            for (int j = 0; j< i+1;j++){
                System.out.printf("* ");
            }
            System.out.println();
        }
    }
}
