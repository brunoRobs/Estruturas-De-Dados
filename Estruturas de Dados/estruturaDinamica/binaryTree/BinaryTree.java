package estruturaDinamica.binaryTree;

@SuppressWarnings("unchecked")
public class BinaryTree<T> {
    private BinaryNode<T> root;
    private int qtd = 0;

    private int compare(T element1, T element2) {
        int result = -1;
        if (element1 instanceof Comparable) {
            result = ((Comparable<T>) element1).compareTo(element2);
        }
        return result;
    }

    public boolean exist(T wanted) {
        boolean result = false;
        BinaryNode<T> aux = this.root;
        while (aux != null) {
            int comp = this.compare(wanted, aux.element);
            if (comp == 0) {
                result = true;
                break;
            } else if (comp < 0) {
                aux = aux.left;
            } else {
                aux = aux.right;
            }
        }
        return result;
    }

    public void add(T newElement) {
        BinaryNode<T> newNode = new BinaryNode<T>(newElement);
        if (this.root == null) {
            this.root = newNode;
            this.qtd++;
        } else {
            BinaryNode<T> aux = this.root;
            while (aux != null) {
                int comp = this.compare(newElement, aux.element);
                if (comp == 0) {
                    break;
                } else if (comp < 0) {
                    if (aux.left != null) {
                        aux = aux.left;
                    } else {
                        aux.left = newNode;
                        this.qtd++;
                        break;
                    }
                } else {
                    if (aux.right != null) {
                        aux = aux.right;
                    } else {
                        aux.right = newNode;
                        this.qtd++;
                        break;
                    }
                }
            }
        }
    }

    public void remove(T element) {
        if (this.root != null) {
            if (this.root.element.equals(element)) {
                if (this.root.left == null) {
                    this.root = this.root.right;
                } else if (this.root.right == null) {
                    this.root = this.root.left;
                } else {
                    this.changeRoot(this.root);
                }
                this.qtd--;
            } else {
                BinaryNode<T> aux = this.root;
                BinaryNode<T> fatherAux = aux;
                while (aux != null) {
                    int comp = this.compare(aux.element, element);
                    if (comp == 0) {
                        break;
                    } else if (comp < 0) {
                        fatherAux = aux;
                        aux = aux.right;
                    } else {
                        fatherAux = aux;
                        aux = aux.left;
                    }
                }
                if (aux != null) {
                    if (aux.left == null) {
                        if (fatherAux.left == aux) {
                            fatherAux.left = aux.right;
                        } else {
                            fatherAux.right = aux.right;
                        }
                    } else if (aux.right == null) {
                        if (fatherAux.left == aux) {
                            fatherAux.left = aux.left;
                        } else {
                            fatherAux.right = aux.left;
                        }
                    } else {
                        this.changeRoot(aux);
                    }
                }
                this.qtd--;
            }
        }
    }

    private void changeRoot(BinaryNode<T> subtreeRoot) {
        BinaryNode<T> aux = subtreeRoot.right;
        BinaryNode<T> fatherAux = aux;
        while (aux.left != null) {
            fatherAux = aux;
            aux = aux.left;
        }
        subtreeRoot.element = aux.element;
        if (aux != fatherAux) {
            fatherAux.left = aux.right;
        } else {
            subtreeRoot.right = aux.right;
        }
    }

    public String treeInOrder(BinaryNode<T> root) {
        if (root != null) {
            return this.treeInOrder(root.left) + root.element + " " + this.treeInOrder(root.right);
        }
        return "";
    }

    public String treePreOrder(BinaryNode<T> root) {
        if (root != null) {
            return root.element + " " + this.treePreOrder(root.left) + this.treePreOrder(root.right);
        }
        return "";
    }

    public String treePostOrder(BinaryNode<T> root) {
        if (root != null) {
            return this.treePostOrder(root.left) + this.treePostOrder(root.right) + root.element + " ";
        }
        return "";
    }

    public void clear() {
        this.root = null;
        this.qtd = 0;
    }

    public int size() {
        return this.qtd;
    }
}