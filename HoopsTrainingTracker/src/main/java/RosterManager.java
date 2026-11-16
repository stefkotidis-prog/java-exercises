import java.util.ArrayList;

public class RosterManager {
    private ArrayList<BasketballPlayer> roster;

    public RosterManager() {
        this.roster = new ArrayList<>();
    }

    public void addPlayer(BasketballPlayer player) {
        roster.add(player);
        System.out.println("Added player: " + player.getName());
    }

    public void displayRoster() {
        System.out.println("\n--- TEAM ROSTER ---");
        if (roster.isEmpty()) {
            System.out.println("Roster is empty.");
            return;
        }
        for (int i = 0; i < roster.size(); i++) {
            System.out.println((i + 1) + ". " + roster.get(i).toString());
        }
    }
}