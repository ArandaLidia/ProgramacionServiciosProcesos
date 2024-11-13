import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarreraGalgosImplements implements Runnable {
	
	 private String nombre;
	 private int tiempoCarrera;
	
	 
	 public CarreraGalgosImplements(String nombre, int tiempoCarrera) {
		this.nombre = nombre;
		this.tiempoCarrera = tiempoCarrera;
	}
	 
	 
	public void carrera() {
		 try {
			System.out.printf("El galgo %s empieza la carrera.\n", nombre);
			Thread.sleep(tiempoCarrera*1000);
			System.out.printf("El galgo %s termina la carrera.\n", nombre);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	 }
	 
	
	 public void run() {
			this.carrera();
		}
	 
	 
	 public static void main(String[] args) {
		 Scanner scanner = new Scanner (System.in);
		System.out.println("¿Cuántos galgos corren en la carrera?");
		int numgalgos=scanner.nextInt();
		ArrayList<CarreraGalgosImplements> listaGalgos=new ArrayList<>();
		
		for(int i=0; i<numgalgos; i++) {
			System.out.println("¿Cómo se llama el galgo "+(i+1)+"?");
			String nombre= scanner.next();
			
			int tiempo=(int)(Math.random()*10);
			CarreraGalgosImplements galgo=new CarreraGalgosImplements(nombre, tiempo);
			listaGalgos.add(galgo);
		}
		
		for(CarreraGalgosImplements item: listaGalgos) {
			new Thread(item).start();
		}
		
	}
	 
	
}
