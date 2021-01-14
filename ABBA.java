/*
 * Universidad Complutese de Madrid.
 * Alumno: Frederick Ernesto Borges Noronha.
*/

public class ABBA implements Cloneable{

    /* 
    ***************
    ** Atributos **
    ***************
    */

    // Valor del nodo
    protected Nodo raiz;

    /* 
    *******************
    ** Constructoras **
    *******************
    */

    public ABBA(){
        this.raiz = null;
    };

    public ABBA clone() throws CloneNotSupportedException{
        ABBA clon = (ABBA) super.clone();
        return clon;
   }

    /* 
    **********************
    ** Métodos privados **
    **********************
    */
    
    private Nodo flotar(Nodo nodo, int valor){
        // Verificamos si el arbol es vacio
        // y si lo es lo devolvemos null.
        if (nodo == null) return null;

        // Si el valor que vamos a flotar ya esta en la raiz
        // entonces no aplicamos la flotación.
        if (nodo.getValor() == valor) return nodo;

        // Si el valor insertado es menor que la raiz del
        // arbol, entonces aplicamos rotaciones.
        if (valor < nodo.getValor()){
            Nodo izq = nodo.getIzq();

            // Si la parte izquierda es vacia
            // entonces devolvemos el mismo nodo.
            if (izq == null) return nodo;
            
            // Si la parte izquierda es la que queremos
            // flotar entonces aplicamos una rotación a
            // la derecha.
            if (izq.getValor() == valor) return rotarDer(nodo);
            
            // Si no es el valor buscado miramos si la
            // izquierda del valor anterior es el que
            // buscamos y si lo es entonces aplicamos una
            // rotacion doble a la izquierda.
            Nodo ii = izq.getIzq();
            if ((ii != null) && (ii.getValor() == valor)) return rotarIzqIzq(nodo);

            // Flotamos el valor desde la parte izquierda
            // y lo que nos devuelva la funcion lo ponemos
            // en el lado izquierdo.
            nodo.setIzq(flotar(izq,valor));

            // Aplicamos una rotación a la derecha al
            // resultado anterior.
            return rotarDer(nodo);
        }

        //if (valor > arbol.getValor())
        Nodo der = nodo.getDer();
        
        // Si la parte derecha es vacia
        // entonces devolvemos el mismo nodo.
        if (der == null) return nodo;
        
        // Si la parte derecha es la que queremos
        // flotar entonces aplicamos una rotación a
        // la izquierda.
        if (der.getValor() == valor) return rotarIzq(nodo);
        
        // Si no es el valor buscado miramos si la
        // derecha del valor anterior es el que
        // buscamos y si lo es entonces aplicamos una
        // rotacion doble a la derecha.
        Nodo dd = der.getDer();
        if ((dd != null) && (dd.getValor() == valor)) return rotarDerDer(nodo);

        // Flotamos el valor desde la parte derecha
        // y lo que nos devuelva la funcion lo ponemos
        // en el lado derecha.
        nodo.setDer(flotar(der,valor));

        // Aplicamos una rotación a la izquierda al
        // resultado anterior.
        return rotarIzq(nodo);
    };

   // Devuelve el nodo con la rotación aplicada.
   private Nodo rotarIzq(Nodo nodo){
        Nodo der = nodo.getDer();
        Nodo derIzq = der.getIzq();

        // Ponemos a la derecha del nodo lo que se
        // tenga la izquierda de la parte derecha.
        nodo.setDer(derIzq);

        // Ponemos a la izquierda el nodo que
        // nos han dado.
        der.setIzq(nodo);

        // Devolvemos como nuevo nodo "raiz" la
        // derecha con los cambios aplicados.
        return der;
    };

    // Devuelve el nodo con la rotación aplicada.
    private Nodo rotarDer(Nodo nodo){
        Nodo izq = nodo.getIzq();
        Nodo izqDer = izq.getDer();

        // Ponemos a la derecha el nodo que
        // nos han dado.
        nodo.setIzq(izqDer);

        // Ponemos a la derecha del nodo lo que se
        // tenga la izquierda de la parte derecha.
        izq.setDer(nodo);

        // Devolvemos como nuevo nodo "raiz" la
        // izquierda con los cambios aplicados.
        return izq;
    };

    private Nodo rotarIzqIzq(Nodo nodo){
        Nodo izq = nodo.getIzq();
        Nodo izqIzq = izq.getIzq();
        Nodo izqDer = izq.getDer();
        Nodo izqIzqDer = izqIzq.getDer();

        // Ponemos en la parte izquierda del nodo dado
        // lo que se tenga a la derecha de la parte
        // izquierda.
        nodo.setIzq(izqDer);
        
        // Ponemos en la parte izquierda de la izquierda
        // del nodo dado lo que se tenga a la derecha de
        // la izquierda de la parte izquierda.
        izq.setIzq(izqIzqDer);

        // Ponemos en la parte derecha de la izquierda
        // del nodo dado el nodo que nos han dado.
        izq.setDer(nodo);

        // Ponemos en la parte derecha de la izquierda
        // de la izquierda lo que se tenga a la 
        // izquierda del nodo dado.
        izqIzq.setDer(izq);

        // Devolvemos como nuevo nodo "raiz" la
        // izquierda de la prate izquierda con los
        // cambios aplicados.
        return izqIzq;
    };

    private Nodo rotarDerDer(Nodo nodo){
        Nodo der = nodo.getDer();
        Nodo derDer = der.getDer();
        Nodo derIzq = der.getIzq();
        Nodo derDerIzq = derDer.getIzq();

        // Ponemos en la parte derecha del nodo dado
        // lo que se tenga a la izquierda de la parte
        // derecha.
        nodo.setDer(derIzq);

        // Ponemos en la parte derecha de la derecha
        // del nodo dado lo que se tenga a la izquierda de
        // la derecha de la parte derecha.
        der.setDer(derDerIzq);

        // Ponemos en la parte izquierda de la derecha
        // del nodo dado el nodo que nos han dado.
        der.setIzq(nodo);

        // Ponemos en la parte izquierda de la derecha
        // de la derecha lo que se tenga a la 
        // derecha del nodo dado.
        derDer.setIzq(der);

        // Devolvemos como nuevo nodo "raiz" la
        // izquierda de la prate izquierda con los
        // cambios aplicados.
        return derDer;
    };
    
    // Método auxiliar para crear 
    private Nodo crear(Nodo izq, int valor, Nodo der){
        Nodo n = new Nodo(valor,izq, der);
        return n;
    };

    private void insertarAux(Nodo nuevo, Nodo nodo){
        // Si el valor a insertar ya esta en el
        // arbol no hacemos nada.
        if (nuevo.getValor() == nodo.getValor()) return;

        if (nuevo.getValor() < nodo.getValor()){
            // Si no hay nada en el lado izquierdo
            // entonces lo insertamos.
            if (nodo.getIzq() == null){
                nodo.setIzq(nuevo);
                return;
            }

            // Si hay algo entonces llamamos de
            // forma recursiva para insertar el
            // valor donde corresponde.
            insertarAux(nuevo, nodo.getIzq());
            return;
        }

        // Si no hay nada en el lado derecho
        // entonces lo insertamos.
        if (nodo.getDer() == null){
            nodo.setDer(nuevo);
            return;
        }      

        // Si hay algo entonces llamamos de
        // forma recursiva para insertar el
        // valor donde corresponde.
        insertarAux(nuevo, nodo.getDer());
    };

    // Una vez que el nodo a eliminar este en la
    // raiz se utiliza el siguiente método para
    // quitar el nodo raiz.
    private void borrarRaiz(int valor){
        // Si el arbol esta vacio entonces no
        // hacemos nada.
        if (this.raiz == null) return;

        // Si el valor a eliminar no esta en la
        // raiz, entonces no esta en el arbol y
        // por tanto no hacemos nada.
        if (valor != this.raiz.getValor()) return;

        // if (valor == nodo.getValor())

        Nodo izq = this.raiz.getIzq();
        Nodo der = this.raiz.getDer();

        // Si es un arbol de un solo nodo entonces
        // ponemos la raiz a null y terminamos.
        if (der == null && izq == null){
            this.raiz = null;
            return;
        }

        // Si el arbol tiene nodo a la izquierda
        // pero no a la derecha entonces ponemos
        // la raiz en el nodo de la izquierda.
        if (der == null){
            this.raiz = izq;
            return;
        }

        // Si el arbol tiene nodo a la derecha
        // pero no a la izquierda entonces ponemos
        // la raiz en el nodo de la derecha.
        if (izq == null){
            this.raiz = der;
            return;
        }

        // if (nodo.getDer() != null && nodo.getIzq() != null)

        // Ahora buscaremos en el lado izquierdo el
        // nodo que esté más a la derecha.

        // Si la izquierda no tiene nada a la derecha
        // entonces le asignamos en su lado derecho
        // lo que tengamos a la derecha de la raiz.
        if (izq.getDer() == null){
            izq.setDer(der);
            this.raiz = izq;
            return;
        }


        // Buscamos mientras se tengan nodos a la derecha.
        Nodo anterior = null;
        Nodo nuevaRaiz = izq;

        while (nuevaRaiz.getDer() != null){
            anterior = nuevaRaiz;
            nuevaRaiz = nuevaRaiz.getDer();
        }

        // Al nodo anterior le quitamos el enlace y hacemos
        // que ahora apunte a lo que tenia el nodo por la
        // izquierda.
        anterior.setDer(nuevaRaiz.getIzq());

        // Al nodo más a la derecha le cambiamos sus punteros
        // a sus hijos dejando a la izquierda lo que tenía la
        // raíz a la izquierda y a la derecha lo que tenía la
        // raíz a la derecha.
        nuevaRaiz.setIzq(izq);
        nuevaRaiz.setDer(der);

        // Decimos que la nueva raíz es el nodo trabajado
        // anteriormente.
        this.raiz = nuevaRaiz;
    };

    // Este método imprime todo los nodos indicando sus hijos.
    private void printAllTreeNodes(Nodo raiz) {
        if (raiz != null){
            System.out.println(raiz);
            System.out.println("");
            printAllTreeNodes(raiz.getIzq());
            printAllTreeNodes(raiz.getDer());
        }
    }

    // Método que imprime el arbo.
    private void printTree(Nodo root, int level){ 
        if(root==null) return;
        printTree(root.getDer(), level+1);
        if(level!=0){ 
            for(int i=0;i<level-1;i++)
                System.out.print("|\t");
                System.out.println("|-------" + root.getValor());
            }
        else 
            System.out.println(root.getValor() + "*");
            printTree(root.getIzq(), level+1);
    };

    /* 
    **********************
    ** Métodos públicos **
    **********************
    */

    // Obtiene la altura del arbol actual.
    // Si es vacio devuelve 0.
    public int altura(){
        if (this.raiz == null){
            return 0;
        }
        else{
            return this.raiz.getAltura();
        }
    };

    public Nodo buscar(int x){
        // Hacemos flotar el valor que queremos buscar
        this.raiz = flotar(this.raiz, x);
        // Si el valor esta en el arbol entonces lo
        // tendremos en la raiz, y si no entonces
        // no esta en el arbol.
        if (this.raiz == null) return null;
        if (this.raiz.getValor() != x) return null;
        return this.raiz;
    };

    // Inserta un nuevo valor en el arbol
    // Si el valor ya existia solo lo flota hasta la raiz.
    public void insertar(int valor){
        // Si el arbol es vacio entonces solo
        // creamos un nuevo nodo.
        if (this.raiz == null){
            this.raiz = crear(null, valor, null);
            return;
        }

        insertarAux(crear(null, valor, null), this.raiz);
        this.raiz = flotar(this.raiz, valor);
    };

    // Borra una valor del arbol.
    public void borrar(int valor){
        this.raiz = flotar(this.raiz, valor);
        borrarRaiz(valor);
    };

    // Imprime todos los nodos del arbol
    public String printInorden(Nodo raiz){
        String ret = "";
        if (raiz != null){
            ret += printInorden(raiz.getIzq());
            ret += raiz.getValor() + " ";
            ret += printInorden(raiz.getDer());
        }
        return ret;
    };

    public void printAllTreeNodes(){
        printAllTreeNodes(this.raiz);
    };

    public void printTree(){
        printTree(this.raiz, 0);
    };

    @Override
    public String toString() {
        return printInorden(this.raiz); 
    };

}