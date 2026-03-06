package 조건문실습;

import java.util.Scanner;

public class ConditionEx {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
//        System.out.println("시: 분");
//       int H = sc.nextInt();
//       int M =sc.nextInt();
//
//       if(M<45){
//           H--;
//           M = 60- (45-M);
//
//           if(H<0) {
//               H=23;
//           }
//       }
//        else{
//            M=M-45;
//       }
//        System.out.println(H+" " +M);
        System.out.println("키입력: ");
        double cm =sc.nextDouble();
        System.out.println("몸무게입력: ");
        double kg =sc.nextDouble();

        double m = cm /100;
        double bmi = kg / (m*m);
        System.out.printf("BMI는 %.2f 입니다.", bmi);
        if (bmi < 18.5) {
            System.out.println("저체중 입니다.");
        } else if (bmi < 23) {
            System.out.println("정상 체중 입니다.");
        } else if (bmi < 25) {
            System.out.println("과체중 입니다.");
        } else {
            System.out.println("비만 입니다.");
        }
    }
}


