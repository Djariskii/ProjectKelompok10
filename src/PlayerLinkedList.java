public class PlayerLinkedList {
    private class Node {
        Player player;
        Node next;

        Node(Player player) {
            this.player = player;
        }
    }
    private Node head;

    public void add(Player player) {
        Node newNode = new Node(player);
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

    public Player searchByName(String namePart) {
        Node current = head;
        while (current != null) {
            if (current.player.getName().toLowerCase().contains(namePart.toLowerCase())) {
                return current.player; 
            }
            current = current.next;
        }
        return null; 
    }

    public void displayAllPlayers() {
        Node current = head;
    
        System.out.println("+----------------------+----------------------+-----------------+");
        System.out.printf("| %-20s | %-20s | %-15s |%n", "Nama Pemain", "Posisi", "Nomor Punggung");
        System.out.println("+----------------------+----------------------+-----------------+");
    
        while (current != null) {
            Player player = current.player;
            System.out.printf("| %-20s | %-20s | %-15d |%n", player.getName(), player.getPosition(), player.jerseyNumber());
            current = current.next;
        }

        System.out.println("+----------------------+----------------------+-----------------+");
    }
    
}