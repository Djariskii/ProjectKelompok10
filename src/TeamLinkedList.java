public class TeamLinkedList {
    private class Node {
        Team team;
        Node next;

        Node(Team team) {
            this.team = team;
            this.next = null;
        }
    }

    private Node head; 
    public void add(Team team) {
        Node newNode = new Node(team);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode; 
        }
    }

    public Team searchByName(String name) {
        Node current = head;
        while (current != null) {
            if (current.team.getName().equalsIgnoreCase(name)) {
                return current.team; 
            }
            current = current.next;
        }
        return null; 
    }

    public void sort() {
        if (head == null || head.next == null) return; 
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.team.getPoints() < current.next.team.getPoints()) {
                    Team temp = current.team;
                    current.team = current.next.team;
                    current.next.team = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped); 
    }

    public boolean remove(String name) {
        if (head == null) return false;

        if (head.team.getName().equalsIgnoreCase(name)) {
            head = head.next; 
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.team.getName().equalsIgnoreCase(name)) {
                current.next = current.next.next; 
                return true;
            }
            current = current.next;
        }

        return false;
    }
    public void displayAllTeams() {
        Node current = head;
        while (current != null) {
            System.out.println(current.team);
            current = current.next;
        }
    }

    public Iterator iterator() {
        return new Iterator(head);
    }

    class Iterator {
        private Node current;

        Iterator(Node start) {
            current = start;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Team next() {
            if (current == null) return null;
            Team team = current.team;
            current = current.next;
            return team;
        }
    }
}