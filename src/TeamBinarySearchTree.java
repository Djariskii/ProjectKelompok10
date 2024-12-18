import java.util.*;

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

    private Node insertRec(Node root, Team team) {
        if (root == null) return new Node(team);

        if (team.compareTo(root.team) < 0) {
            root.left = insertRec(root.left, team);
        } else {
            root.right = insertRec(root.right, team);
        }
        return root;
    }

    public List<Team> inorderTraversal() {
        List<Team> teamList = new ArrayList<>();
        inorderRec(root, teamList);
        return teamList;
    }

    private void inorderRec(Node root, List<Team> teamList) {
        if (root != null) {
            inorderRec(root.left, teamList);
            teamList.add(root.team);
            inorderRec(root.right, teamList);
        }
    }

    public Team search(String teamName) {
        return searchRec(root, teamName);
    }

    private Team searchRec(Node root, String teamName) {
        if (root == null) return null;

        if (root.team.getName().equalsIgnoreCase(teamName)) {
            return root.team;
        } else if (teamName.compareToIgnoreCase(root.team.getName()) < 0) {
            return searchRec(root.left, teamName);
        } else {
            return searchRec(root.right, teamName);
        }
    }
}
