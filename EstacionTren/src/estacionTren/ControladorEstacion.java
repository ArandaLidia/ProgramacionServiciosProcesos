package estacionTren;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class ControladorEstacion {

    // Semáforo que regula el acceso a la estación. Permite un máximo de 5 trenes a la vez.
    public static final Semaphore semaforoEstacion = new Semaphore(5);

    // Lista para almacenar los trenes creados, tanto de carga como de pasajeros.
    private ArrayList<Thread> listaTrenes;

    // Constructor: Inicializa la lista de trenes.
    public ControladorEstacion() {
        this.listaTrenes = new ArrayList<>();
    }

    /**
     * Método para crear trenes de forma aleatoria.
     * Se generan entre 10 y 30 trenes (10 + un número aleatorio entre 0 y 20).
     * La probabilidad de que un tren sea de carga o pasajeros es 50%.
     */
    public void crearTrenes() {
        int cantidadTrenes = (int) ((Math.random() * 20) + 10); // Cantidad aleatoria de trenes entre 10 y 30.

        for (int i = 0; i < cantidadTrenes; i++) {
            int tiempoEstacion = (int) ((Math.random() * 40) + 10); // Tiempo aleatorio en la estación entre 10 y 50 unidades.

            // Crea un tren de carga o pasajeros basado en un número aleatorio.
            if (Math.random() > 0.5) {
                TrenCarga trenCarga = new TrenCarga(tiempoEstacion);
                listaTrenes.add(trenCarga); // Añade el tren de carga a la lista.
            } else {
                TrenPasajero trenPasajero = new TrenPasajero(tiempoEstacion);
                listaTrenes.add(trenPasajero); // Añade el tren de pasajeros a la lista.
            }
        }
    }

    /**
     * Método principal para ejecutar los trenes.
     * - Se inician los hilos de todos los trenes.
     * - Se utiliza `join()` para asegurarse de que todos los hilos terminen antes de continuar.
     * - Al final, se imprime un resumen de los trenes procesados.
     */
    public void run() {
        // Inicia cada tren (hilo) en la lista.
        for (Thread tren : listaTrenes) {
            tren.start();
        }

        // Espera a que todos los hilos terminen antes de continuar.
        for (Thread tren : listaTrenes) {
            try {
                tren.join();
            } catch (InterruptedException e) {
                // Maneja posibles interrupciones durante la espera de `join()`.
                System.out.println("Error en la ejecución del join.");
                e.printStackTrace();
            }
        }

        // Imprime el resumen final del número de trenes.
        System.out.printf(
            "\nResumen final:\n" +
            "- Trenes totales: %d\n" +
            "  - Trenes de carga: %d\n" +
            "  - Trenes de pasajeros: %d\n",
            TrenCarga.getContadortrenCarga() + TrenPasajero.getContadorTrenPasajero(), // Total de trenes.
            TrenCarga.getContadortrenCarga(), // Total de trenes de carga.
            TrenPasajero.getContadorTrenPasajero() // Total de trenes de pasajeros.
        );
    }
}
