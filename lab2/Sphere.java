package lab2;

class Sphere extends Shape{
    private double radius;
    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return (4.0 / 3) * Math.PI * Math.pow(radius, 3);
    }
}