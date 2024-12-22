public class Fixture {
    private Team homeTeam;  
    private Team awayTeam;  
    private int homeScore;  
    private int awayScore;  
    private boolean played; 

    public Fixture(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = -1;
        this.awayScore = -1;
        this.played = false; 
    }

    public void playMatch(int homeScore, int awayScore) {
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.played = true;

        homeTeam.updateStats(homeScore, awayScore);
        awayTeam.updateStats(awayScore, homeScore);
    }

    public boolean isPlayed() {
        return played;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public String displayFixtureInfo() {
        if (played) {
            return homeTeam.getName() + " vs " + awayTeam.getName() +
                   " | Skor: " + homeScore + "-" + awayScore;
        } else {
            return homeTeam.getName() + " vs " + awayTeam.getName() + " | Belum dimainkan";
        }
    }
}