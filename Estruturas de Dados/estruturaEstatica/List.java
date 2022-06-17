package estruturaEstatica;

public class List<T> extends Array<T> {
    public List(int capacity) {
        super(capacity);
    }

    public boolean add(T element) {
        return super.add(element);
    }

    public boolean add(int position, T element) {
        return super.add(position, element);
    }

    public T search(int position) {
        if (!(position >= 0 && position < super.size)) {
            throw new IllegalArgumentException("Invalid position.");
        }
        return super.structure[position];
    }

    public int search(T element) {
        for (int i = 0; i < super.size; i++) {
            if (super.structure[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public void remove(T element) {
        int pos = this.search(element);
        if (pos > -1) {
            this.remove(pos);
        } else {
            System.out.println("Nonexistent element.");
        }
    }

    public void remove(int position) {
        super.remove(position);
    }
}