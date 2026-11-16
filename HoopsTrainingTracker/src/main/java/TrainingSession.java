public class TrainingSession {
    private String date;
    private String focusArea; // e.g., "Jump Mechanics", "Team Practice"
    private int durationMinutes;

    public TrainingSession(String date, String focusArea, int durationMinutes) {
        this.date = date;
        this.focusArea = focusArea;
        this.durationMinutes = durationMinutes;
    }

    @Override
    public String toString() {
        return "[" + date + "] " + focusArea + " (" + durationMinutes + " mins)";
    }
}