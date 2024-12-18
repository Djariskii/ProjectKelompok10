import java.util.*;

public class TeamLinkedList {
    private class TeamNode {
        Team team;
        TeamNode next;

        TeamNode(Team team) {
            this.team = team;
            this.next = null;
        }
    }

    private TeamNode head;

    public TeamLinkedList() {
        head = null;
    }

    public void add(Team team) {
        TeamNode newNode = new TeamNode(team);
        if (head == null) {
            head = newNode;
        } else {
            TeamNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Team search(String teamName) {
        TeamNode current = head;
        while (current != null) {
            if (current.team.getName().equalsIgnoreCase(teamName)) {
                return current.team;
            }
            current = current.next;
        }
        return null;
    }

    public void sort() {
        head = mergeSort(head);
    }
    
    private TeamNode mergeSort(TeamNode node) {
        if (node == null || node.next == null) {
            return node;
        }
    
        TeamNode middle = getMiddle(node);
        TeamNode nextOfMiddle = middle.next;
        middle.next = null;
    
        TeamNode left = mergeSort(node);
        TeamNode right = mergeSort(nextOfMiddle);
    
        return sortedMerge(left, right);
    }
    
    private TeamNode sortedMerge(TeamNode a, TeamNode b) {
        TeamNode result;
    
        if (a == null) return b;
        if (b == null) return a;
    
        if (a.team.compareTo(b.team) < 0) { 
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }
        private TeamNode getMiddle(TeamNode head) {
        if (head == null) return head;
    
        TeamNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public Iterator<Team> iterator() {
        return new Iterator<Team>() {
            private TeamNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Team next() {
                Team team = current.team;
                current = current.next;
                return team;
            }
        };
    }
}