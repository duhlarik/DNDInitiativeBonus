import java.util.Scanner;

public class DNDInitiativeBonus {

    public static void main(String[] args) {

        Scanner scan1 = new Scanner(System.in);
        String choice = "Y";
        Battle battle = new Battle();

        System.out.println("Enter the name of the battle: ");

        battle.setBattle(scan1.nextLine());

        System.out.println("Would you like to enter a player? (Type y or n)");

        choice = scan1.nextLine();

        while (choice.equalsIgnoreCase("y")) {

        }
    }
}
