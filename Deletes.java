/*
 * Universidad Complutese de Madrid.
 * Alumno: Frederick Ernesto Borges Noronha.
*/

import java.util.*;

public class Deletes {

    public Deletes(){
        // VACIO
    }

    public String casoMejor(int tamañoArbol, int repeticiones, int cantidadDeCiclos){
        ABBA abba = new ABBA();

        List<Integer> dentroDelArbol = new ArrayList<Integer>();

        long tiempo = 0, tiempoInterno = 0, startTime = 0;
        Random rand = new Random();

        // Creamos un arbol de tamaño "tamañoArbol".
        for (int i = 0; i < tamañoArbol; i++){
            // Creamos un valor aleatorio
            int valor = rand.nextInt();

            // No insertamos elementos repetidos. 
            while(dentroDelArbol.contains(valor))
                valor = rand.nextInt();
            
            // Insertamos el valor.
            abba.insertar(valor);
            dentroDelArbol.add(valor);
        }


        // Realizamos las mediciones
        for (int i = 0; i < cantidadDeCiclos; i++){
            for (int j = 0; j < repeticiones; j++){
                // Tomamos un valor aleatorio del arbol
                int valor = abba.raiz.getValor();

                // Realizamos las mediciones.
                startTime = System.nanoTime();
                abba.borrar(valor);
                tiempoInterno += (System.nanoTime() - startTime);
                
                // Dejamos el arbol con el mismo numero de elementos que antes.
                abba.insertar(valor);
            }

            tiempo += tiempoInterno / repeticiones;
            tiempoInterno = 0;

        }

        return tamañoArbol + " " + (tiempo / cantidadDeCiclos);
    };

    public String casoPromedio(int tamañoArbol, int repeticiones, int cantidadDeCiclos){
        ABBA abba = new ABBA();

        List<Integer> dentroDelArbol = new ArrayList<Integer>();

        long tiempo = 0, tiempoInterno = 0, startTime = 0;
        Random rand = new Random();

        // Creamos un arbol de tamaño "tamañoArbol".
        for (int i = 0; i < tamañoArbol; i++){
            // Creamos un valor aleatorio
            int valor = rand.nextInt();

            // No insertamos elementos repetidos. 
            while(dentroDelArbol.contains(valor))
                valor = rand.nextInt();
            
            // Insertamos el valor.
            abba.insertar(valor);
            dentroDelArbol.add(valor);
        }


        // Realizamos las mediciones
        for (int i = 0; i < cantidadDeCiclos; i++){
            for (int j = 0; j < repeticiones; j++){
                // Tomamos un valor aleatorio del arbol
                int valor = dentroDelArbol.get(rand.nextInt(dentroDelArbol.size()));

                // Realizamos las mediciones.
                startTime = System.nanoTime();
                abba.borrar(valor);
                tiempoInterno += (System.nanoTime() - startTime);
                
                // Dejamos el arbol con el mismo numero de elementos que antes.
                abba.insertar(valor);
            }

            tiempo += tiempoInterno / repeticiones;
            tiempoInterno = 0;

        }

        return tamañoArbol + " " + (tiempo / cantidadDeCiclos);
    };

    public String casoCritico(int tamañoArbol, int repeticiones, int cantidadDeCiclos) throws CloneNotSupportedException {
        ABBA abba = new ABBA();
        ABBA abba2 = new ABBA();

        List<Integer> dentroDelArbol = new ArrayList<Integer>();

        long tiempo = 0, tiempoInterno = 0, startTime = 0;

        // Creamos un arbol de tamaño "tamañoArbol".
        for (int k = 0; k < tamañoArbol; k++){
            abba2.insertar(k);
            dentroDelArbol.add(k);
        }

        // Realizamos las mediciones
        for (int i = 0; i < cantidadDeCiclos; i++){
            for (int j = 0; j < repeticiones; j++){
                // Usamos el mismo arbol que creamos la primera vez.
                abba = abba2.clone();

                // Tomamos un valor aleatorio del arbol
                int valor = dentroDelArbol.get(0);

                // Realizamos las mediciones.
                startTime = System.nanoTime();
                abba.borrar(valor);
                tiempoInterno += (System.nanoTime() - startTime);
                
                // Dejamos el arbol con el mismo numero de elementos que antes.
                dentroDelArbol.remove(valor);
                abba.insertar(valor);
                dentroDelArbol.add(valor);

            }

            tiempo += tiempoInterno / repeticiones;
            tiempoInterno = 0;

        }

        return tamañoArbol + " " + (tiempo / cantidadDeCiclos);
    };
}