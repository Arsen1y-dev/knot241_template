package lab2.num4;

class Container {
    private double remainingCapacity;

    public Container(double capacity) {
        this.remainingCapacity = capacity;
    }

    public boolean add(Shape shape) {
        double shapeVolume = shape.getVolume();

        if (shapeVolume <= remainingCapacity) {
            remainingCapacity -= shapeVolume;
            System.out.println("Фигура добавлена. Оставшийся объем: " + remainingCapacity);
            return true;
        } else {
            System.out.println("Превышен объем. Невозможно добавить фигуру.");
            return false;
        }
    }

    public double getRemainingCapacity() {
        return remainingCapacity;
    }
}


