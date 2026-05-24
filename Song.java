public class Song {

    protected static Song[] songs = new Song[10];
    private Singer singer;
    private String title;
    private int id; 
    private static int songCounter;

    public Song(Singer singer, String title){
        this.title = title;
        this.singer = singer;
        songs[songCounter] = this;
        songCounter++;
        this.id = songCounter;
    }

    public Singer getSinger(){
        return singer;
    }

    @Override
    public String toString(){
        return "Song: " + title ;
    }

    public static void printSongs(){
        for( int i =0 ; i < songs.length ; i++){
            if ( songs[i] != null ){
                System.out.println(songs[i]);
            }
        }
    }

}
