package classes;

import java.util.ArrayList;

public class Genero {
	
	public Genero() {
		
	}

	public static void main(String[] args) {

		ArrayList<String> generos = new ArrayList<>();
		generos.add("A��o");
		generos.add("Aventura");
		generos.add("Drama");
		generos.add("Com�dia");
		generos.add("Suspense");
		generos.add("Terror");
		
		for(String x: generos) {
		System.out.println(x);}

	}
}