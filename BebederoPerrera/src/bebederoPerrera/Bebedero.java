package bebederoPerrera;
import java.util.ArrayList;

public class Bebedero {

	ArrayList<Perro>listaPerros ;
	Perro perro;
	
	public Bebedero() {
		listaPerros = new ArrayList<Perro>();
	}
	
	public void calculaAgua() {
		
		for(int i = 0; i<((Math.random()*20)+1); i++){
			int tiempoBebiendo= (int) ((Math.random()*10)+1);
			Perro perro = new Perro(tiempoBebiendo);
			listaPerros.add(perro);
		}
	}
	
	public void run() {
		for(Perro perro : listaPerros) {
			perro.start();
		}
		for(Perro perro : listaPerros) {
			try {
				perro.join();
			} catch (InterruptedException e) {
				System.out.println("Error en la ejecución del join.");
				e.printStackTrace();
			}
		}
		int aguaAcumulada= 0;
		for(Perro perro : listaPerros) {
			aguaAcumulada += perro.getAguaBebida();
		}
		System.out.printf("Han bebido %d perros.\n", Perro.getContador());
		System.out.printf("Los perros han bebido un total de: %d litros.\n", aguaAcumulada);
	}
	
}
