package lab2.num4;

class Cylinder extends Shape{
    private double height;
    private double radius;

    public Cylinder(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return Math.PI * height * Math.pow(radius, 2);
    }
}