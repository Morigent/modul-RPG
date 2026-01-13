public class Warior extends Character{
    String weapon;
    String skin;

    public Warior (String name, int age, boolean gender, String weapon, String skin) {
        System.out.println("Warior Created!");
        super(name, age, gender);
        this.weapon = weapon;
        this.skin = skin;
    }

    @Override
    public void displayCharInfo() {
        super.displayCharInfo();
        System.out.println("Class: Warior");
        System.out.println("Weapon: " + weapon);
        System.out.println("Skin: " + skin);
    }

    @Override
    public void attack() {
        System.out.println(name + " attacks with a " + weapon + "!");
    }

    public void attack(String specialMove) {
        System.out.println(name + " performs a special move: " + specialMove + " with a " + weapon + "!");
    }
}
