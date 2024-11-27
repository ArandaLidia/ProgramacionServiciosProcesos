package donaciones;

public class ModelAlumno extends Thread {

	
	private int idAlumno;
	private static int contador;
	private int cantidadDonada;
	
	
	public ModelAlumno(int cantidadDonada) {
		contador ++;
		idAlumno = contador;
		this.cantidadDonada =  cantidadDonada;
	}
	
	@Override
	public void run() {
		try {
			System.out.printf("El alumno con ID: %d comienza a donar.\n", idAlumno);
			Thread.sleep(cantidadDonada);
			System.out.printf("El alumno con ID: %d ha donado la cantidad de %d y ha terminado de donar.\n", idAlumno, cantidadDonada);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Fallo al dormir el hilo.");
		}
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		ModelAlumno.contador = contador;
	}

	public int getCantidadDonada() {
		return cantidadDonada;
	}

	public void setCantidadDonada(int cantidadDonada) {
		this.cantidadDonada = cantidadDonada;
	}

}
