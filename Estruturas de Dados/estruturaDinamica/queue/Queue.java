package estruturaDinamica.queue;

public class Queue<T> {
    private Node<T> begin, end;
    private int qtd;

    public void enqueue(T elemento) {
        Node<T> newElement = new Node<T>(elemento);
        if (this.begin == null) {
            this.begin = newElement;
            this.end = newElement;
            this.qtd++;
        } else {
            this.end.nextElement = newElement;
            this.end = newElement;
            this.qtd++;
        }
    }

    public T dequeue() {
        T remove = null;
        if (this.begin != null) {
            remove = this.begin.element;
            this.begin = this.begin.nextElement;
            this.qtd--;
            if (this.begin == null) {
                this.end = null;
            }
        }
        return remove;
    }

    public int size() {
        return this.qtd;
    }

    public T consult() {
        T begin = null;
        if (this.begin != null) {
            begin = this.begin.element;
        }
        return begin;
    }

    public void clear() {
        this.begin = null;
        this.end = null;
        this.qtd = 0;
    }

    public String toString() {
        String string = "";
        boolean initial = true;
        Node<T> aux = this.begin;
        while (aux != null) {
            if (initial == true) {
                string += aux.element;
                initial = false;
            } else {
                string += " -> " + aux.element;
            }
            aux = aux.nextElement;
        }
        return string;
    }

    public void print() {
        System.out.println(this.toString());
    }
}