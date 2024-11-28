package estacionTren;

import java.util.concurrent.Semaphore;

public class TrenCarga extends Thread {
    
    // Semáforos para controlar el acceso a la estación y a la vía de carga.
    private static Semaphore semaforoEstacion = ControladorEstacion.semaforoEstacion;
    private static Semaphore semaforoTrenCarga = new Semaphore(2);
    private static int contadortrenCarga = 0; // Contador de trenes de carga.
    private int idTrenCarga; // ID único del tren de carga.
    private int tiempoVia; // Tiempo de estancia en la estación.

    // Constructor que asigna ID y tiempo de estancia.
    public TrenCarga(int tiempoVia) {
        contadortrenCarga++;
        this.idTrenCarga = contadortrenCarga; 
        this.tiempoVia = tiempoVia;
    }

    @Override
    public void run() {
        try {
            semaforoEstacion.acquire(); // Accede a la estación.
            semaforoTrenCarga.acquire(); // Accede a la vía de carga.
            System.out.printf("Tren de carga %d entrando a la estación y ocupando la vía de carga.\n", idTrenCarga);
            Thread.sleep(tiempoVia * 100); // Simula el tiempo de estancia.
            System.out.printf("Tren de carga %d saliendo de la vía de carga y de la estación.\n", idTrenCarga);
            semaforoTrenCarga.release(); // Libera la vía de carga.
            semaforoEstacion.release(); // Libera la estación.
        } catch (InterruptedException e) {
            e.printStackTrace(); // Manejo de interrupciones.
        }
    }

    // Métodos de acceso a semáforos y al contador de trenes.
    public static Semaphore getSemaforoEstacion() {
        return semaforoEstacion;
    }

    public static void setSemaforoEstacion(Semaphore semaforoEstacion) {
        TrenCarga.semaforoEstacion = semaforoEstacion;
    }

    public static Semaphore getSemaforoTrenCarga() {
        return semaforoTrenCarga;
    }

    public static void setSemaforoTrenCarga(Semaphore semaforoTrenCarga) {
        TrenCarga.semaforoTrenCarga = semaforoTrenCarga;
    }

    public static int getContadortrenCarga() {
        return contadortrenCarga;
    }

    public static void setContadortrenCarga(int contadortrenCarga) {
        TrenCarga.contadortrenCarga = contadortrenCarga;
    }

    public int getIdTrenCarga() {
        return idTrenCarga;
    }

    public void setIdTrenCarga(int idTrenCarga) {
        this.idTrenCarga = idTrenCarga;
    }

    public int getTiempoVia() {
        return tiempoVia;
    }

    public void setTiempoVia(int tiempoVia) {
        this.tiempoVia = tiempoVia;
    }
}

