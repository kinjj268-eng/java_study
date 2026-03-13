package 은행만들기;
//정적멤버(필드): static 키워드 사용,클래스 생성시 생성되며, 객체 생성 시 생성되지 않음
//정적메서드: static 키워드 사용
//
public class Bank {

    private static int count = 0; //정적필드,Bank 클래서 생성 시 생성되는 값
    private  int account; //잔액을 누적하기 위한 인스턴스 필드 (객체생성시 만들어짐)
    private String bank; //은행이름, 인스턴스 필드

    public Bank(String bank, int account){
        this.bank = bank;
        this.account = account;
        count++; //생성자 호출 시 값을 증가 시킴
        System.out.println(bank + "은행에 계좌를 개설 합니다." + "잔액은 " + account+"입니다.");
    }
    public static int getCount(){ //정적 메서드, 클래스 생성 시 생성됨
        return count;
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
    //잔액 보기 기능 구현(은행이름과, 현재 잔액 보여줌)
    public void printAccount(){
        System.out.printf("%s 은행의 잔액은 %d 입니다.",bank, account);

    }
}
