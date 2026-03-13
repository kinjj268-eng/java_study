package 배열실습;
//문제 1
//햄버거 3개와 음료 2개의 가격 입력 받아 (5개의 가격을 연속으로 입력 받음)
// 세트메뉴가격(햄버거 3개중 가장 싼 메뉴 가격 + 음료 두개중 싼 메뉴 가격) - 50(세트할인)

//문제 2
//8개의 정수를 입력받아 배열에 저장
//홀수는 홀수 배열에 나누어담고, 짝수는 짝수 배열에 나누어 담아서 출력하기

import java.util.Scanner;

public class ArrayEx {
    public static void main(String[] args) {
//        int[] prices = new int[5];
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("햄버거3개와 음료 2개 가격을 입력: ");
//        for(int i = 0; i < prices.length; i++){
//            prices[i] = sc.nextInt();
//        }
//        int minBg = prices[0];
//        for(int i = 1; i <3 ; i++){
//            if(minBg >prices[i]){
//                minBg = prices[i];
//            }
//        }
//        int minDr = prices[3];
//        if (minDr > prices[4]){
//            minDr = prices[4];
//        }
//        int setPrice = (minBg + minDr) -50;
//        System.out.println("세트: " + setPrice +"원");

        Scanner sc = new Scanner(System.in);
        int[] input = new int[8];
        int[] even = new int[8];
        int[] add = new int[8];


        int evenIdx = 0;
        int addIdx = 0;

        System.out.print("정수 입력: ");
        for(int i = 0;i< input.length;i++) {
            input[i] = sc.nextInt();

            if (input[i] % 2 == 0) {
                even[evenIdx++] = input[i];
            }else {
                add[addIdx++] = input[i];
            }}
        System.out.print("짝수: ");
        for(int i = 0; i <evenIdx; i++){
            System.out.print(even[i] + " ");
        }
        System.out.println();

        System.out.print("홀수: ");
        for (int i = 0; i <addIdx; i++){
            System.out.print(add[i] + " ");
        }


    }}
