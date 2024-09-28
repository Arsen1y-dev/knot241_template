package lab3;

class Mage extends Player {
    public Mage(String name) {
        super(name, 50, 50);
        setDamage(20);
        setDefense(5);
    }

    public void castSpell(Player target) {
        System.out.println(getName() + " кастует заклинание на " + target.getName());
        target.decreaseHealth(getDamage());
    }
}