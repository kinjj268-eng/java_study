package 비트연산자1;

public class BitOperator {
    public static void main(String[] args) {
        int x =10, y=12;
        System.out.println(x&y); //비트 AND : 듀개의 모두 1이면 1, 8
        System.out.println(x|y); //비트 OR : 둘중 하나만 1이면 1, 14
        System.out.println(x^y); //비트XOR : 비트 값이 다른 경우에 1,6
        System.out.println(~x); //비트NOT : 각 비트를 반전 시킴, -11
        System.out.println(x<<1); //비트 shift :20
        System.out.println(x>>1); //5
    }
}
