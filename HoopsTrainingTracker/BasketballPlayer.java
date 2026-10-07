public class BasketballPlayer extends Athlete {
    private double verticalJumpCm;
    private boolean usesCreatine;

    public BasketballPlayer(String name, int age, double heightCm, double verticalJumpCm, boolean usesCreatine) {
        super(name, age, heightCm);
        this.verticalJumpCm = verticalJumpCm;
        this.usesCreatine = usesCreatine;
    }

    public double getVerticalJumpCm() { return verticalJumpCm; }
    
    @Override
    public String toString() {
        return "Player: " + name + " | Height: " + heightCm + "cm | Vert: " + verticalJumpCm + "cm | Creatine: " + (usesCreatine ? "Yes" : "No");
    }
}