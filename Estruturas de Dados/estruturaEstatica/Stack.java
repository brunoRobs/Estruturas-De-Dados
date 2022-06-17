package estruturaEstatica;

public class Stack<T> extends Array<T> {
    public Stack(int capacity) {
        super(capacity);
    }

    public void push(T element) {
        super.add(element);
    }

    public T pop() {
        if (super.isEmpty()) {
            return null;
        }
        T element = super.structure[super.size - 1];
        super.size--;
        return element;
    }

    public T top() {
        if (super.isEmpty()) {
            return null;
        }
        return super.structure[this.size - 1];
    }
}