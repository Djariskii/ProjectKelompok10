public class Player {
    private String name;
    private String position;
    private int jerseyNumber;

    public Player(String name, String position, int jerseyNumber) {
        this.name = name;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
    }
    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int jerseyNumber() {
        return jerseyNumber;
    }
    @Override
    public String toString() {
        return String.format("%-20s %-15s %2d", name, position, jerseyNumber);
    }
}