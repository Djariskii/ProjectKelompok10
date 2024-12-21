public class PlayerLinkedList {
    private class Node {
        Player player;
        Node next;

        Node(Player player) {
            this.player = player;
        }
    }

    private Node head;

    // Menambahkan pemain ke LinkedList
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

    // Mencari pemain berdasarkan nama (case-insensitive, substring search)
    public Player searchByName(String namePart) {
        Node current = head;
        while (current != null) {
            // Pencarian substring case-insensitive
            if (current.player.getName().toLowerCase().contains(namePart.toLowerCase())) {
                return current.player; // Pemain ditemukan
            }
            current = current.next;
        }
        return null; // Pemain tidak ditemukan
    }

    // Menampilkan semua pemain
    public void displayAllPlayers() {
        Node current = head;
        while (current != null) {
            System.out.println(current.player);
            current = current.next;
        }
    }
}