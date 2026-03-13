package 참조타입;
//기본타입 : 할당받은 메모리 공간에 값이 대입되는 방식(boolean,int,char,long ...)
//참조타입 : 할당받은 메모리공간에 객채의 주소가 대입되는 방식(배열, 열거 타입, 클래스,인터페이스)

//import java.util.Scanner;

public class RefMAin {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        String name1 = "임유리";
        String name2 = "임유리";
        String name3 = new String( "임유리");

        if(name1== name2){
            System.out.println("name1과 name2가 참조하는 문자열의 주소가 같음");
        }else{
            System.out.println("name1과 name2가 참조하는 문자열의 주소가 다름");
        }
        if(name1.equals(name3)){
            System.out.println("name1과 name2의 내용이 같음");
        }else {
            System.out.println("name1과 name2의 내용이 다름");
        }
    }
}
