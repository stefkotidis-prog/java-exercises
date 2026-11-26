public class Main {
    public static void main(String[] args) {
        CallParticipant[] participants = {
            new CallParticipant("Nikos",   "Wait, can you guys hear me now?", 2, 10),
            new CallParticipant("Maria",   "Nikos, you're STILL muted...", 4, 16),
            new CallParticipant("Giorgos", "Chill, I'll push my code in 5 minutes.", 3, 15),
            new CallParticipant("Elena",   "GitHub says your last commit was 3 weeks ago.", 6, 18),
            new CallParticipant("Kostas",  "[loud chewing noises] ...yeah I totally agree.", 5, 10),
            new CallParticipant("Alex",    "WAIT, IS THE DEADLINE TONIGHT?!", 7, 20)
        };

        for (int i = 0; i < participants.length; i++) {
            thread[i] = new Threasd(participants[i]);
        }

        for (int i = 0; i < participants.length; i++) {
            thread[i].start();
        }
    }
}
