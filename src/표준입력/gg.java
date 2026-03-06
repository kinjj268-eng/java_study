package 표준입력;

import java.util.Scanner;

public class gg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("이름입력: ");


        String name = sc.next();
        System.out.println("숫자를 입력하세요:   ");
        int lov = sc.nextInt();




        int hat = sc.nextInt();


        if(lov> hat){
            System.out.println("유리는 찬형이를 좋아합니다.");
        }else {
            System.out.println("그래도 유리는 찬형이를 좋아합니다");

        }

    }
}
