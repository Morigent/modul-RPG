import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- JAVA COLLECTIONS ---
        // Menggunakan ArrayList untuk menyimpan tim (Party) hero
        List<Character> party = new ArrayList<>();

        System.out.println("Welcome to " + Character.GAME_NAME);

        boolean addMore = true;

        while (addMore) {
            System.out.println("\n--- Create New Hero ---");

            try {
                // --- INPUT DATA DASAR ---
                System.out.print("Insert Name: ");
                String name = scanner.nextLine();

                // --- EXCEPTION HANDLING (Input Mismatch) ---
                System.out.print("Insert Age: ");
                // Jika user mengetik huruf, baris ini akan melempar InputMismatchException
                int age = scanner.nextInt();
                scanner.nextLine(); // Konsumsi newline

                // --- EXCEPTION HANDLING (Custom Exception) ---
                if (age < 13) {
                    throw new InvalidGameRuleException("Player is too young to play! Minimum age is 13.");
                }

                // --- PENGGUNAAN ENUM ---
                Gender gender = null;
                while (gender == null) {
                    System.out.print("Gender (M/F): ");
                    String gInput = scanner.nextLine();
                    if (gInput.equalsIgnoreCase("M")) gender = Gender.MALE;
                    else if (gInput.equalsIgnoreCase("F")) gender = Gender.FEMALE;
                    else System.out.println("Invalid input. Please type M or F.");
                }

                // --- PILIH KELAS ---
                System.out.println("Select Class:");
                System.out.println("1. Warrior");
                System.out.println("2. Mage");
                System.out.println("3. Archer");
                System.out.print("Choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Konsumsi newline

                Character newHero = null;

                switch (choice) {
                    case 1:
                        newHero = new Warrior(name, age, gender, "Sword", "Knight");
                        break;
                    case 2:
                        newHero = new Mage(name, age, gender, "Fire", 100);
                        break;
                    case 3:
                        newHero = new Archer(name, age, gender, 10, "Longbow");
                        break;
                    default:
                        // Melempar exception jika pilihan salah
                        throw new InvalidGameRuleException("Invalid class selection (Must be 1-3).");
                }

                // Menambahkan hero ke dalam LIST (Collection)
                party.add(newHero);
                System.out.println("Hero " + name + " added to the party!");

            } catch (InputMismatchException e) {
                // Menangkap error jika user memasukkan huruf saat diminta angka
                System.out.println("ERROR: Input must be a number! Please try again.");
                scanner.nextLine(); // Membersihkan buffer scanner agar tidak looping infinite
            } catch (InvalidGameRuleException e) {
                // Menangkap error custom (aturan game)
                System.out.println("GAME RULE ERROR: " + e.getMessage());
            } catch (Exception e) {
                // Menangkap error umum lainnya
                System.out.println("UNKNOWN ERROR: " + e.getMessage());
            }

            // Opsi menambah hero lagi
            System.out.print("\nAdd another hero? (y/n): ");
            String ans = scanner.nextLine();
            if (!ans.equalsIgnoreCase("y")) {
                addMore = false;
            }
        }

        // --- MENAMPILKAN DATA DARI COLLECTIONS ---
        System.out.println("\n===== PARTY STATUS =====");
        if (party.isEmpty()) {
            System.out.println("No heroes created. Game Over.");
        } else {
            System.out.println("Total Heroes: " + party.size());

            // Looping melalui List (ForEach Loop)
            for (Character hero : party) {
                System.out.println("-------------------------");
                hero.displayBasicInfo(); // Polymorphism
                hero.displayClassInfo();

                System.out.println(">> Action:");
                hero.attack();
                hero.useUltimate();

                // Downcasting contoh
                if (hero instanceof Archer) {
                    ((Archer) hero).reload();
                }
            }
        }

        scanner.close();
    }
}