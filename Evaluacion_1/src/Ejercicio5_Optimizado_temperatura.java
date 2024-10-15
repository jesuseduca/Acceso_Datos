import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio5_Optimizado_temperatura {
	private static RandomAccessFile RFile;
	private final static String DATOSFILEOUT = "FicheroAleatorioTemperaturas.dat";
	//TODO revisar
	private final static int TAMANIO = 13; 
	 
	
	

	public static void main(String[] args) {
		try {
			RFile = new RandomAccessFile(new File(Ejercicio3.RUTA_DATOS + DATOSFILEOUT), "rw");		
			escribir("");
			menu();
			RFile.close();
		} catch (IOException e) {
			System.out.println("Error apertura/creación fichero");
			e.printStackTrace();
		}
	}

	/***
	 * Escribe el contenido de todo el fichero (mes, temperatura minima y máxima) o modifica el valor de una posición determinada 
	 *  (mes, posición y nueva temperatura mínima y/o máxima se pasarán como parámetros) o añade temperatura al final
	 * @param valores
	 * @param mes
	 * 		si vacio, inicializa el fichero con valores tomados de 3 arrays
	 * 		si tiene dos valores, se toman como temperatura mínima y máxima y se añade al final
	 * 		si tiene tres valores, el primero es tomado como posición a sobreescribir con el string (mes) y los otros dos enteros (temperatuta mínima y máxima)
	 * @return
	 * 		true si se hizo con éxito
	 * 		false en caso de error
	 * 
	 */		
	
	public static boolean escribir(String mes, int ...valores) {
		try {
			if(valores.length==0) {
				String[] meses = {"ene", "feb", "mar", "abr", "may", "jun",};
				int [] tem_min = {0, -1, 4, 10 ,15 ,15};
				int [] tem_max = {17,18,20,22,22,25};
				for(int i=1; i<=meses.length; i++) {
				
					RFile.writeUTF(meses[i]);
					RFile.writeInt(tem_min[i]);
					RFile.writeInt(tem_max[i]);
				}	
					
				return true;
			}else if (valores.length==2) {
				//Añadimos al final el fichero
				RFile.seek(RFile.length());	
				RFile.writeUTF(mes);
				RFile.writeInt(valores [0]);
				RFile.writeInt(valores [1]);
				return true;
			}else if (valores.length==3) {
				long posicion = (valores[0]-1)*TAMANIO;
				if (posicion>=RFile.length() || valores[0]<=0) {
					System.out.println("No existe ningún valor en esa posición");
					return false;
				}
				RFile.seek(posicion);
				RFile.writeUTF(mes);
				RFile.writeInt(valores [0]);
				RFile.writeInt(valores [1]);
				return true;
			}else {
				throw new Exception("Número de parámetros incorrecto");
			}
			
		} catch (IOException e) {
			System.out.println("Error de escritura");
			e.printStackTrace();
			return false;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * Lee y muestra por consola el contenido de todo el fichero de acceso aleatorio o el valor de la posición pasada como parámetro
	 * @param lugar
	 * @return
	 * 		número de elementos leidos
	 * 		o 0 en caso de leer de una posición pasada por parámetro
	 * 		o -1 si error  
	 */
	
	public static int leer(int ...lugar) {
		
		try {
			
			if (lugar.length==0) {
				int i=0;
				RFile.seek(0);
				while(RFile.getFilePointer()!=RFile.length()) {
					System.out.println("mes: " + RFile.readUTF() + "\tmínima " + RFile.readInt()  + "\tmáxima " + RFile.readInt());
					i++;
				}
				return i;
			}
			long posicion = (lugar[0]-1)*TAMANIO;
			if (posicion>=RFile.length() || lugar[0]<=0) {
				System.out.println("No existe ningún valor en esa posición");
				return -1;
			}
			RFile.seek(posicion);
			System.out.println("mes: " + RFile.readUTF() + "\tmínima " + RFile.readInt()  + "\tmáxima " + RFile.readInt());
			return 0;
		} catch (IOException e) {
			System.out.println("Error de lectura");
			e.printStackTrace();
			return -1;
		}
	}
	

	/**
	 * muestra el menú de opciones
	 */
	public static void menu() {

		Scanner sn = new Scanner(System.in);
		boolean salir = false;
		int posicion, minima, maxima;
		String mes;
		while(!salir) {
			System.out.println("\n1. Leer fichero");
			System.out.println("2. Consultar una posición");
			System.out.println("3. Añadir al final");
			System.out.println("4. Modificar valor");
			System.out.println("5. Salir");
			try {
				System.out.println("Escribe una de las opciones: ");
				switch(sn.nextInt()){
				case 1:
					System.out.println("LEYENDO EL CONTENIDO DEL FICHERO");
					leer();
					break;
				case 2:
					System.out.println("CONSULTANDO POSICIÓN DEL FICHERO");
					System.out.println("indique la posición a consultar (valor numérico): ");
					posicion = sn.nextInt();
					int value;
					leer(posicion);
					break;
				case 3:
					System.out.println("AÑADIENDO ELEMENTO AL FINAL DEL FICHERO");
					System.out.println("indique valor del mes (tres letras): ");
					mes = sn.next();
					System.out.println("indica la tewmperatura mínima");
					minima = sn.nextInt();
					System.out.println("indica la tewmperatura máxima");
					maxima = sn.nextInt();
					System.out.println(escribir(mes,minima,maxima)?"Temepraturas añadidas correctamente":"Error, no se ha podido");
					break;
				case 4:
					System.out.println("MODIFICANDO VALOR EN POSICIÓN");
					System.out.println("indique posición: ");
					posicion = sn.nextInt();
					System.out.println("indique valor del mes (tres letras): ");
					mes = sn.next();
					System.out.println("indica la tewmperatura mínima");
					minima = sn.nextInt();
					System.out.println("indica la tewmperatura máxima");
					maxima = sn.nextInt();
					System.out.println(escribir(mes,posicion,minima,maxima)?"Valor modificado correctamente":"ERROR: Valor no modificado");
					break;
				case 5:
					salir = true;
					break;
				default:
					System.out.println("Solo números entre 1 y 5");
					break;
				}
			}catch(InputMismatchException e) {
				System.out.println("Debes escribir un número");
				sn.next();
			}
		}
		
	}
}


