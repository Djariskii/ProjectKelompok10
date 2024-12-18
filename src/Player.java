public class Player {
    private String name;
    private String position;
    private int shirtNumber;

    public Player(String name, String position, int shirtNumber) {
        this.name = name;
        this.position = position;
        this.shirtNumber = shirtNumber;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-15s %d", name, position, shirtNumber);
    }
}