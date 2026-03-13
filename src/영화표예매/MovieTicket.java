package 영화표예매; // '영화표예매'라는 폴더에 살고 있어요

import java.util.Scanner; // 입력받는 도구를 가져옵니다

public class MovieTicket {
    // [필드] 객체의 상태값 (Heap 영역에 저장됨)
    private final int[] seat = new int[10]; // 좌석 10개를 만듭니다 (0:빈자리, 1:예약됨)
    private final int price; // 영화표 가격을 저장할 공간 (private이라 밖에서 함부로 못 고쳐요)

    // 입력용 스캐너 (내부에서만 쓰니까 private)
    private final Scanner sc = new Scanner(System.in);

    // [생성자] 객체가 만들어질 때 딱 한 번 실행!
    public MovieTicket(int price){
        this.price = price; // 밖에서 정해준 가격(예: 12000)을 내부 price에 저장해요
    }

    // [메서드] 현재 좌석 상태를 [ ][V] 모양으로 그려주는 기능
    public void printSeat(){
        for(int e : seat){ // 좌석 10개를 하나씩 꺼내서 검사합니다
            // 만약(if) 자리가 0이면 [ ], 아니면(else) [V]를 출력해라!
            System.out.print(e == 0 ? "[ ]" : "[V]");
        }
        System.out.println(); // 줄바꿈
    }

    // [메서드] 번호가 1~10 사이가 맞는지 체크하는 비밀 기능 (private)
    private boolean isValidPos(int seatPos){
        // 번호가 1보다 크고, 좌석 개수(10)보다 작거나 같으면 '참(true)'!
        return seatPos >= 1 && seatPos <= seat.length;
    }

    // [메서드] 예매하기 버튼
    public void selectSeat(){
        printSeat(); // 일단 현재 자리가 어디 남았는지 보여주고
        System.out.print("예매할 좌석 번호(1~10): ");

        int seatPos = sc.nextInt(); // 손님이 번호를 입력하면

        // 만약(if) 번호를 잘못 입력했다면(!는 반대라는 뜻)
        if(!isValidPos(seatPos)){
            System.out.println("좌석번호는 1~10 사이로 입력하세요");
            return; // 메서드 바로 종료! (잘못된 주문은 안 받아요)
        }

        // 만약(if) 그 자리가 0(빈자리)이라면?
        if (seat[seatPos - 1] == 0) { // 배열은 0부터 시작하니까 -1을 해줘요
            seat[seatPos - 1] = 1; // 자리를 1로 바꿔서 '예약됨' 표시!
            System.out.println(seatPos + "번 좌석 예매 완료.");
            printSeat(); // 바뀐 상태 다시 보여주기
        } else {
            System.out.println("이미 예약된 좌석입니다. 다른 좌석을 선택하세요.");
        }
    }

    // [메서드] 예매 취소하기 버튼
    public void cancelSeat() {
        printSeat();
        System.out.print("취소할 좌석 번호(1~10): ");

        int seatPos = sc.nextInt();

        // 번호가 올바른지 먼저 확인
        if (!isValidPos(seatPos)) {
            System.out.println("좌석 번호는 1~10 사이로 입력하세요.");
            return;
        }

        // 만약(if) 그 자리가 1(예약된 상태)이라면?
        if (seat[seatPos - 1] == 1) {
            seat[seatPos - 1] = 0; // 다시 0(빈자리)으로 돌려놓기!
            System.out.println(seatPos + "번 좌석 예매 취소 완료.");
            printSeat();
        } else {
            System.out.println("해당 좌석은 예약되어 있지 않습니다.");
        }
    }

    // [메서드] 총 얼마 팔았는지 계산기
    public int totalAmount() {
        int cnt = 0; // 예매된 좌석 개수를 셀 변수
        for (int e : seat) {
            if (e == 1) cnt++; // 1(예약됨)을 발견할 때마다 1씩 더해요
        }
        return cnt * price; // (총 좌석 수 * 가격)을 계산해서 돌려줍니다
    }
}