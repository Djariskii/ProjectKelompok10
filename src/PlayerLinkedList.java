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
    
        // Print table header with borders
        System.out.println("+----------------------+----------------------+-----------------+");
        System.out.printf("| %-20s | %-20s | %-15s |%n", "Nama Pemain", "Posisi", "Nomor Punggung");
        System.out.println("+----------------------+----------------------+-----------------+");
    
        // Loop through each player and print their details in a formatted way with borders
        while (current != null) {
            Player player = current.player;
            System.out.printf("| %-20s | %-20s | %-15d |%n", player.getName(), player.getPosition(), player.jerseyNumber());
            current = current.next;
        }
    
        // Print table bottom border
        System.out.println("+----------------------+----------------------+-----------------+");
    }
    
}