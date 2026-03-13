package 테레비젼;
//

import java.util.Scanner;

public class TvMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Television[] tvs = new Television[5];
        for(int i = 0; i<5; i++){
            tvs[i] = new Television();
        }
        // 2. 조작할 TV 선택 (예: 1번 TV)
        System.out.print("조작할 TV 번호를 선택하세요 (1~5): ");
        int choice = sc.nextInt() - 1; // 인덱스는 0부터 시작하니까요!
        Television targetTv = tvs[choice];

        // 3. 메뉴 만들기 (반복문 사용)
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n--- [ " + (choice + 1) + "번 TV 조작 메뉴 ] ---");
            System.out.println("1.전원 2.볼륨조절 3.채널변경 4.상태보기 5.종료");
            System.out.print("선택: ");
            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    // 현재 전원이 꺼져있으면 켜고, 켜져있으면 끄기
                    targetTv.setPower(!targetTv.getPower());
                    break;
                case 2:
                    System.out.print("변경할 볼륨: ");
                    targetTv.setVolume(sc.nextInt());
                    break;
                case 3:
                    System.out.print("변경할 채널: ");
                    targetTv.setChannel(sc.nextInt());
                    break;
                case 4:
                    targetTv.printTV();
                    break;
                case 5:
                    System.out.println("조작을 종료합니다.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}