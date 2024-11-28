package estacionTren;

public class Entrada {

    public static void main(String[] args) {
        // Crea el controlador de la estación y genera los trenes.
        ControladorEstacion controladorEstacion = new ControladorEstacion();
        controladorEstacion.crearTrenes();

        // Inicia la simulación y espera que todos los trenes terminen.
        controladorEstacion.run();
    }
}
