package lab2;

public class Main {
    public static void main(String[] args) {
        Container container = new Container(1000);

        Shape sphere = new Sphere(5);
        Shape cube = new Cube(3);
        Shape cylinder = new Cylinder(2, 10);

        container.add(sphere);
        container.add(cube);
        container.add(cylinder);
    }
}