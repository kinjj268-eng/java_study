package 표준입력;

import java.util.Scanner;

public class SystemIn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 입력하세요: ");
        String name = sc.nextLine();
        System.out.print("주소를 입력하세요:");
        String addr = sc.nextLine();
        System.out.print("성별을 입력하세요:");
        char gender = sc.next().charAt(0);
        System.out.println("직업을 선택하세요");
        System.out.println("1.회사원 2.학생 3.주부 4.무직");
        System.out.print("번호입력:");
        int job=sc.nextInt();
        String jobName = switch (job) {
            case 1 -> "회사원";
            case 2 -> "학생";
            case 3 -> "주부";
            case 4 -> "무직";
            default -> "알 수 없음";
        };
            System.out.print("나이를 입력하세요:");
            int age = sc.nextInt();

            System.out.println("====회원 정보 출력====");
            System.out.println("이름: " + name);
            System.out.println("주소: " + addr);
            System.out.println("성별: " + gender);
            System.out.println("직업: " + jobName);
            System.out.println("나이: " + age);

        }
    }

