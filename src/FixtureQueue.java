public class FixtureQueue {
    private class Node {
        Fixture fixture; 
        Node next;       

        Node(Fixture fixture) {
            this.fixture = fixture;
            this.next = null;
        }
    }

    private Node front; 
    private Node rear;  

    public void enqueue(Fixture fixture) {
        Node newNode = new Node(fixture);
        if (rear == null) {
            front = rear = newNode; 
        } else {
            rear.next = newNode;   
            rear = newNode;
        }
    }

    public Fixture dequeue() {
        if (front == null) {
            return null; 
        }

        Fixture fixture = front.fixture; 
        front = front.next;

        if (front == null) {
            rear = null; 
        }

        return fixture; 
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void displayAllFixtures() {
        Node current = front;
        while (current != null) {
            System.out.print(current.fixture); 
            current = current.next;
        }
    }

    public int size() {
        int count = 0;
        Node current = front;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}