import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- BAGIAN 1: INFO PEMAIN (USER) ---
        System.out.println("Welcome to Labit RPG!");

        System.out.printf("Insert your name: ");
        String name = scanner.nextLine();

        System.out.printf("Insert your age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer enter setelah nextInt

        if(age < 13) {
            System.out.println("Sorry, you must be at least 13 years old to play this game.");
            scanner.close();
            return;
        } else {
            System.out.printf("Hello %s, Let's start your adventure!\n", name);
        }

        // --- BAGIAN 2: PEMBUATAN KARAKTER DASAR ---
        System.out.println("\nLet's Make some Character!");

        // Input Nama Karakter (Dipakai semua kelas)
        System.out.printf("Insert Character Name: ");
        String nameChar = scanner.nextLine();

        // Input Umur Karakter (Dipakai semua kelas)
        System.out.printf("Insert Character Age: ");
        int ageChar = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer

        // Input Gender Karakter (Dipakai semua kelas)
        boolean gender = false;
        while (true) { // Loop sederhana agar user harus input yang benar
            System.out.printf("Insert Character Gender (M/F): ");
            String genderInput = scanner.nextLine();
            if(genderInput.equalsIgnoreCase("F")){
                gender = true; // Anggap True = Female sesuai kodemu
                break;
            } else if (genderInput.equalsIgnoreCase("M")) {
                gender = false; // Anggap False = Male
                break;
            } else {
                System.out.println("Invalid Input. Please type 'M' or 'F'.");
            }
        }

        // --- BAGIAN 3: PEMILIHAN KELAS ---
        System.out.println("\nSelect your Class:");
        System.out.println("1. Warrior");
        System.out.println("2. Mage");
        System.out.println("3. Archer");
        System.out.print("Enter the number of your choice: ");
        int classChoice = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer

        switch (classChoice){
            // ================= WARRIOR =================
            case 1:
                System.out.println("\n--- You have chosen Warrior class! ---");

                // Pilih Senjata
                System.out.println("=====Select Weapon=====");
                System.out.println("1. Sword");
                System.out.println("2. Axe");
                System.out.println("3. Hammer");
                System.out.print("Choice: ");
                int weaponChoice = scanner.nextInt();
                scanner.nextLine();

                String weapon = "Sword"; // Default
                if (weaponChoice == 2) weapon = "Axe";
                if (weaponChoice == 3) weapon = "Hammer";

                // Pilih Skin
                System.out.println("=====Select Skin=====");
                System.out.println("1. Knight");
                System.out.println("2. Barbarian");
                System.out.println("3. Gladiator");
                System.out.print("Choice: ");
                int skinChoice = scanner.nextInt();
                scanner.nextLine(); // Buffer

                String skin = "Knight"; // Default
                if (skinChoice == 2) skin = "Barbarian";
                if (skinChoice == 3) skin = "Gladiator";

                // Membuat Objek Warrior
                Warior warior = new Warior(nameChar, ageChar, gender, weapon, skin);

                System.out.println("\n===== CHARACTER CREATED =====");
                warior.displayCharInfo();

                // Tes Attack
                System.out.print("\nMake a Special Attack Name: ");
                String specialAttack = scanner.nextLine();
                warior.attack(specialAttack);
                break;

            // ================= MAGE =================
            case 2:
                System.out.println("\n--- You have chosen Mage class! ---");

                // Pilih Elemen
                System.out.println("=====Select Element=====");
                System.out.println("1. Fire");
                System.out.println("2. Ice");
                System.out.println("3. Lightning");
                System.out.print("Choice: ");
                int elementChoice = scanner.nextInt();
                scanner.nextLine();

                String element = "Fire"; // Default
                if (elementChoice == 2) element = "Ice";
                if (elementChoice == 3) element = "Lightning";

                // Input Mana
                System.out.printf("Enter starting Mana amount (e.g., 50 - 200): ");
                int mana = scanner.nextInt();
                scanner.nextLine(); // Buffer

                // Membuat Objek Mage
                Mage mage = new Mage(nameChar, ageChar, gender, element, mana);

                System.out.println("\n===== CHARACTER CREATED =====");
                mage.displayCharInfo();

                // Tes Attack
                System.out.println("\nTesting skills...");
                mage.attack(); // Basic attack
                mage.castUltimateSpell("Meteor Shower"); // Special attack
                break;

            // ================= ARCHER =================
            case 3:
                System.out.println("\n--- You have chosen Archer class! ---");

                // Pilih Jenis Busur
                System.out.println("=====Select Bow Type=====");
                System.out.println("1. Longbow");
                System.out.println("2. Crossbow");
                System.out.println("3. Elven Bow");
                System.out.print("Choice: ");
                int bowChoice = scanner.nextInt();
                scanner.nextLine();

                String bowType = "Longbow"; // Default
                if (bowChoice == 2) bowType = "Crossbow";
                if (bowChoice == 3) bowType = "Elven Bow";

                // Input Jumlah Panah
                System.out.printf("How many arrows do you bring? (e.g., 10 - 50): ");
                int arrowCount = scanner.nextInt();
                scanner.nextLine(); // Buffer

                // Membuat Objek Archer
                Archer archer = new Archer(nameChar, ageChar, gender, arrowCount, bowType);

                System.out.println("\n===== CHARACTER CREATED =====");
                archer.displayCharInfo();

                // Tes Attack
                System.out.println("\nTesting skills...");
                archer.attack(); // Nembak 1 kali
                archer.reloadArrows(5); // Isi ulang
                break;

            default:
                System.out.println("Invalid Class Choice!");
        }

        System.out.println("\nCharacter creation complete! Get ready for your adventure!");
        scanner.close();
    }
}