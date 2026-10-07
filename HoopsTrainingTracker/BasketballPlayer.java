import java.util.ArrayList;

public class BasketballPlayer extends Athlete {
    private double verticalJumpCm;
    private boolean usesCreatine;
    private ArrayList<TrainingSession> sessions; // ΝΕΟ ΠΕΔΙΟ

    public BasketballPlayer(String name, int age, double heightCm, double verticalJumpCm, boolean usesCreatine) {
        super(name, age, heightCm);
        this.verticalJumpCm = verticalJumpCm;
        this.usesCreatine = usesCreatine;
        this.sessions = new ArrayList<>(); // ΝΕΟ
    }

    // ΝΕΕΣ ΜΕΘΟΔΟΙ
    public void addSession(TrainingSession session) {
        sessions.add(session);
    }

    public void printSessions() {
        System.out.println("Sessions for " + name + ":");
        for (TrainingSession s : sessions) {
            System.out.println(" - " + s.toString());
        }
    }
    
    public double getVerticalJumpCm() { return verticalJumpCm; }
    
    @Override
    public String toString() {
        return "Player: " + name + " | Height: " + heightCm + "cm | Vert: " + verticalJumpCm + "cm | Creatine: " + (usesCreatine ? "Yes" : "No");
    }
}