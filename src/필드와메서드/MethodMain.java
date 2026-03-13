package 필드와메서드;
//필드: 객체의 속성 값을 저장하는것(인스턴스 필드/ 지역필드/ 전역필드)
//메서드: 기능 /동작을 구현하는것, 자바는 클래스 기반의 언어이므로 모든 함수는 메서드 형태로 클래스 내부에 정의 되어야함
public class MethodMain {
    public static void main(String[] args) {
        Sample sample = new Sample(); //Sample 클래스로 sample 객체 생성
        System.out.println(sample.sum(10,20)); //객체이름, 메서드이름으로 호출됨
        sample.hello();
        System.out.println(sample.rtnHello());

// 뺄셈,곱셈,나눗셈을 하는 메서드를 만들고 결과를 반환받아 출력하기


    // 오버로딩: 동일한 이름의 메서드를 매개변수의 타입이나 개수로 구분해서 호출하는것
    //정수값이 3개인 경우에 대한 합을 구하기
        System.out.println(sample.sum(100,200,300));
        //문자열 3개를 입력받아 문자열 연결하는 함수
        //실수값 1개와 정수 1개를 입력 받아 더하는 함수
        // 문자열 1개와 정수값 1개 실수값 1개를 더하는 함수
    }
}




class Sample{
    int x = 100;
    int y = 200;
    //매개변수(x,y)가 있고, 결과를 정수 값으로 되돌려 주는 반환 타입이 있음.
    //접근 제한자가 없으면 default를 의미함
    int sum(int x,int y){
        return x+y;
    }
    int sum(int x,int y,int z){
        return x+y+z;
    }
    //반환값도 없고, 매개변수도 없는 메서드
    void hello(){
        System.out.println("안녕하세요");
    }
    //문자열을 반환하는 메서드
    String rtnHello(){
        return "안녕";
    }//정수값을 반환

}
