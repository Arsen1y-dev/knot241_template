package lab9.num15;

public class Main {
    public static void main(String[] args) {
        for (Season season : Season.values()) {
            System.out.println(season + ": " + season.getWeather() + ", типичный праздник - " + season.getTypicalHoliday());
        }
    }
}