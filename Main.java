/*
 * Universidad Complutese de Madrid.
 * Alumno: Frederick Ernesto Borges Noronha.
*/

import java.io.*;

public class Main {

    private static void insertCasoMejor(int cant, int inc, int repeticiones, int cantidadDeCiclos) throws IOException{
        Inserts inserts = new Inserts();

        // Abrimos los ficheros para escribir.
        FileWriter file = new FileWriter("Ficheros/insertsMejor.dat");
        PrintWriter writer = new PrintWriter(file);

        for (int i = 0; i <= cant; i+=inc){
            System.out.println("Mejor #" + i);
            writer.println(inserts.casoMejor(i, repeticiones, cantidadDeCiclos));
        }

        // Cerramos el fichero.
        writer.close();
    };

    private static void insertCasoPromedio(int cant, int inc, int repeticiones, int cantidadDeCiclos) throws IOException{
        Inserts inserts = new Inserts();

        // Abrimos los ficheros para escribir.
        FileWriter file = new FileWriter("Ficheros/insertsPromedio.dat");
        PrintWriter writer = new PrintWriter(file);

        for (int i = 0; i <= cant; i+=inc){
            System.out.println("Promedio #" + i);
            writer.println(inserts.casoPromedio(i, repeticiones, cantidadDeCiclos));
        }

        // Cerramos el fichero.
        writer.close();
    };

    private static void insertCasoCritico(int cant, int inc, int repeticiones, int cantidadDeCiclos) throws IOException{
        Inserts inserts = new Inserts();

        // Abrimos los ficheros para escribir.
        FileWriter file = new FileWriter("Ficheros/insertsCritico.dat");
        PrintWriter writer = new PrintWriter(file);

        for (int i = 0; i <= cant; i+=inc){
            System.out.println("Crítico #" + i);
            writer.println(inserts.casoCritico(i, repeticiones, cantidadDeCiclos));
        }

        // Cerramos el fichero.
        writer.close();
    };

    private static void deleteCasoMejor(int cant, int inc, int repeticiones, int cantidadDeCiclos) throws IOException{
        Deletes deletes = new Deletes();

        // Abrimos los ficheros para escribir.
        FileWriter file = new FileWriter("Ficheros/deletesMejor.dat");
        PrintWriter writer = new PrintWriter(file);

        for (int i = 0; i <= cant; i+=inc){
            if (i == 0) i = 1;
            System.out.println("Mejor #" + i);
            writer.println(deletes.casoMejor(i, repeticiones, cantidadDeCiclos));
            if (i == 1) i = 0;
        }

        // Cerramos el fichero.
        writer.close();
    };

    private static void deleteCasoPromedio(int cant, int inc, int repeticiones, int cantidadDeCiclos) throws IOException{
        Deletes deletes = new Deletes();

        // Abrimos los ficheros para escribir.
        FileWriter file = new FileWriter("Ficheros/deletesPromedio.dat");
        PrintWriter writer = new PrintWriter(file);

        for (int i = 0; i <= cant; i+=inc){
            if (i == 0) i = 1;
            System.out.println("Promedio #" + i);
            writer.println(deletes.casoPromedio(i, repeticiones, cantidadDeCiclos));
            if (i == 1) i = 0;
        }

        // Cerramos el fichero.
        writer.close();
    };

    private static void deleteCasoCritico(int cant, int inc, int repeticiones, int cantidadDeCiclos) throws IOException, CloneNotSupportedException {
        Deletes deletes = new Deletes();

        // Abrimos los ficheros para escribir.
        FileWriter file = new FileWriter("Ficheros/deletesCritico.dat");
        PrintWriter writer = new PrintWriter(file);

        for (int i = 0; i <= cant; i+=inc){
            if (i == 0) i = 1;
            System.out.println("Crítico #" + i);
            writer.println(deletes.casoCritico(i, repeticiones, cantidadDeCiclos));
            if (i == 1) i = 0;
        }

        // Cerramos el fichero.
        writer.close();
    };

    private static void searchCasoMejor(int cant, int inc, int repeticiones, int cantidadDeCiclos) throws IOException{
        Searches searches = new Searches();

        // Abrimos los ficheros para escribir.
        FileWriter file = new FileWriter("Ficheros/searchesMejor.dat");
        PrintWriter writer = new PrintWriter(file);

        for (int i = 0; i <= cant; i+=inc){
            if (i == 0) i = 1;
            System.out.println("Mejor #" + i);
            writer.println(searches.casoMejor(i, repeticiones, cantidadDeCiclos));
            if (i == 1) i = 0;
        }

        // Cerramos el fichero.
        writer.close();
    };

    private static void searchCasoPromedio(int cant, int inc, int repeticiones, int cantidadDeCiclos) throws IOException{
        Searches searches = new Searches();

        // Abrimos los ficheros para escribir.
        FileWriter file = new FileWriter("Ficheros/searchesPromedio.dat");
        PrintWriter writer = new PrintWriter(file);

        for (int i = 0; i <= cant; i+=inc){
            if (i == 0) i = 1;
            System.out.println("Promedio #" + i);
            writer.println(searches.casoPromedio(i, repeticiones, cantidadDeCiclos));
            if (i == 1) i = 0;
        }

        // Cerramos el fichero.
        writer.close();
    };

    private static void searchCasoCritico(int cant, int inc, int repeticiones, int cantidadDeCiclos) throws IOException, CloneNotSupportedException {
        Searches searches = new Searches();

        // Abrimos los ficheros para escribir.
        FileWriter file = new FileWriter("Ficheros/searchesCritico.dat");
        PrintWriter writer = new PrintWriter(file);

        for (int i = 0; i <= cant; i+=inc){
            if (i == 0) i = 1;
            System.out.println("Crítico #" + i);
            writer.println(searches.casoCritico(i, repeticiones, cantidadDeCiclos));
            if (i == 1) i = 0;
        }

        // Cerramos el fichero.
        writer.close();
    };

    public static void main(String[] args) throws IOException, CloneNotSupportedException{

        if (args.length == 4){
            int cant = 200000;
            int inc = 1000;
            int repeticiones = 1000;
            int cantidadDeCiclos = 50;

            // Generar ficheros de Inserts.
            insertCasoMejor(cant, inc, repeticiones, cantidadDeCiclos);
            insertCasoPromedio(cant, inc, repeticiones, cantidadDeCiclos);
            insertCasoCritico(cant, inc, repeticiones, cantidadDeCiclos);

            // Generar ficheros de Deletes.
            deleteCasoMejor(cant, inc, repeticiones, cantidadDeCiclos);
            deleteCasoPromedio(cant, inc, repeticiones, cantidadDeCiclos);
            deleteCasoCritico(cant, inc, repeticiones, cantidadDeCiclos);

            //Generar ficheros de Searches.
            searchCasoMejor(cant, inc, repeticiones, cantidadDeCiclos);
            searchCasoPromedio(cant, inc, repeticiones, cantidadDeCiclos);
            searchCasoCritico(cant, inc, repeticiones, cantidadDeCiclos);
        }
        else if (args.length > 4){
            System.err.println("Se han especificado demasiados argumentos.\n" + 
                               "La forma correcta de llamar al programa es: \"java Main [max. cant. elementos] [incremento] [repeticiones] [ciclos]\"");
        }
        else{
            System.err.println("Se han especificado muy pocos argumentos.\n" + 
                               "La forma correcta de llamar al programa es: \"java Main [max. cant. elementos] [incremento] [repeticiones] [ciclos]\"");
        }
    }
}