package lab2;

class Container {
    private double remainCapacity;

    public Container(double capacity) {
        this.remainCapacity = remainCapacity;

    }
    public void add(Shape shape) {
        double shapeVolume = shape.getVolume();

        if (shapeVolume <= remainCapacity){
            remainCapacity -= shapeVolume;
            System.out.println(remainCapacity);
        } else {
            System.out.println("Capacity exceeded");
        }

        }
        public double getremainCapacity() {
            return remainCapacity;
    }
}



