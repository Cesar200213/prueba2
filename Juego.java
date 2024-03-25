package Wordle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Pre: ---
 * Post:Este programa es un simulador del wordle que dado un documento coge las palabras que tengan 5 letras y las guarda en un arraylist de objetos 
 * llamado diccionario que guarda la palabra y despues le pide al usuario que escriba palabras dandole pistas de las posibilidades que tiene el
 * usuario segun la palabra dada.
 */
public class Juego {
	static String fichero1 = "/Users/cesam/Downloads/diccionario.txt";
	static ArrayList<Diccionario> Diccionario = new ArrayList<>();
	
	/*
	 * Este metodo es el principal que muestra el menu y llama a los metodos correspondientes para su utilizacion.
	 */
	public static void main(String[] args) {
		int opcion = 1000;
		Scanner entrada = new Scanner(System.in);
		while(opcion != 0) {
			String f = fichero1;
			diccionario(f);
			mostrarMenu();
			opcion = entrada.nextInt();
			if(opcion == 1) {
				juego();
			}else if(opcion == 2) {
				for (int i = 0; i < Diccionario.size() && i < Diccionario.size(); i++) {
		            System.out.print(Diccionario.get(i) + ",");
		            if (i % 20 == 0) {
                        System.out.println();
                    }
		        }
			}else {
				break;
			}
		}
	}
	
	/*
	 * Este metodo es el que coge un numero aleatorio entre el 0 y la longitud del diccionario y asi escoge la palabra del array 
	 * llamado diccionario y empieza el juego lammando al usuario para escribir una palabra y lammando al metodo comprobar.
	 */
	private static void juego() {
		String intento = null;
		int bucle = 1;
		int largo = Diccionario.size();
		int numero = (int) Math.floor(Math.random() * (largo + 1));
		Wordle.Diccionario cambio = Diccionario.get(numero);
		String palabra = cambio.toString();
		while(bucle == 1) {
			Scanner entrada = new Scanner(System.in);
			System.out.println();
			System.out.println("Escriba una palabra: ");
			intento = entrada.next();
			bucle = comprobar(palabra, intento);
		}
	}
	
	/*
	 * Este metodo es el que comprueba cada latra de la palabra y te muestra las posibilidades que tienes solo con las letras acertadas
	 *  inicialmente si hay alguna por detras que este eacertada pero no en la posicion correcta la ignora y devuelve uno o menos uno para 
	 *  el bucle del metodo al que le ha llamado.
	 */
	private static int comprobar(String palabra, String intento) {
		int posibilidades = 0;
	    String[] palabra1Letras = palabra.split("");
	    String[] palabra2Letras = intento.split("");
	    if (palabra1Letras[0].equals(palabra2Letras[0])) {
	        if (palabra1Letras[1].equals(palabra2Letras[1])) {
	            if (palabra1Letras[2].equals(palabra2Letras[2])) {
	                if (palabra1Letras[3].equals(palabra2Letras[3])) {
	                    if (palabra1Letras[4].equals(palabra2Letras[4])) {
	                        System.out.println("Enhorabuena, has acertado la palabra: " + palabra);
	                        return -1;
	                    } else if (!palabra1Letras[4].equals(palabra2Letras[4])) {
	                        for (int i = 0; i < Diccionario.size(); i++) {
	                            Wordle.Diccionario cambio2 = Diccionario.get(i);
	                            String buscar = cambio2.toString();
	                            String[] buscar2 = buscar.split("");
	                            if (buscar2[0].equals(palabra1Letras[0]) &&
	                                buscar2[1].equals(palabra1Letras[1]) &&
	                                buscar2[2].equals(palabra1Letras[2]) &&
	                                buscar2[3].equals(palabra1Letras[3]) &&
	                                buscar2[4].equals(palabra1Letras[4])) {
	                                System.out.print(Diccionario.get(i) + " , ");
	                                posibilidades++;
	                                if (posibilidades % 15 == 0) {
	                                    System.out.println();
	                                }
	                            }
	                        }
	                    }
	                } else if (!palabra1Letras[3].equals(palabra2Letras[3])) {
	                    for (int i = 0; i < Diccionario.size(); i++) {
	                        Wordle.Diccionario cambio2 = Diccionario.get(i);
	                        String buscar = cambio2.toString();
	                        String[] buscar2 = buscar.split("");
	                        if (buscar2[0].equals(palabra1Letras[0]) &&
	                            buscar2[1].equals(palabra1Letras[1]) &&
	                            buscar2[2].equals(palabra1Letras[2])) {
	                        	System.out.print(Diccionario.get(i) + " , ");
                                posibilidades++;
                                if (posibilidades % 15 == 0) {
                                    System.out.println();
                                }
	                        }
	                    }
	                }
	            } else if (!palabra1Letras[2].equals(palabra2Letras[2])) {
	                for (int i = 0; i < Diccionario.size(); i++) {
	                    Wordle.Diccionario cambio2 = Diccionario.get(i);
	                    String buscar = cambio2.toString();
	                    String[] buscar2 = buscar.split("");
	                    if (buscar2[0].equals(palabra1Letras[0]) &&
	                        buscar2[1].equals(palabra1Letras[1])) {
	                    	System.out.print(Diccionario.get(i) + " , ");
                            posibilidades++;
                            if (posibilidades % 15 == 0) {
                                System.out.println();
                            }
	                    }
	                }
	            }
	        } else if (!palabra1Letras[1].equals(palabra2Letras[1])) {
	            for (int i = 0; i < Diccionario.size(); i++) {
	                Wordle.Diccionario cambio2 = Diccionario.get(i);
	                String buscar = cambio2.toString();
	                String[] buscar2 = buscar.split("");
	                if (buscar2[0].equals(palabra1Letras[0])) {
	                	System.out.print(Diccionario.get(i) + " , ");
                        posibilidades++;
                        if (posibilidades % 15 == 0) {
                            System.out.println();
                        }
	                }
	            }
	        }
	    } else {
	        System.out.println("No has dado ni la primera letra :) prueba empezando por: " + palabra1Letras[0]);
	    }
		return 1;
	}
	
	/*
	 * Este metodo es genera el diccionario donde se va a guardar todas las palabras que sean de 5 letras.
	 */
	private static void diccionario(String f) {
		File file = new File(f);
		try {
			int numLineas = 0;
			Scanner f1 = new Scanner(file);
			while(f1.hasNextLine()) {
				String linea = f1.nextLine();
				String datos = linea;
				if(datos.length() == 5) {
					Diccionario datos2 = new Diccionario(datos);
					Diccionario.add(datos2);
				}
				numLineas++;
			}
		} catch(FileNotFoundException e) {
			System.out.println("El fichero " + f + " no ha podido ser abierto.");
		}
	}
	
	/*
	 * Este metodo es un simple menu.
	 */
	public static void mostrarMenu() {
		System.out.println("Selecciona una opción: ");
		System.out.println("  1) Jugar: ");
		System.out.println("  2) Mostrar diccionario: ");
		System.out.print("Opción seleccionada (0 para finalizar): ");
	}
}
