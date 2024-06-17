import java.util.ArrayList;

public class Tree<T> {
    private ArrayList<Tree<T>> childs;
    private T data;

    public Tree(T data) {
        this.data = data;
        this.childs = new ArrayList<>();
    }

    public ArrayList<Tree<T>> getChilds() {
        return childs;
    }

    public T getData() {
        return data;
    }

    public boolean esHoja() {
        return childs.isEmpty();
    }

    public void imprimir() {
        imprimir(this);
    }

    private void imprimir(Tree<T> arb) {
            if (!arb.esHoja()) {
                imprimirNivel(arb.childs);
                for (Tree<T> child : arb.childs) {
                    imprimir(child);
                }
            }
        
    }

    private void imprimirNivel(ArrayList<Tree<T>> childs) {
        for (Tree<T> child : childs) {
            System.out.print(child.data + " "); 
        }
        System.out.println();
    }

    public void agregar(Tree<T> arb) {
        childs.add(arb);
    }

    public static void main(String[] args) {//ejemplo para probar
        Tree<String> root = new Tree<>("Root");
        Tree<String> child1 = new Tree<>("Child1");
        Tree<String> child2 = new Tree<>("Child2");
        Tree<String> child11 = new Tree<>("Child1.1");
        Tree<String> child12 = new Tree<>("Child1.2");

        root.agregar(child1);
        root.agregar(child2);
        child1.agregar(child11);
        child1.agregar(child12);

        root.imprimir();
    }
}