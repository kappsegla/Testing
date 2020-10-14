package stack;

public class Stack {
    private int itemCount;
    private final int[] values = new int[2];

    public boolean isEmpty() {
        return itemCount == 0;
    }

    public void push(int i) {
        values[itemCount++] = i;
    }

    public int pop() {
        if( isEmpty() )
            throw new IllegalStateException();
        return values[--itemCount];
    }
}
