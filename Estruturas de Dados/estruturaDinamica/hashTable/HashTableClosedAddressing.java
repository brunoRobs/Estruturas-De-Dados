package estruturaDinamica.hashTable;

import estruturaDinamica.linkedList.LinkedList;

@SuppressWarnings("unchecked")
public class HashTableClosedAddressing<T> {
    private LinkedList<T>[] table;

    public HashTableClosedAddressing(int size) {
        this.table = new LinkedList[size];
        for (int i = 0; i < this.table.length; i++) {
            this.table[i] = new LinkedList<T>();
        }
    }

    public void add(T newElement) {
        int pos = Math.abs(newElement.hashCode()) % this.table.length;
        if (this.table[pos].exist(newElement) == false) {
            this.table[pos].add(newElement);
        }
    }

    public void remove(T element) {
        int pos = Math.abs(element.hashCode()) % this.table.length;
        if (this.table[pos].exist(element)) {
            this.table[pos].remove(element);
        }
    }

    public void clear() {
        for (int i = 0; i < this.table.length; i++) {
            this.table[i].clear();
        }
    }

    public T search(T element) {
        T result = null;
        int pos = Math.abs(element.hashCode() % this.table.length);
        if (this.table[pos].exist(element)) {
            result = this.table[pos].search(element);
        }
        return result;
    }

    public boolean exist(T element) {
        return this.search(element) != null;
    }

    public String toString() {
        String string = "";
        for (int i = 0; i < this.table.length; i++) {
            if (this.table[i].begin == null) {
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