public class Warrior extends Character {
    private String weapon;
    private String skin;

    public Warrior(String name, int age, Gender gender, String weapon, String skin) {
        super(name, age, gender);
        System.out.println("Warrior Created!");
        this.weapon = weapon;
        this.skin = skin;
    }

    @Override
    public void displayClassInfo() {
        System.out.println("Class  : Warrior");
        System.out.println("Weapon : " + weapon);
        System.out.println("Skin   : " + skin);
    }

    @Override
    public void attack() {
        System.out.println(name + " swings the " + weapon + " aggressively!");
    }

    // Implementasi dari Interface SpecialAbility
    @Override
    public void useUltimate() {
        System.out.println(name + " goes BERSERK! Damage doubled!");
    }
}