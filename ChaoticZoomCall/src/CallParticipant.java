public class CallParticipant extends Runnable{
    private String name;
    private String catchphrase;
    private int intervalSeconds;
    private int patienceSeconds;

    public CallParticipant(String name, String catchphrase, int intervalSeconds, int patienceSeconds){
        this.name = name;
        this.catchphrase = catchphrase;
        this.intervalSeconds = intervalSeconds;
        this.patienceSeconds = patienceSeconds;
    }

    
}
