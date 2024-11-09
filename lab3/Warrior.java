package lab3;

class Warrior extends Player {
    public Warrior(String name, Race race) {
        super(name, 100, 100, race);
        setDamage(15);
        setDefense(10);
    }

    public void attack(Player target) {
        if (canAttack(target)) {
            System.out.println(getName() + " атакует " + target.getName());
            target.decreaseHealth(getDamage());
        } else {
            System.out.println(getName() + " слишком далеко от " + target.getName());
        }
    }
}