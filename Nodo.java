public class Nodo {

    private Nodo left;
    private Nodo right;
    private Nodo root;
    

    private void inorder(Nodo n) {
        if (n != null) {
            inorder(n.getLeft());
            n.imprimirDato();
            inorder(n.getRight());
        }
    }

    public void inorder() {
        this.inorder(this.root);
    }

}