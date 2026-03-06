package Whlie문실습;

import java.util.Scanner;

public class WhileEx1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("이름: ");
        String name = sc.next();
        int age;
        while (true) {
            System.out.print("나이: ");
            age = sc.nextInt();
            if (age >= 0 && age <= 199) break;
            System.out.println("나이를 잘못 입력 하셨습니다. ");
        }
        String gender;
        while (true) {
            System.out.print("성별: ");
            gender = sc.next();
            if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F"))
                break;
            System.out.println("성별을 잘못 입력하셨습니다. ");




        }
    String jobName = " ";
        while(true) {
        System.out.println("직업을 선택하세요. 1.회사원 2.학생 3.주부 4.무직");
        System.out.print("번호입력:");
        int job = sc.nextInt();

        jobName = switch (job) {
            case 1 -> "회사원";
            case 2 -> "학생";
            case 3 -> "주부";
            case 4 -> "무직";
            default -> "잘못됨";
        };
        if (!jobName.equals("잘못됨")) break;
        System.out.println("직업을 잘못 입력하셨습니다.");
    }

            System.out.println("====회원 정보 출력====");
            System.out.println("이름: "+name);
            System.out.println("나이 "+age);
            System.out.println("성별: "+gender);
            System.out.println("직업: "+jobName);


}
    }