package 스위치실습1;

import java.util.Scanner;

public class SwitchEx1 {
    public static void main(String[] args) {

        System.out.println("숫자를 입력:");
        int x,y;
        char op;
        Scanner sc = new Scanner(System.in);
        x= sc.nextInt();
        op=sc.next().charAt(0);
        y=sc.nextInt();
        switch (op){
            case '+':
                System.out.printf("SUM: %d\n", x + y);
                break;
            case  '-':
                System.out.printf("SUB:%d\n", x - y);
                break;
            case '*':
                System.out.printf("MUL : %d\n", x * y);
                break;
            case '/' :
                System.out.printf("DIV : %d\n", x / y);
                break;
            default :
                System.out.println("조건식이 없습니다.");
        }
    }
}
