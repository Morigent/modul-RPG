public class Mage extends Character {
    private String element;
    private int mana;

    public Mage(String name, int age, Gender gender, String element, int mana) {
        super(name, age, gender);
        System.out.println("Mage Created!");
        this.element = element;
        this.mana = mana;
    }

    @Override
    public void displayClassInfo() {
        System.out.println("Class  : Mage");
        System.out.println("Element: " + element);
        System.out.println("Mana   : " + mana);
    }

    @Override
    public void attack() {
        System.out.println(name + " shoots a " + element + " bolt!");
    }

    // Implementasi dari Interface SpecialAbility
    @Override
    public void useUltimate() {
        System.out.println(name + " casts ARMAGEDDON! The sky rains " + element + "!");
        mana = 0; // Menghabiskan mana
    }
}