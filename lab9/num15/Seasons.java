package lab9.num15;

enum Season {
    SPRING("Тепло", "День фрилансера в России"),
    SUMMER("Жарко", "День балалайки"),
    AUTUMN("Не поймёшь", "День работника налоговых органов Российской федерации"),
    WINTER("Холодно", "День работников ЗАГСа в России");

    private final String weather;
    private final String typicalHoliday;

    Season(String weather, String typicalHoliday) {
        this.weather = weather;
        this.typicalHoliday = typicalHoliday;
    }

    public String getWeather() {
        return weather;
    }

    public String getTypicalHoliday() {
        return typicalHoliday;
    }
}
