package 클래스와배열;

import java.util.Scanner;

public class ClassAttay {
    public static void main(String[] args) {
        Student[] students = new Student[5]; //Student 클래스 타입의 배열을 5개 생성
        Scanner sc = new Scanner(System.in);

        for(int i=0;i<students.length;i++){
            System.out.printf("[%d 번째 학생 정보 입력 ]\n",i +1);
            System.out.print("학번: ");
            int id = sc.nextInt();
            sc.nextLine();//버퍼비우기
            System.out.print("이름: ");
            String name = sc.nextLine();
            System.out.print("국어: ");
            int kor = sc.nextInt();
            System.out.print("영어: ");
            int eng = sc.nextInt();
            System.out.print("수학: ");
            int math = sc.nextInt();
            //Student 클래스에 대한 객체생성 후 배열에 대입
            students[i] = new Student(id,name,kor,eng,math);
        }
        System.out.println("-".repeat(40));
        System.out.println("학번 이름 국어 영어 수학 총점 평균");
        System.out.println("-".repeat(40));
        for(Student e: students) e.printStudent();
        System.out.println("-".repeat(40));
    }
}
