public class Team implements Comparable<Team> {
    private String name;
    private int played;
    private int wins;
    private int draws;
    private int losses;
    private int points;
    private int goalsFor;
    private int goalsAgainst;
    private Player[] players; 

    public Team(String name, int maxPlayers) {
        this.name = name;
        this.played = 0;
        this.wins = 0;
        this.draws = 0;
        this.losses = 0;
        this.points = 0;
        this.goalsFor = 0;
        this.goalsAgainst = 0;
        this.players = new Player[maxPlayers]; 
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

    public void addPlayer(String name, String position, int shirtNumber, int index) {
        if (index >= 0 && index < players.length) {
            players[index] = new Player(name, position, shirtNumber);
        }
    }

    public void displayPlayers() {
        System.out.println("\nTeam " + name);
        System.out.printf("%-20s %-15s %-5s\n", "Nama", "Posisi", "Nomor");
        for (Player player : players) {
            if (player != null) {
                System.out.println(player);
            }
        }
    }
    public Player findPlayerByName(String searchName) {
        Player[] sortedPlayers = new Player[players.length];
        int validPlayersCount = 0;

        for (Player player : players) {
            if (player != null) {
                sortedPlayers[validPlayersCount++] = player;
            }
        }


        for (int i = 0; i < validPlayersCount - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < validPlayersCount; j++) {
                if (sortedPlayers[j].getName().compareToIgnoreCase(sortedPlayers[minIndex].getName()) < 0) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                Player temp = sortedPlayers[i];
                sortedPlayers[i] = sortedPlayers[minIndex];
                sortedPlayers[minIndex] = temp;
            }
        }

        int left = 0;
        int right = validPlayersCount - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int compareResult = sortedPlayers[mid].getName().compareToIgnoreCase(searchName);

            if (compareResult == 0) {
                return sortedPlayers[mid]; 
            } else if (compareResult < 0) {
                left = mid + 1; 
            } else {
                right = mid - 1;
            }
        }

        return null; 
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