public class Archer extends Character {
    int arrowCount;
    String bowType;

    public Archer(String name, int age, boolean gender, int arrowCount, String bowType) {
        super(name, age, gender);
        System.out.println("Archer Created!");
        this.arrowCount = arrowCount;
        this.bowType = bowType;
    }

    @Override
    public void displayCharInfo() {
        super.displayCharInfo();
        System.out.println("Class: Archer");
        System.out.println("Bow Type: " + bowType);
        System.out.println("Arrows Left: " + arrowCount);
    }

    @Override
    public void attack() {
        if (arrowCount > 0) {
            System.out.println(name + " shoots an arrow with the " + bowType + "!");
            arrowCount--; // Mengurangi jumlah panah
        } else {
            System.out.println(name + " is out of arrows! Cannot attack!");
        }
    }

    public void attack(int numberOfArrows) {
        if (arrowCount >= numberOfArrows) {
            System.out.println(name + " fires " + numberOfArrows + " arrows at once! Critical Hit!");
            arrowCount -= numberOfArrows;
        } else {
            System.out.println(name + " doesn't have enough arrows for this skill!");
        }
    }

    public void reloadArrows(int amount) {
        arrowCount += amount;
        System.out.println(name + " reloaded " + amount + " arrows. Total: " + arrowCount);
    }
}