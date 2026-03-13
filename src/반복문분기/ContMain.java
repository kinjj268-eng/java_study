package 반복문분기;

import java.util.Scanner;

public class ContMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수입력: ");
        int num = sc.nextInt();
        //continue를 이용해 짝수만 출력
//        for (int i = 1; i <= num; i++){
//            if(i % 2 != 0) continue; //홀수일때는 반복문의 나머지 부분을 건너뜀
//            System.out.print(i+" ");
//        }

        //continue를 이용해 입력받은 수의 범위 이내의 5의 배수를 1줄에 10개씩 출력하기
        int count = 0;
        for(int i = 1;i<= num;i++){
            if(i % 5 != 0){
                continue;
        }
            System.out.printf("%4d",i);
            count++;
            if (count % 10 == 0 ){

                System.out.println();
            }
    }
}}
