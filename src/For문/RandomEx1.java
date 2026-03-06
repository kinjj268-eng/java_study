package For문;

public class RandomEx1 {
    public static void main(String[] args) {
        int rand1, rand2;
        int cnt = 0;

        while(true) {
            cnt++;

            rand1 = (int) ((Math.random() * 6) + 1);
            rand2 = (int) ((Math.random() * 6) + 1);

            if(rand1 == rand2) {
                System.out.println("축하합니다! 더블이 나왔습니다.");
                System.out.printf("탈출 주사위 값: [%d, %d]\n", rand1, rand2);
                System.out.printf("총 %d 번만에 무인도를 탈출합니다!\n", cnt);
                break;
            } else {
                System.out.printf("[%d회차] 주사위: %d, %d (합: %d) - 탈출 실패!\n", cnt, rand1, rand2, (rand1 + rand2));
            }
        }
    }
    }

