package lab3;

public class Player {
    private String name;
    private int currentHealth;
    private int maxHealth;
    private boolean isAlive;
    private int x;
    private int y;
    private int damage;
    private int defense;

    public Player(String name, int currentHealth, int maxHealth) {
        this.name = name;
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.isAlive = currentHealth > 0;
        this.damage = 0;
        this.defense = 0;
    }

    protected void increaseHealth(int value) {
        if (!isAlive) {
            System.out.println("Игрок помер, здровье увеличить нельзя");
            return;
        }
        this.currentHealth = Math.min(this.currentHealth + value, this.maxHealth);
        System.out.println(this.name + " увеличил здоровье. Текущее здоровье: " + this.currentHealth);
    }

    protected void decreaseHealth(int value) {
        if (!isAlive) {
            System.out.println("Игрок мёртв");
            return;
        }
        this.currentHealth -= (value - this.defense);
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

    public String getName() {
        return name;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Здоровье: " + currentHealth + "/" + maxHealth + ", Позиция: (" + x + ", " + y + ")";
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
        if (this.currentHealth > this.maxHealth) {
            this.currentHealth = this.maxHealth;
        }
        if (this.currentHealth <= 0) {
            this.isAlive = false;
            this.currentHealth = 0;
        } else {
            this.isAlive = true;
        }
    }
}