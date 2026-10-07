import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RosterManager manager = new RosterManager();
        boolean running = true;

        System.out.println("Welcome to Hoops Training Tracker!");

        while (running) {
            System.out.println("\n1. Add Player");
            System.out.println("2. View Roster");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Age: ");
                    int age = scanner.nextInt();
                    System.out.print("Height (cm): ");
                    double height = scanner.nextDouble();
                    System.out.print("Vertical Jump (cm): ");
                    double vert = scanner.nextDouble();
                    System.out.print("Uses Creatine? (true/false): ");
                    boolean creatine = scanner.nextBoolean();
                    
                    manager.addPlayer(new BasketballPlayer(name, age, height, vert, creatine));
                    break;
                case 2:
                    manager.displayRoster();
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}