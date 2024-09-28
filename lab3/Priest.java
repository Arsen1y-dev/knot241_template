package lab3;

class Priest extends Player {
    public Priest(String name) {
        super(name, 60, 60);
        setDamage(5);
        setDefense(3);
    }

    public void heal(Player target) {
        System.out.println(getName() + " лечит " + target.getName());
        target.increaseHealth(20);
    }
}
