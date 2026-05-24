import java.util.Scanner;
public class Menu{
    public static void main(String[]args){
        createObjects();
        Scanner input = new Scanner(System.in);
        int option = -1;
        while(option != 4){
            System.out.println("--Menu--");
            System.out.println("Press 1 to print all songs");
            System.out.println("Press 2 to print all singers");
            System.out.println("Press 3 to create a new singer");
            System.out.println("Press 4 to exit");
            option = input.nextInt();
            if (option == 1){
                Song.printSongs();
            }else if( option == 2){
                Singer.printSingers();
            }else if( option == 3){
                Singer.createSinger();
            }else if( option == 4){
                System.out.println("Exiting.");
            }else{
                System.out.println("Wrong input please try again or to exit press 4");
            }

        }
        input.close();
    }
    private static  void createObjects(){
            Singer s1 = new Singer("Tom");
            Singer s2 = new Singer("George");
            new Song (s1, "moi");
            new Song (s2,  "toi");
    }
    
}