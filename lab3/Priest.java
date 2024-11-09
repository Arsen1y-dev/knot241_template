package lab3;

class Priest extends Player {
    public Priest(String name, Race race) {
        super(name, 60, 60, race);
        setDamage(5);
        setDefense(3);
    }

    public void heal(Player target) {
        System.out.println(getName() + " лечит " + target.getName());
        target.increaseHealth(20);
    }
}