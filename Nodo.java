public class Nodo<K extends Comparable<K>, V> {
    private K clave;
    private V valor;
    private Nodo<K, V> left, right;

    public Nodo(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
        this.left = this.right = null;
    }

    public K getClave() {
        return clave;
    }

    public V getValor() {
        return valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }

    public Nodo<K, V> getLeft() {
        return left;
    }

    public void setLeft(Nodo<K, V> Left) {
        this.left = Left;
    }

    public Nodo<K, V> getRight() {
        return right;
    }

    public void setRight(Nodo<K, V> right) {
        this.right = right;
    }
}
