/*
 * Universidad Complutese de Madrid.
 * Alumno: Frederick Ernesto Borges Noronha.
*/

import java.util.*;

public class Inserts {

    public Inserts(){
        // VACIA
    };

    public String casoMejor(int tamañoArbol, int repeticiones, int cantidadDeCiclos){
        ABBA abba = new ABBA();

        List<Integer> dentroDelArbol = new ArrayList<Integer>();

        long tiempo = 0, tiempoInterno = 0, startTime = 0;

        // Creamos un arbol de tamaño "tamañoArbol".
        for (int i = 0; i < tamañoArbol; i++){
            abba.insertar(i);
            dentroDelArbol.add(i);
        }


        // Realizamos las mediciones
        for (int i = 0; i < cantidadDeCiclos; i++){
            for (int j = 0; j < repeticiones; j++){
                // Creamos un valor aleatorio
                int valor = tamañoArbol + 1;

                // Realizamos las mediciones.
                startTime = System.nanoTime();
                abba.insertar(valor);
                tiempoInterno += (System.nanoTime() - startTime);
                
                // Dejamos el arbol con el mismo numero de elementos que antes.
                abba.borrar(valor);
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
                // Creamos un valor aleatorio
                int valor = rand.nextInt();

                // No insertamos elementos repetidos. 
                while(dentroDelArbol.contains(valor))
                    valor = rand.nextInt();

                // Realizamos las mediciones.
                startTime = System.nanoTime();
                abba.insertar(valor);
                tiempoInterno += (System.nanoTime() - startTime);
                
                // Dejamos el arbol con el mismo numero de elementos que antes.
                abba.borrar(valor);
            }

            tiempo += tiempoInterno / repeticiones;
            tiempoInterno = 0;

        }

        return tamañoArbol + " " + (tiempo / cantidadDeCiclos);
    };

    public String casoCritico(int tamañoArbol, int repeticiones, int cantidadDeCiclos){
        ABBA abba = new ABBA();
        
        List<Integer> dentroDelArbol = new ArrayList<Integer>();

        long tiempo = 0, tiempoInterno = 0, startTime = 0;

        // Creamos un arbol de tamaño "tamañoArbol".
        for (int i = 0; i < tamañoArbol; i++){
            abba.insertar(i);
            dentroDelArbol.add(i);
        }


        // Realizamos las mediciones
        for (int i = 0; i < cantidadDeCiclos; i++){
            for (int j = 0; j < repeticiones; j++){
                // Creamos un valor aleatorio
                int valor = -1;

                // Realizamos las mediciones.
                startTime = System.nanoTime();
                abba.insertar(valor);
                tiempoInterno += (System.nanoTime() - startTime);
                
                // Dejamos el arbol con el mismo numero de elementos que antes.
                abba.borrar(valor);
            }

            tiempo += tiempoInterno / repeticiones;
            tiempoInterno = 0;

        }

        return tamañoArbol + " " + (tiempo / cantidadDeCiclos);
    };
}