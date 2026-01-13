import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Labit RPG!");

        System.out.printf("Insert your name: ");
        String name = scanner.nextLine();

        System.out.printf("Insert your age: ");
        int age = scanner.nextInt();

        if(age < 13) {
            System.out.println("Sorry, you must be at least 13 years old to play this game.");
            scanner.close();
            return;
        } else {
            System.out.printf("Hello %s, age %d! Let's start your adventure!\n", name, age);
        }

        System.out.println("Let's Make some Charracter!");

        boolean continueCreation = true;
        do {
            System.out.println("Choose your class:");
            System.out.println("1. Warrior");
            System.out.println("2. Mage");
            System.out.println("3. Archer");
            System.out.printf("Enter the number of your choice: ");
            int classChoice = scanner.nextInt();
            scanner.nextLine();

            switch (classChoice) {
                case 1:
                    continueCreation = false;
                    System.out.println("You have chosen the Warrior class! Strong and brave!");
                    // Additional Warrior setup can go here
                    break;
                case 2:
                    continueCreation = false;
                    System.out.println("You have chosen the Mage class! Wise and powerful!");
                    // Additional Mage setup can go here
                    break;
                case 3:
                    continueCreation = false;
                    System.out.println("You have chosen the Archer class! Agile and precise!");
                    // Additional Archer setup can go here
                    break;
                default:
                    System.out.println("Invalid choice. Please restart the game and choose a valid class.");
                    break;
            }
        } while(continueCreation);

        System.out.println("Character creation complete! Get ready for your adventure!");

    }
}