package lab3;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Орк");
        Mage mage = new Mage("Гендальф");
        Priest priest = new Priest("Целитель");

        System.out.println(warrior);
        System.out.println(mage);
        System.out.println(priest);

        warrior.attack(mage);
        priest.heal(mage);
        mage.castSpell(warrior);
    }
}
