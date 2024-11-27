package bebederoPerrera;

import java.util.concurrent.Semaphore;

public class Perro extends Thread{
	private static Semaphore semaforo = new Semaphore(3);
	private int idPerro;
	private int aguaBebida;
	private int tiempoBebiendo;
	private static int contador;
	
	public Perro (int tiempoBebiendo) {
		contador ++;
		idPerro = contador;
		this.tiempoBebiendo = tiempoBebiendo;
		aguaBebida = tiempoBebiendo;
	}
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			System.out.printf("El perro con ID: %d comienza a beber agua.\n", idPerro);
			Thread.sleep(tiempoBebiendo*5);
			System.out.printf("El perro con ID: %d ha bebido %d litros y ha terminado de beber.\n", idPerro, aguaBebida);
			semaforo.release();
		} catch (InterruptedException e) {
			System.out.println("Error en la ejecución del semáforo.");
			e.printStackTrace();
		}
	}

	public static Semaphore getSemaforro() {
		return semaforo;
	}

	public static void setSemaforro(Semaphore semaforo) {
		Perro.semaforo = semaforo;
	}

	public int getIdPerro() {
		return idPerro;
	}

	public void setIdPerro(int idPerro) {
		this.idPerro = idPerro;
	}

	public int getAguaBebida() {
		return aguaBebida;
	}

	public void setAguaBebida(int aguaBebida) {
		this.aguaBebida = aguaBebida;
	}

	public int getTiempoBebiendo() {
		return tiempoBebiendo;
	}

	public void setTiempoBebiendo(int tiempoBebiendo) {
		this.tiempoBebiendo = tiempoBebiendo;
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Perro.contador = contador;
	}
	

}
