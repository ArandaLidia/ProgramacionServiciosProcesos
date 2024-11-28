package estacionTren;

import java.util.concurrent.Semaphore;

public class TrenPasajero extends Thread {
    // Semáforos para controlar el acceso a la estación y a la vía de pasajeros.
    private static Semaphore semaforoEstacion = ControladorEstacion.semaforoEstacion;
    private static Semaphore semaforoTrenPasajero = new Semaphore(4);
    private static int contadorTrenPasajero = 0; // Contador de trenes de pasajeros.
    private int idTrenPasajero; // ID único del tren de pasajero.
    private int tiempoVia; // Tiempo de estancia en la estación.

    // Constructor que asigna ID y tiempo de estancia.
    public TrenPasajero(int tiempoVia) {
        contadorTrenPasajero++;
        this.idTrenPasajero = contadorTrenPasajero;
        this.tiempoVia = tiempoVia;
    }

    @Override
    public void run() {
        try {
            semaforoEstacion.acquire(); // Accede a la estación.
            semaforoTrenPasajero.acquire(); // Accede a la vía de pasajeros.
            System.out.printf("Tren de pasajero %d entrando a la estación y ocupando la vía de pasajeros...\n", idTrenPasajero);
            Thread.sleep(tiempoVia * 100); // Simula el tiempo de estancia.
            System.out.printf("Tren de pasajero %d saliendo de la vía de pasajeros y de la estación.\n", idTrenPasajero);
            semaforoTrenPasajero.release(); // Libera la vía de pasajeros.
            semaforoEstacion.release(); // Libera el acceso a la estación.
        } catch (InterruptedException e) {
            e.printStackTrace(); // Manejo de interrupciones.
        }
    }

    // Métodos de acceso a semáforos y al contador de trenes.
    public static Semaphore getSemaforoEstacion() {
        return semaforoEstacion;
    }

    public static void setSemaforoEstacion(Semaphore semaforoEstacion) {
        TrenPasajero.semaforoEstacion = semaforoEstacion;
    }

    public static Semaphore getSemaforoTrenPasajero() {
        return semaforoTrenPasajero;
    }

    public static void setSemaforoTrenPasajero(Semaphore semaforoTrenPasajero) {
        TrenPasajero.semaforoTrenPasajero = semaforoTrenPasajero;
    }

    public static int getContadorTrenPasajero() {
        return contadorTrenPasajero;
    }

    public void setContadorTrenPasajero(int contadorTrenPasajero) {
        TrenPasajero.contadorTrenPasajero = contadorTrenPasajero;
    }

    public int getIdTrenPasajero() {
        return idTrenPasajero;
    }

    public void setIdTrenPasajero(int idTrenPasajero) {
        this.idTrenPasajero = idTrenPasajero;
    }

    public int getTiempoVia() {
        return tiempoVia;
    }

    public void setTiempoVia(int tiempoVia) {
        this.tiempoVia = tiempoVia;
    }
}
