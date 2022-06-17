package estruturaDinamica.hashTable;

@SuppressWarnings("unchecked")
public class HashTableOpenAddressing<T> {
    private T[] table;
    private double qtd = 0.0;
    private T obj;

    public HashTableOpenAddressing(int size) {
        table = (T[]) new Object[size];
        obj = (T) new Object();
    }

    public void add(T newElement) {
        if (0.75 > (this.qtd / this.table.length)) {
            int pos = Math.abs(newElement.hashCode()) % this.table.length;
            while (this.table[pos] != null && this.table[pos] != this.obj) {
                pos = (pos + 1) % this.table.length;
            }
            this.table[pos] = newElement;
            this.qtd++;
        } else {
            T[] newTable = (T[]) new Object[this.table.length * 2];
            for (int i = 0; i < this.table.length; i++) {
                newTable[i] = this.table[i];
            }
            this.table = newTable;
            this.add(newElement);
        }
    }

    public void remove(T element) {
        int counter = 0;
        int pos = Math.abs(element.hashCode()) % this.table.length;
        while (this.table[pos] != null && counter < this.table.length) {
            if (this.table[pos].equals(element)) {
                this.table[pos] = obj;
                this.qtd--;
                break;
            }
            pos = (pos + 1) % this.table.length;
            counter++;
        }
    }

    public void clear() {
        for (int i = 0; i < this.table.length; i++) {
            this.table[i] = obj;
        }
        this.qtd = 0.0;
    }

    public T search(T element) {
        T result = null;
        int counter = 0;
        int pos = Math.abs(element.hashCode()) % this.table.length;
        while (this.table[pos] != null && counter < this.table.length) {
            if (this.table[pos].equals(element)) {
                result = this.table[pos];
                break;
            }
            pos = (pos + 1) % this.table.length;
            counter++;
        }
        return result;
    }

    public boolean exist(T element) {
        return this.search(element) != null;
    }

    public String toString() {
        String string = "";
        for (int i = 0; i < this.table.length; i++) {
            if (this.table[i] == null) {
                string += "[" + i + "]" + "\n";
            } else {
                string += "[" + i + "] -> " + this.table[i].toString() + "\n";
            }
        }
        return string;
    }

    public void print() {
        System.out.println(this.toString());
    }
}