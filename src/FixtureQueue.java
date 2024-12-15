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
}