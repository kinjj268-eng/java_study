package 싱글톤실습;

public class GameMain {
    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();

        player1.setInfo("1920x1080", 20, 100);
        player2.printInfo();
    }
}
