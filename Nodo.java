/*
 * Universidad Complutese de Madrid.
 * Alumno: Frederick Ernesto Borges Noronha.
*/

public class Nodo{

    // Valor del nodo
    private int valor;
    // Nodo a la izquierda
    private Nodo izq;
    // Nodo a la derecha
    private Nodo der;
    // Altura del nodo
    private int altura;

    // Constructora

    public Nodo(int valor, Nodo izq, Nodo der){
        this.valor = valor;
        this.izq = izq;
        this.der = der;
        recalcularAltura();
    };  

    /*
    * Método que calcula la altura de un nodo.
    * Busca la altura maxima de los dos nodos 
    */
    private void recalcularAltura(){
        if ((izq != null) && (der != null))
            this.altura = Math.max(izq.altura, der.altura) + 1;
        else if (der != null)
            this.altura = der.altura + 1;
        else if (izq != null)
            this.altura = izq.altura + 1;
        else
            this.altura = 1;
    }

    /* 
    *************
    ** Setters **
    *************
    */

    public void setIzq(Nodo izq){
        this.izq = izq;
        recalcularAltura();
    };

    public void setDer(Nodo der){
        this.der = der;
        recalcularAltura();
    };

    /* 
    *************
    ** Getters **
    *************
    */

    public int getValor(){
        return this.valor;
    };

    public Nodo getIzq(){
        return this.izq;
    }

    public Nodo getDer(){
        return this.der;
    }

    public int getAltura(){
        return this.altura;
    };

    @Override
    public String toString(){
        String izquierda = "null";
        String derecha = "null";
        String valor = "(" + Integer.toString(this.valor) + ")";
        String altura = Integer.toString(this.altura);
        if (this.izq != null) izquierda = "(" + Integer.toString(this.izq.valor) + ")";
        if (this.der != null) derecha = "(" + Integer.toString(this.der.valor) + ")";
        return 
                "Nodo: " + valor + " | Altura: " + altura +
                "\n\t|" +
                "\n\t⊢---> Izq: " + izquierda +
                "\n\t|" + 
                "\n\t⊢---> Der: " + derecha;
    }
}