public class TeamBinarySearchTree {
    private class Node {
        Team team; 
        Node left, right; 

        Node(Team team) {
            this.team = team;
        }
    }

    private Node root; 

    public void insert(Team team) {
        root = insertRec(root, team);
    }

    private Node insertRec(Node node, Team team) {
        if (node == null) {
            return new Node(team); 
        }
        if (team.getPoints() > node.team.getPoints()) {
            node.left = insertRec(node.left, team); 
        } else {
            node.right = insertRec(node.right, team); 
        }

        return node;
    }

    public TeamLinkedList inorderTraversal() {
        TeamLinkedList result = new TeamLinkedList();
        inorderRec(root, result);
        return result; 
    }

    private void inorderRec(Node node, TeamLinkedList result) {
        if (node != null) {
            inorderRec(node.left, result); 
            result.add(node.team);         
            inorderRec(node.right, result); 
        }
    }

    public Team search(String name) {
        return searchRec(root, name);
    }

    private Team searchRec(Node node, String name) {
        if (node == null) {
            return null; 
        }
        if (node.team.getName().equalsIgnoreCase(name)) {
            return node.team; 
        }
        if (name.compareToIgnoreCase(node.team.getName()) < 0) {
            return searchRec(node.left, name); 
        } else {
            return searchRec(node.right, name); 
        }
    }

    public void display() {
        displayRec(root, 0);
    }

    private void displayRec(Node node, int depth) {
        if (node != null) {
            displayRec(node.right, depth + 1); 
            System.out.println("  ".repeat(depth) + node.team);
            displayRec(node.left, depth + 1); 
        }
    }
}