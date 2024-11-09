package lab3;

interface Race {
    int getAttackBonus();
    int getDefenseBonus();
    int getHealBonus();
    int getSpellBonus();
}

class HumanRace implements Race {
    @Override
    public int getAttackBonus() { return 0; }
    @Override
    public int getDefenseBonus() { return 0; }
    @Override
    public int getHealBonus() { return 0; }
    @Override
    public int getSpellBonus() { return 0; }
}


class OrcRace implements Race {
    @Override
    public int getAttackBonus() { return 5; }
    @Override
    public int getDefenseBonus() { return 3; }
    @Override
    public int getHealBonus() { return 0; }
    @Override
    public int getSpellBonus() { return 0; }
}


class Player {
    protected String name;
    protected int currentHealth;
    protected int maxHealth;
    protected boolean isAlive;
    protected int x;
    protected int y;
    protected int damage;
    protected int defense;
    protected Race race;
    protected final int ATTACK_RADIUS = 10;

    public Player(String name, int currentHealth, int maxHealth, Race race) {
        this.name = name;
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.isAlive = currentHealth > 0;
        this.race = race;
    }

    protected void increaseHealth(int value) {
        if (!isAlive) {
            System.out.println("Игрок помер, здровье увеличить нельзя");
            return;
        }
        this.currentHealth = Math.min(this.currentHealth + value + race.getHealBonus(), this.maxHealth);
        System.out.println(this.name + " увеличил здоровье. Текущее здоровье: " + this.currentHealth);
    }

    protected void decreaseHealth(int value) {
        if (!isAlive) {
            System.out.println("Игрок мёртв");
            return;
        }
        int damageTaken = Math.max(0, value - this.defense - race.getDefenseBonus());  // Prevents negative damage
        this.currentHealth -= damageTaken;
        if (this.currentHealth <= 0) {
            this.currentHealth = 0;
            this.isAlive = false;
            System.out.println(this.name + " мёртв");
        } else {
            System.out.println(this.name + " получил урон. Текущее здоровье: " + this.currentHealth);
        }
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println(this.name + " переместился на позицию (" + x + ", " + y + ")");
    }

    public String getName() { return name; }
    public int getCurrentHealth() { return currentHealth; }
    public int getDamage() { return damage + race.getAttackBonus(); }
    public void setDamage(int damage) { this.damage = damage; }
    public int getDefense() { return defense; }
    public void setDefense(int defense) { this.defense = defense; }
    public boolean canAttack(Player target) {
        int distance = Math.max(Math.abs(this.x - target.x), Math.abs(this.y - target.y));
        return distance <= ATTACK_RADIUS;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Здоровье: " + currentHealth + "/" + maxHealth + ", Позиция: (" + x + ", " + y + "), Нация: " + race.getClass().getSimpleName();
    }

    public int getX() { return x; }
    public int getY() { return y; }
}