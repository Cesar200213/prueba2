package Wordle;

/**
 * Pre: ---
 * Post:Este es un objeto que simplemente guarda la palabra que le manden y puede cogerla si hace falta para utilizarla mas a delante.
 */
public class Diccionario {
	private String palabra;

	public Diccionario(String palabra) {
		this.setPalabra(palabra);
	}

	public String getPalabra() {
		return palabra;
	}
	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	
	public String toString() {
		return palabra;
	}
}
