public class Team {
    private String name; 
    private int played, wins, draws, losses, points, goalsFor, goalsAgainst;
    private PlayerLinkedList players; 

    public Team(String name) {
        this.name = name;
        this.played = 0;
        this.wins = 0;
        this.draws = 0;
        this.losses = 0;
        this.points = 0;
        this.goalsFor = 0;
        this.goalsAgainst = 0;
        this.players = new PlayerLinkedList(); 
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getGoalDifference() {
        return goalsFor - goalsAgainst;
    }

    public void updateStats(int goalsFor, int goalsAgainst) {
        this.goalsFor += goalsFor;
        this.goalsAgainst += goalsAgainst;
        played++;
        if (goalsFor > goalsAgainst) {
            wins++;
            points += 3;
        } else if (goalsFor == goalsAgainst) {
            draws++;
            points++;
        } else {
            losses++;
        }
    }

    public void addPlayer(Player player) {
        players.add(player); 
    }

    public Player searchPlayer(String name) {
        return players.searchByName(name); 
    }

    public void displayPlayers() {
        System.out.println("Pemain dari tim: " + name);
        players.displayAllPlayers(); 
    }

    @Override
    public String toString() {
        return String.format(
            "%-25s %2d %5d %5d %5d %5d %5d %5d %5d",
            name, played, wins, draws, losses, goalsFor, goalsAgainst, getGoalDifference(), points
        );
    }
}