package donaciones;

import java.util.ArrayList;
import java.util.Iterator;

public class ControllerAlumnos {

	ArrayList<ModelAlumno> listaAlumnos;
	private int cantidadAlumnos= (int) ((Math.random()*20)+1);
	ModelAlumno alumno;
	public ControllerAlumnos() {
		this.listaAlumnos = new ArrayList<ModelAlumno>();
		
	}
	
	
	public void donar() {
		for(int i =0 ; i< cantidadAlumnos; i++) {
			alumno = new ModelAlumno((int) ((Math.random()*1000)+1));
			listaAlumnos.add(alumno);
		}
	}
	
	public ArrayList<ModelAlumno> getListaAlumnos() {
		return listaAlumnos;
	}


	public void setListaAlumnos(ArrayList<ModelAlumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}


	public int getCantidadAlumnos() {
		return cantidadAlumnos;
	}


	public void setCantidadAlumnos(int cantidadAlumnos) {
		this.cantidadAlumnos = cantidadAlumnos;
	}


	public void run() {
		for(ModelAlumno alumno : listaAlumnos) {
			alumno.start();
		}
		for(ModelAlumno alumno : listaAlumnos) {
			try {
				alumno.join();
			} catch (InterruptedException e) {
				System.out.println("Fallo al ejecutar el join.");
				e.printStackTrace();
			}
		}
		int recaudacionTotal = 0;
		for(ModelAlumno alumno : listaAlumnos) {
			recaudacionTotal+=alumno.getCantidadDonada();
		}
		System.out.printf("Han donado el total de %d alumnos.\n", ModelAlumno.getContador());
		System.out.printf("Las donaciones totales son: %d € \n", recaudacionTotal);
	}
}
