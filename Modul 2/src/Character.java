import java.util.Scanner;

public class Character {
    String name;
    int age;
    String heroClass;
    boolean gender; // true = female cuz female always right :D

    public void createChar (){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Insert Character name: ");
        name = scanner.nextLine();

        System.out.printf("Insert Character age: ");
        age = scanner.nextInt();
        scanner.nextLine();

        System.out.printf("Insert Character Gender (M/F): ");
        String genderInput = scanner.nextLine();
        if(genderInput.equalsIgnoreCase("F")){
            gender = true;
        } else if (genderInput.equalsIgnoreCase("M")) {
            gender = false;
        } else {
            System.out.println("Invalid Input");
        }


        System.out.println("====Select Class of Character====");
        System.out.println("1. Warrior");
        System.out.println("2. Mage");
        System.out.println("3. Archer");
        System.out.printf("Enter the number of your choice: ");
        int classChoice = scanner.nextInt();
        scanner.nextLine();
        switch (classChoice){
            case 1:
                heroClass = "Warrior";
                System.out.println("You have chosen the Warrior class! Strong and brave!");
                break;
            case 2:
                heroClass = "Mage";
                System.out.println("You have chosen the Mage class! Wise and powerful!");
                break;
            case 3:
                heroClass = "Archer";
                System.out.println("You have chosen the Archer class! Agile and precise!");
                break;
            default:
                System.out.println("Invalid choice. Please restart the game and choose a valid class.");
                break;
        }
        displayCharInfo();
    }

    public void displayCharInfo() {
        System.out.println("====Character Information====");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + getGender());
        System.out.println("Class: " + heroClass);
    }

    public String getGender() {
        return gender ? "Female": "Male";
    }
    //comment
}
