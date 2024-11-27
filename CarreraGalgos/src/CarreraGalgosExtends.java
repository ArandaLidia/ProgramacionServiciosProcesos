	import java.util.ArrayList;
import java.util.Scanner;

public class CarreraGalgosExtends extends Thread {


	    
	    private String nombre;
	    private int tiempoCarrera;
	    
	    public CarreraGalgosExtends(String nombre, int tiempoCarrera) {
	        this.nombre = nombre;
	        this.tiempoCarrera = tiempoCarrera;
	    }
	    
	    @Override
	    public void run() {
	        try {
	            System.out.printf("El galgo %s empieza a correr.%n", nombre);
	            Thread.sleep(tiempoCarrera * 1000);
	            System.out.printf("El galgo %s ha terminado la carrera.%n", nombre);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("¿Cuántos galgos corren en la carrera?");
	        int numGalgos = scanner.nextInt();
	        scanner.nextLine();

	        ArrayList<CarreraGalgosExtends> listaGalgos = new ArrayList<>();

	        for (int i = 0; i < numGalgos; i++) {
	            System.out.println("Inserta el nombre del galgo " + (i + 1) + ":");
	            String nombre = scanner.nextLine();
	            int tiempo = (int)(Math.random()*10);

	            CarreraGalgosExtends carreraGalgos = new CarreraGalgosExtends(nombre, tiempo);
	            listaGalgos.add(carreraGalgos);
	        }

	        for (CarreraGalgosExtends galgo : listaGalgos) {
	            galgo.start();
	        }
	        scanner.close();
	      
	    }
	}


