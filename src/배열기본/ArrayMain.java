package 배열기본;
//자바의 배열은 동일한 데이터 타입이 연속적으로저장되는 자료구조
// 배열은 여러개의 값을 하나의 변수에 저장할 수 있도록 해주며, 인덱스를 사용해 각 요소에 접근(인덱스는 0부터 시작)
//자바의 배열은 기본 자료형과 개체타입(참조형) 모두 사용가능
// 자바의 배열은 객체로 취급되며, 기본적으로 Heap영역에 메모리가 할당됨



import java.util.Scanner;

public class ArrayMain {
    public static void main(String[] args) {
        //국어,영어,수학,과학, 코딩 성적을 입력받아 총점과 평균 구하기
        int[]score = new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.print("국어 영어 수학 과학 코딩 성적 입력: ");
        score[0] =sc.nextInt(); //국어, 배열의 인덱스는 0부터 시작함
        score[1] =sc.nextInt(); //영어
        score[2] =sc.nextInt(); //수핫
        score[3] =sc.nextInt(); //과학
        score[4] =sc.nextInt(); //코딩
        //총점구하기
        int total = 0;
//        for(int i = 0; i<score.length; i++){
//            total += score[i];
//        }

        for (int e:score){ //향상된 for문 , 이터러블 객체를 자동으로 순회, 배열내부의 값을 변경할수 없음,무조건 처음부터 끝까지 순회
            total += e;//total = total + e
        }
        double avg = (double) total /score.length;
        //각 과목의 성적과 총점 평균 출력
            System.out.printf("%3d %3d %3d %3d %3d %4d %4.2f\n",
                    score[0], score[1], score[2], score[3] ,score[4], total,avg );
        }
    }

