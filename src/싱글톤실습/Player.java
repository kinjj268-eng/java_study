package 싱글톤실습;

public class Player {
    GameSettings gameSettings = GameSettings.getInstance();


    void setInfo(String resolution, int volume, int difficulty) {
        gameSettings.resolution = resolution;
        gameSettings.volume = volume;
        gameSettings.difficulty = difficulty;
    }

    void printInfo() {
        System.out.println("해상도 : " + gameSettings.resolution);
        System.out.println("볼륨: " + gameSettings.volume);
        System.out.println("난이도: " + gameSettings.difficulty);
    }
}
