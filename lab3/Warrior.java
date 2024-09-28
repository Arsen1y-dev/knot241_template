package lab3;
/*
public class Warrior extends Player {

    public Warrior(String name, int currentHealth, int maxHealth) {
        super(name, currentHealth, maxHealth);
    }

    @Override
    protected void increaseHealth(int value) {
        int hp = getCurrentHealth();
        hp += value;
        setCurrentHealth(hp);
        System.out.println("Здоровье увеличено на" + value + ". HP: " + getCurrentHealth());

    }

    @Override
    protected void decreaseHealth(int value) {
        int hp = getCurrentHealth();
        hp -= value;
        setCurrentHealth(hp);
        System.out.println("Здоровье уменьшено на" + value + ". HP: " + getCurrentHealth());
    }

}

 */

class Warrior extends Player {
    public Warrior(String name) {
        super(name, 100, 100);
        setDamage(15);
        setDefense(10);
    }

    public void attack(Player target) {
        System.out.println(getName() + " атакует " + target.getName());
        target.decreaseHealth(getDamage());
    }
}