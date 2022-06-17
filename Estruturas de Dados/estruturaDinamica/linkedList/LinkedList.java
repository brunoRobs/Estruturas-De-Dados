package estruturaDinamica.linkedList;

public class LinkedList<T> {
    public Node<T> begin;
    private int qtd;

    public void add(T element) {
        Node<T> newElement = new Node<T>(element);
        if (this.begin == null) {
            this.begin = newElement;
            this.qtd++;
        } else {
            Node<T> aux = this.begin;
            while (aux.nextElement != null) {
                aux = aux.nextElement;
            }
            aux.nextElement = newElement;
            this.qtd++;
        }
    }

    public void remove(T element) {
        if (this.begin != null) {
            if (element.equals(this.begin.element)) {
                this.begin = this.begin.nextElement;
                this.qtd--;
            } else {
                Node<T> aux = this.begin;
                while (aux.nextElement != null) {
                    if (aux.nextElement.element.equals(element)) {
                        aux.nextElement = aux.nextElement.nextElement;
                        this.qtd--;
                        break;
                    } else {
                        aux = aux.nextElement;
                    }
                }
            }
        }
    }

    public int size() {
        return this.qtd;
    }

    public T search(T element) {
        T result = null;
        Node<T> aux = this.begin;
        while (aux != null) {
            if (aux.element.equals(element)) {
                result = aux.element;
                break;
            } else {
                aux = aux.nextElement;
            }
        }
        return result;
    }

    public boolean exist(T element) {
        return this.search(element) != null;
    }

    public void clear() {
        this.begin = null;
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