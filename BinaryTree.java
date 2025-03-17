public class BinaryTree<K extends Comparable<K>, V> {
    private Nodo<K, V> root;

    public BinaryTree() {
        this.root = null;
    }
    //Insertar nodo
    public void insertar(K clave, V valor) {
        root = insertar(root, clave, valor);
    }

    private Nodo<K, V> insertar(Nodo<K, V> nodo, K clave, V valor) {
        if (nodo == null) {
            return new Nodo<>(clave, valor);
        }
        if (clave.compareTo(nodo.getClave()) < 0) {
            nodo.setLeft(insertar(nodo.getLeft(), clave, valor));
        } else if (clave.compareTo(nodo.getClave()) > 0) {
            nodo.setRight(insertar(nodo.getRight(), clave, valor));
        }
        return nodo;
    }

    //Buscar un nodo
    public V buscar(K clave) {
        return buscar(root, clave);
    }

    private V buscar(Nodo<K, V> nodo, K clave) {
        if (nodo == null) {
            return null;
        }
        if (clave.compareTo(nodo.getClave()) == 0) {
            return nodo.getValor();
        } else if (clave.compareTo(nodo.getClave()) < 0) {
            return buscar(nodo.getLeft(), clave);
        } else {
            return buscar(nodo.getRight(), clave);
        }
    }

    // recorrido inorden
    public void inorden() {
        inorden(root);
    }

    private void inorden(Nodo<K, V> nodo) {
        if (nodo != null) {
            inorden(nodo.getLeft());
            System.out.println(nodo.getClave() + " -> " + nodo.getValor());
            inorden(nodo.getRight());
        }
    }
}
