package bebederoPerrera;

public class EntradaPerrera {
public static void main(String[] args) {
	Bebedero bebedero = new Bebedero();
	System.out.println("Comienza la simulación del bebedero: ");
	bebedero.calculaAgua();
	bebedero.run();
	System.out.println("La simulación ha terminado.");
}
}
