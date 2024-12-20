package lab9.num14;

public enum TrafficLight {
    RED("GREEN"),
    YELLOW("RED"),
    GREEN("YELLOW");

    private String nextLight;
    TrafficLight(String nextLight) {
        this.nextLight = nextLight;
    }
    public TrafficLight getNextLight() {
        return TrafficLight.valueOf(nextLight);
    }
}
