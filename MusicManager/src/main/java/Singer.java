import java.util.Scanner;
public class Singer {
    private String name;
    private int id;
    protected static Singer [] singerArray = new Singer [10];
    private static int singerCounter = 0;

    public Singer(String name){
        this.name = name;
        singerArray[singerCounter] = this;
        singerCounter++;
        this.id = singerCounter;

    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return "Singer: " + name + " Id: " + id;
    }

    public void printSong(){
        for ( int i = 0; i< Song.songs.length; i++){
            if (Song.songs[i] != null){
                if (Song.songs[i].getSinger().getName().equals(this.name)){
                    System.out.println(Song.songs[i]);
                }
            }
        }
        
    }

    public static void printSingers(){
        for(int i = 0 ; i < singerArray.length ; i++){
            if ( singerArray[i] != null){
                System.out.println(singerArray[i]);
                singerArray[i].printSong();
            }
        }
    }

    public static void createSinger(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter new singer's name: ");
        String name = input.next();
        Singer singer = new Singer(name);
        System.out.println(singer.getName() + " has been added to the list.");
    }

}
