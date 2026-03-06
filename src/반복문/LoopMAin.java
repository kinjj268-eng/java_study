package 반복문;

import java.util.Scanner;

public class LoopMAin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수입력: ");
        int num = sc.nextInt();
        int sum = 0;
//        while (num>0){
//            sum += num;
//            num--;
//        for(int i = 1; i <= num; i++) {
//            sum += i;
//        }
        while (true){
            sum += num;
            num--;
            if(num == 0) break;
        }

            System.out.println("누적합계: " +sum);

    }
}
