package 조건문1;

import java.util.Scanner;

public class ConditionMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.print("정수입력: ");
//        int num = sc.nextInt();
//        if(num > 100 ){
//            System.out.println(num + "은 100보다 큽니다.");
//        } else if (num < 100){
//            System.out.println(num + "은 100보다 작습니다");
//        } else {
//            System.out.println(num + "은 100과 같아요");
//        }
        while (true) {
            System.out.println("\n이름 입력: ");
            String name = sc.next();
            System.out.print("국어, 영어, 수학 점수 입력 :  ");
            int kor = sc.nextInt();
            int eng = sc.nextInt();
            int math = sc.nextInt();

            if (kor > 100 || eng > 100 || math > 100 || kor < 0 || eng < 0 || math < 0) {
                System.out.println("성적 입력 오류: 0~100점 사이로 입력해주세요.");
                return;
            }
            double avg = (kor + eng + math) /3.0;
            char grade;

            if (avg >= 90) {
                grade = 'A';
            } else if (avg >= 80) {
                grade = 'B';
            } else if (avg >= 70) {
                grade = 'C';
            } else if (avg >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            System.out.println("\n--- 결과 ---");
            System.out.println("이름: " + name);
            System.out.printf("평균: %.2f\n", avg);
            System.out.println("학점: " + grade);
        }
        }

}