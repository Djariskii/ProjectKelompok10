public class Fixture {
    public Team homeTeam;
    public Team awayTeam;

    public Fixture(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public void playMatch(int homeScore, int awayScore) {
        homeTeam.updateStats(homeScore, awayScore); // Perbarui statistik tim tuan rumah
        awayTeam.updateStats(awayScore, homeScore); // Perbarui statistik tim tamu
    }  

    public Team getHomeTeam() {
        return homeTeam;
    }
    
    public Team getAwayTeam() {
        return awayTeam;
    }    
    @Override
    public String toString() {
        return String.format("%s (Home) vs %s (Away)", homeTeam.getName(), awayTeam.getName());
    }
}
