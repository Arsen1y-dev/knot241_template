package lab3;

class Mage extends Player {
    public Mage(String name, Race race) {
        super(name, 50, 50, race);
        setDamage(20);
        setDefense(5);
    }

    public void castSpell(Player target) {
        if (canAttack(target)) {
            System.out.println(getName() + " кастует заклинание на " + target.getName());
            target.decreaseHealth(getDamage());
        } else {
            System.out.println(getName() + " слишком далеко от " + target.getName());
        }
    }
}
