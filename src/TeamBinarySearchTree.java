public class TeamBinarySearchTree {
    private class Node {
        Team team;      
        Node left;        
        Node right;      
        Node(Team team) {
            this.team = team;
            this.left = null;
            this.right = null;
        }
    }
    private Node root;    
    public TeamBinarySearchTree() {
        this.root = null;
    }

    public void insert(Team team) {
        root = insertRec(root, team);
    }

    private Node insertRec(Node node, Team team) {
        if (node == null) {
            return new Node(team);
        }

        int comparison = compareTeams(team, node.team);

       if (comparison > 0) {
            node.left = insertRec(node.left, team);
        }
        else {
            node.right = insertRec(node.right, team);
        }

        return node;
    }
    private int compareTeams(Team team1, Team team2) {
        if (team1.getPoints() != team2.getPoints()) {
            return Integer.compare(team1.getPoints(), team2.getPoints());
        }
        if (team1.getGoalDifference() != team2.getGoalDifference()) {
            return Integer.compare(team1.getGoalDifference(), team2.getGoalDifference());
        }
        return team2.getName().compareToIgnoreCase(team1.getName());
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

        Team leftResult = searchRec(node.left, name);
        if (leftResult != null) {
            return leftResult;
        }
        return searchRec(node.right, name);
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
    public void display() {
        displayRec(root, 0);
    }
    private void displayRec(Node node, int level) {
        if (node != null) {
            displayRec(node.right, level + 1);
            System.out.println("  ".repeat(level) + node.team);
            displayRec(node.left, level + 1);
        }
    }
}