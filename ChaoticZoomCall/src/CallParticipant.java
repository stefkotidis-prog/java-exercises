public class CallParticipant implements Runnable{
    private String name;
    private String catchphrase;
    private int intervalSeconds;
    private int patienceSeconds;
    private int hereFor;

    public CallParticipant(String name, String catchphrase, int intervalSeconds, int patienceSeconds){
        this.name = name;
        this.catchphrase = catchphrase;
        this.intervalSeconds = intervalSeconds;
        this.patienceSeconds = patienceSeconds;
        hereFor = 0;
    }

    @Override
    public void run() {
        try {
            while (hereFor < patienceSeconds) {
                Thread.sleep(intervalSeconds * 1000);
                System.out.println(name + catchphrase);
                hereFor += intervalSeconds;
            }
        } catch (InterruptedException e) {
            System.out.println(name + "lost connection! (Wi-Fi died)");
        } finally {
            System.out.println(name + "left the call");
        }
    }


}
