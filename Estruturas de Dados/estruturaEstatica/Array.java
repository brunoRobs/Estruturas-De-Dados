package estruturaEstatica;

@SuppressWarnings("unchecked")
public class Array<T> {
    public T[] structure;
    public int size;

    public Array(int capacity) {
        this.structure = (T[]) new Object[capacity];
        this.size = 0;
    }

    private void expandCapacity() {
        T[] newArray = (T[]) new Object[structure.length * 2];
        for (int i = 0; i < structure.length; i++) {
            newArray[i] = this.structure[i];
        }
        this.structure = newArray;
    }

    public boolean add(T element) {
        if (this.size == this.structure.length) {
            this.expandCapacity();
        }
        if (this.size < this.structure.length) {
            this.structure[this.size] = element;
            this.size++;
            return true;
        }
        return false;
    }

    public boolean add(int position, T element) {
        if (this.size == this.structure.length) {
            this.expandCapacity();
        }
        if (!(position >= 0 && position < this.size)) {
            throw new IllegalArgumentException("Invalid position.");
        }
        for (int i = this.size - 1; i >= position; i--) {
            this.structure[i + 1] = this.structure[i];
        }
        this.structure[position] = element;
        this.size++;
        return true;
    }

    public void remove(int position) {
        if (!(position >= 0 && position < this.size)) {
            throw new IllegalArgumentException("Invalid position.");
        }
        for (int i = position; i < this.size - 1; i++) {
            this.structure[i] = this.structure[i + 1];
        }
        this.size--;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        String str = "";
        str += "[";
        for (int i = 0; i < this.size - 1; i++) {
            str += this.structure[i] + ", ";
        }
        if (this.size > 0) {
            str += this.structure[this.size - 1] + "]";
        }
        return str;
    }
}