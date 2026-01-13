import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to " + Character.GAME_NAME); // Akses Final Static Variable

        // --- INPUT DATA DASAR ---
        System.out.print("Insert Name: ");
        String name = scanner.nextLine();

        System.out.print("Insert Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        if (age < 13) {
            System.out.println("Too young to play.");
            return;
        }

        // --- PENGGUNAAN ENUM ---
        Gender gender = null;
        while (gender == null) {
            System.out.print("Gender (M/F): ");
            String gInput = scanner.nextLine();
            if (gInput.equalsIgnoreCase("M")) gender = Gender.MALE;
            else if (gInput.equalsIgnoreCase("F")) gender = Gender.FEMALE;
            else System.out.println("Invalid input.");
        }

        // --- PILIH KELAS ---
        System.out.println("\nSelect Class:");
        System.out.println("1. Warrior");
        System.out.println("2. Mage");
        System.out.println("3. Archer");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        // --- POLYMORPHISM ---
        // Kita mendeklarasikan variabel sebagai 'Character' (Parent)
        // Tapi isinya nanti bisa berupa Warrior, Mage, atau Archer (Children)
        Character player = null;

        switch (choice) {
            case 1:
                player = new Warrior(name, age, gender, "Sword", "Knight");
                break;
            case 2:
                player = new Mage(name, age, gender, "Fire", 100);
                break;
            case 3:
                player = new Archer(name, age, gender, 10, "Longbow");
                break;
            default:
                System.out.println("Invalid class.");
                return;
        }

        // --- MENJALANKAN POLYMORPHISM ---
        System.out.println("\n===== HERO INFO =====");

        // 1. Memanggil method Final (sama untuk semua)
        player.displayBasicInfo();

        // 2. Memanggil method Abstract (beda output tergantung objek aslinya)
        player.displayClassInfo();

        System.out.println("\n===== BATTLE START =====");
        player.attack(); // Polymorphism: Memanggil attack milik subclass yang sesuai

        System.out.println("\n===== ULTIMATE SKILL =====");
        player.useUltimate(); // Dari Interface

        // 3. Casting object (Downcasting) jika butuh method spesifik
        //    Contoh: Archer punya reload(), tapi Character tidak punya.
        if (player instanceof Archer) {
            System.out.println("\n[Archer Specific Action]");
            ((Archer) player).reload();
        }

        scanner.close();
    }
}