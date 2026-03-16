package 싱글톤실습;

public class GameSettings {
    String resolution;
    int volume;
    int difficulty;

    private static GameSettings instance = new GameSettings();

    private GameSettings() {
        resolution = "1920x1080";
        volume = 100;
        difficulty = 100;
    }

    static GameSettings getInstance() {
        return instance;
    }
}

