package 클래스와배열;

public class Student {
    int studentId; //학번
    String name;
    int[] score = new int[3];//국어 영어 수학
    int total;
    double avg;
    String addr;
    //이걸 인스턴스 필드라고 한다공? 내일 배운다공??
    //생성자만들기 : 클래스이름과 동일,반환타입이 없음,인스턴스 필드 초기화
    Student (int id,String name,int kor, int eng, int math){
        this.studentId = id;
        this.name = name;
        this.score[0] = kor;
        this.score[1] =eng;
        this.score[2] =math;
        this.total = kor + eng+math;
        this.avg = (double) total /3;
    }

    void printStudent() {
        System.out.printf("%4d %-6s %2d %2d %2d  %2d %2.2f\n ",
                studentId, name, score[0],score[1],score[2],total,avg);
    }
}
