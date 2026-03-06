package 스위치문;
import java.util.Scanner;
public class SwitchMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("좋아하는 계절을 입력하세요: ");
        String season = sc.next().toUpperCase();
        switch(season){
            case "SPRING":
                System.out.println("꽃이 피는 봄이 조아요");
                break;
            case"SUMMER":
                System.out.println("휴가가 있는 여름이 조아요");
                break;
            case "AUTUMN":
                System.out.println("화창한 가을이 조아요");
                break;
            case "WINTER":
                System.out.println("눈 내리는 겨울이 조아요");
            default:
                System.out.println("계절 입력이 잘못되어따");
        }
        return;
    }
}
