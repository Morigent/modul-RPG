public abstract class Character implements SpecialAbility {
    protected String name;
    protected int age;
    protected Gender gender;

    // FINAL VARIABLE: Konstanta yang tidak bisa diubah
    public static final String GAME_NAME = "Labit RPG v2.0";

    public Character(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // FINAL METHOD: Tidak bisa di-override oleh anak kelas
    public final void displayBasicInfo() {
        System.out.println("==== " + GAME_NAME + " ====");
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("Gender : " + gender); // Otomatis memanggil toString Enum
    }

    // ABSTRACT METHOD: Wajib diisi (override) oleh anak kelas
    public abstract void attack();

    // Abstract method untuk info spesifik tiap kelas
    public abstract void displayClassInfo();
}