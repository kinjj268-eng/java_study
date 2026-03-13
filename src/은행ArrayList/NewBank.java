package 은행ArrayList;

//ArrayList 활용
public class NewBank {
    private static int count = 0;
    private  int id; //계좌 식별용 번호
    private int account; //잔액
    private String bank; //은행 이름
    private  String name; // 예금주이름

    public NewBank(String bank,String name,int account){
        this.bank = bank;
        this.name = name;
        this.account = account;
        count++; //게좌 생성개수
        id = count+10000; //계좌 식별용번호는 자동생성
    }
    public static int getCount(){ //계좌 생성개수, 클래스 메서드
        return count;
    }
    public int getId() {
        return id;
    }

//예금 기능 구현: 매개변수 값을 전달받아 account에 누적
public void deposit(final int money){
    account += money; //현재 잔액에 입금액을 누적
    System.out.println(money + "를 입금했음");
}
//출금 기능 구현: 매개변수로 값을 전달 받아 account의 값을 차감하는 기능 구현(출금 금액이 예금 금액보다 작거나 같아야함)
public void withdraw(final int money){
    if(money <= account){
        account -= money;
    }else {
        System.out.println("잔액이 부족 합니다.");
    }
}
//잔액 보기 기능 구현(은행이름과, 현재 잔액 보여줌)a
public void printAccount(){
    System.out.println("은행명: " + bank);
    System.out.println("예금주: "+ name);
    System.out.println("계좌번호: " + id);
    System.out.println("잔액: "+ account);

}
}
