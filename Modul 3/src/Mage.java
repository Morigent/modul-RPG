public class Mage extends Character {
    String element;
    int mana;

    public Mage(String name, int age, boolean gender, String element, int mana) {
        super(name, age, gender);
        System.out.println("Mage Created!");
        this.element = element;
        this.mana = mana;
    }

    @Override
    public void displayCharInfo() {
        super.displayCharInfo();
        System.out.println("Class: Mage");
        System.out.println("Element: " + element);
        System.out.println("Mana Points: " + mana);
    }

    @Override
    public void attack() {
        System.out.println(name + " casts a basic " + element + " bolt!");
    }

    public void castUltimateSpell(String spellName) {
        if (mana >= 20) {
            System.out.println(name + " chants ultimate spell: " + spellName + " causing massive " + element + " damage!");
            mana -= 20;
            System.out.println("(Mana remaining: " + mana + ")");
        } else {
            System.out.println(name + " doesn't have enough mana to cast " + spellName + "!");
        }
    }
}