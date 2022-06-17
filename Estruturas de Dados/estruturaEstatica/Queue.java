package estruturaEstatica;

public class Queue<T> extends Array<T> {
    public Queue(int capacity) {
        super(capacity);
    }

    public void enqueue(T element) {
        super.add(element);
    }

    public T dequeue() {
        final int pos = 0;
        if (super.isEmpty()) {
            return null;
        }
        T element = super.structure[pos];
        super.remove(pos);
        return element;
    }

    public T peek() {
        if (super.isEmpty()) {
            return null;
        }
        return super.structure[0];
    }
}