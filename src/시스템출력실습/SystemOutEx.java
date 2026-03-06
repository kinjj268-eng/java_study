package 시스템출력실습;

import javax.swing.*;

public class SystemOutEx {
    public static void main(String[] args) {
        System.out.println("======================");
        System.out.println("    나를 소개합니다!     ");
        System.out.println("=======================");
        String name="임유리";
        String age="29세";
        String hob="코딩,독서,운동";
        String com="\"안녕하세요, 잘 부탁드립니다.\"";
        System.out.println(name);
        System.out.println(age);
        System.out.println(hob);
        System.out.println(com);
        System.out.println("=====================");



        int amiPrice = 4500, amiCount = 2;
        int lattePrice = 5500, latteCount = 1;
        int cakePrice = 6800, cakeCount = 1;

        int total = (amiPrice * amiCount) + (lattePrice * latteCount) + (cakePrice * cakeCount);

        System.out.println("==================================");
        System.out.println("    ☕ JAVA CAFE 영수증    ");
        System.out.println("==================================");
        System.out.printf("%-10s %5d잔 %9s\n", "아메리카노", amiCount, "9,000원");
        System.out.printf("%-11s %5d잔 %9s\n", "카페라떼  ", latteCount, "5,500원");
        System.out.printf("%-10s %5d조각 %8s\n", "치즈케이크", cakeCount, "6,800원");
        System.out.println("-----------------------------------");
        System.out.printf("%-20s %1d %1s\n", "합계", total, "원");
        System.out.println("===================================");
        System.out.println("     감사합니다. 또 방문해주세요!");


        System.out.println("구구단");
        int dan = 3;
        for (int i = 1; i <= 9; i++) {
            System.out.printf("%d * %d = %2d\n", dan, i, dan * i);


        }
    }

}
