public class LaListaSwap {
    private Nodo act;

    public LaListaSwap() {
        this.act = null;
    }

    public void insertar(int dato) {
        Nodo newNodo = new Nodo(dato);
        if (act == null) {
            act = newNodo;
            newNodo.sig = act;
        } else {
            Nodo temp = act;
            while (temp.sig != act) {
                temp = temp.sig;
            }
            temp.sig = newNodo;
            newNodo.sig = act;
        }
    }

    public void swap(int i, int j) {
        if (i != j){
            Nodo nodoI = buscarNodo(i);
            Nodo nodoJ = buscarNodo(j);
            if (nodoI != null && nodoJ != null) {
                int temp = nodoI.dato;
                nodoI.dato = nodoJ.dato;
                nodoJ.dato = temp;
            }
        }
    }

    private Nodo buscarNodo(int dato) {
        Nodo temp = act;
        do {
            if (temp.dato == dato) {
                return temp;
            }
            temp = temp.sig;
        } while (temp != act);
        return null; // Nodo no encontrado
    }

    public String[] imprimir() {
        if (act == null) 
            return new String[0];

        Nodo temp = act;
        int tamano = getSize();
        String[] laLista = new String[tamano];
        for (int i = 0; i < tamano; i++) {
            laLista[i] = String.valueOf(temp.dato);
            temp = temp.sig;
        }
        return laLista;
    }

    private int getSize() {
        Nodo temp = act;
        int cont = 0;
        do {
            cont++;
            temp = temp.sig;
        } while (temp != act);
        return cont;
    }

    public static void main(String[] args) {//codigo para probar
        LaListaSwap list = new LaListaSwap();
        list.insertar(1);
        list.insertar(2);
        list.insertar(3);
        list.insertar(4);

        System.out.println("Lista original:");
        String[] originalList = list.imprimir();
        for (String element : originalList) {
            System.out.print(element + " ");
        }
        System.out.println();

        list.swap(4, 3);

        System.out.println("Lista después de swap(1, 3):");
        String[] modifiedList = list.imprimir();
        for (String element : modifiedList) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
