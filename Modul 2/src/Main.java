import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Character playerCharacter = new Character();

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
            System.out.printf("Hello %s, Let's start your adventure!\n", name);
        }

        System.out.println("Let's Make some Charracter!");

        playerCharacter.createChar();

        System.out.println("Character creation complete! Get ready for your adventure!");
    }
}