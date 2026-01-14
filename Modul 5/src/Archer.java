public class Archer extends Character {
    private int arrowCount;
    private String bowType;

    public Archer(String name, int age, Gender gender, int arrowCount, String bowType) {
        super(name, age, gender);
        System.out.println("Archer Created!");
        this.arrowCount = arrowCount;
        this.bowType = bowType;
    }

    @Override
    public void displayClassInfo() {
        System.out.println("Class  : Archer");
        System.out.println("Bow    : " + bowType);
        System.out.println("Arrows : " + arrowCount);
    }

    @Override
    public void attack() {
        if (arrowCount > 0) {
            System.out.println(name + " fires an arrow from " + bowType + "!");
            arrowCount--;
        } else {
            System.out.println(name + " is out of arrows!");
        }
    }

    public void reload() {
        arrowCount += 5;
        System.out.println("Reloading... Arrows: " + arrowCount);
    }

    // Implementasi dari Interface SpecialAbility
    @Override
    public void useUltimate() {
        System.out.println(name + " uses RAIN OF ARROWS! Covering the battlefield!");
        arrowCount = 0; // Menghabiskan panah
    }
}