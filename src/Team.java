class Team implements Comparable<Team> {
    private String name;
    private int played;
    private int wins;
    private int draws;
    private int losses;
    private int points;
    private int goalsFor;
    private int goalsAgainst;
    private List<Player> players;

    public Team(String name) {
        this.name = name;
        this.played = 0;
        this.wins = 0;
        this.draws = 0;
        this.losses = 0;
        this.points = 0;
        this.goalsFor = 0;
        this.goalsAgainst = 0;
        this.players = new ArrayList<>();
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
            points += 1;
        } else {
            losses++;
        }
    }
    public void addPlayer(String name, String position, int shirtNumber) {
        players.add(new Player(name, position, shirtNumber));
    }
    public void displayPlayers() {
        System.out.println("\nTeam " + name);
        System.out.printf("%-20s %-15s %-5s\n", "Nama", "Posisi", "Nomor");
        for (Player player : players) {
            System.out.println(player);
        }
    }
    @Override
    public int compareTo(Team other) {
        if (this.points != other.points) {
            return Integer.compare(other.points, this.points);
        }
        if (this.getGoalDifference() != other.getGoalDifference()) {
            return Integer.compare(other.getGoalDifference(), this.getGoalDifference());
        }
        if (this.goalsFor != other.goalsFor) {
            return Integer.compare(other.goalsFor, this.goalsFor);
        }
        return this.name.compareToIgnoreCase(other.name);
    }
    @Override
    public String toString() {
        return String.format(
            "%-25s %2d %5d %5d %5d %5d %5d %5d %5d",
            name, played, wins, draws, losses, goalsFor, goalsAgainst, getGoalDifference(), points
        );
    }
}