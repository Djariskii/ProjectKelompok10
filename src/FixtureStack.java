class FixtureStack {
    private class StackNode {
        Fixture fixture;
        StackNode next;

        StackNode(Fixture fixture) {
            this.fixture = fixture;
            this.next = null;
        }
    }

    private StackNode top;

    public void push(Fixture fixture) {
        StackNode newNode = new StackNode(fixture);
        newNode.next = top;
        top = newNode;
    }

    public Fixture pop() {
        if (top == null) return null;

        Fixture fixture = top.fixture;
        top = top.next;
        return fixture;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
 