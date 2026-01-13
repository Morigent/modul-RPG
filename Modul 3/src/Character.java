import java.util.Scanner;

public class Character {
    String name;
    int age;
    boolean gender; // true = female cuz female always right :D

    public Character(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void displayCharInfo() {
        System.out.println("====Character Information====");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + getGender());
    }

    public String getGender() {
        return gender ? "Female": "Male";
    }

    public void attack() {
        System.out.println(name + " is attacking!");
    }
}
