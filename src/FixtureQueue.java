import java.util.*;

public class FixtureQueue {
    private class QueueNode {
        Fixture fixture;
        QueueNode next;

        QueueNode(Fixture fixture) {
            this.fixture = fixture;
            this.next = null;
        }
    }

    private QueueNode front;
    private QueueNode rear;

    public void enqueue(Fixture fixture) {
        QueueNode newNode = new QueueNode(fixture);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public Fixture dequeue() {
        if (front == null) return null;

        Fixture fixture = front.fixture;
        front = front.next;

        if (front == null) rear = null;

        return fixture;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void displayAllFixtures() {
        QueueNode current = front;
        
        System.out.printf("+-------------------------------------------------------------+\n");
        System.out.printf("| %-18s | %-18s | %-17s |\n", "Home Team", "Away Team", "Tanggal");
        System.out.printf("+-------------------------------------------------------------+\n");
        
        int matchCounter = 0;  
        String date = "18/08";
        
        while (current != null) {
            if (matchCounter % 3 == 0 && matchCounter > 0) {
                date = getNextDate(date);  
            }
            System.out.printf("| %-18s | %-18s | %-17s |\n",
                    current.fixture.getHomeTeam().getName(),
                    current.fixture.getAwayTeam().getName(),
                    date);
            
            System.out.printf("+-------------------------------------------------------------+\n");
            
            current = current.next;

            matchCounter++;
        }
    }
    private String getNextDate(String currentDate) {
        String[] dateParts = currentDate.split("/");
        int day = Integer.parseInt(dateParts[0]);  
        int month = Integer.parseInt(dateParts[1]);  
        
        day++;  
        
        if (day > 31) {
            day = 1;
            month++;
            if (month > 12) {
                month = 1;
            }
        }
        
        return String.format("%02d/%02d", day, month);  
    }
    public List<Fixture> toList() {
        List<Fixture> fixtures = new ArrayList<>();
        QueueNode current = front;
        while (current != null) {
            fixtures.add(current.fixture);
            current = current.next;
        }
        return fixtures;
    }

    public void fromList(List<Fixture> fixtureList) {
        for (Fixture fixture : fixtureList) {
            enqueue(fixture);
        }
    }
}
