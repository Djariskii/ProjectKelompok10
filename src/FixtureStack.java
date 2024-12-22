public class FixtureStack {
    private class Node {
        Fixture fixture; 
        Node next;       

        Node(Fixture fixture) {
            this.fixture = fixture;
            this.next = null;
        }
    }

    private Node top; 

    public void push(Fixture fixture) {
        Node newNode = new Node(fixture);
        newNode.next = top; 
        top = newNode;      
    }

    public Fixture pop() {
        if (top == null) {
            return null; 
        }

        Fixture fixture = top.fixture; 
        top = top.next;                
        return fixture;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void displayAllFixtures() {
        Node current = top;
        while (current != null) {
            System.out.println(current.fixture); 
            current = current.next;
        }
    }

    public int size() {
        int count = 0;
        Node current = top;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}