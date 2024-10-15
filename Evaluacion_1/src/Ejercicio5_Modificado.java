import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;


public class Ejercicio5_Modificado {
	private static RandomAccessFile RFile;
	private final static String DATOSFILEOUT = "FicheroAleatorio.dat";
	private final static int TAMANIO = 4;
	public static void main(String[] args) {
		escribir();
		leer();
	
	
	}
	
	public static int escribir() {
		try {
		RandomAccessFile RFile = new RandomAccessFile(new File(Ejercicio3.RUTA_DATOS + DATOSFILEOUT), "rw" );
		for(int i=1; i<100 ; i++) {
			RFile.write(i);
			RFile.close();
			return i;	

		}
	} catch (FileNotFoundException e) {
		System.out.println("ERROR");
		e.printStackTrace();
	} catch (IOException e) {
		System.out.println("ERROR de escritura");
		e.printStackTrace();
		
	}
	return 0;
		
	}
	
	
	public static int leer(int ...lugar) {
		try {
			if(lugar.length==0) {
			int i=0;
			RFile.seek(0);
			while(RFile.getFilePointer()!=RFile.length()) {
				System.out.println(RFile.readInt());
				i++;
			}
			return i;
		}
			long posicion = (lugar[0]-1)*TAMANIO;
			if (posicion>=RFile.length() || lugar[0]<=0) {
				System.out.println("no esiste");
				return -1;
			}
			RFile.seek(posicion);
			return RFile.readInt();
			
	} catch (FileNotFoundException e) {
		System.out.println("ERROR");
		e.printStackTrace();
		return -1;
	}
	catch (IOException e) {
		System.out.println("ERROR de escritura");
		e.printStackTrace();
		return -1;
	}
		}
	
	
	public static int consultar(int lugar) {
		try {
			long posicion = (lugar-1)*TAMANIO;
			if (posicion>=RFile.length() || lugar <=0) {
				System.out.println("No existe valor en esta posivion");
				return -1;
			}
			RFile.seek(posicion);
			return RFile.readInt();
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
	
	}

	
	public static boolean anadirFinal(int valor) {
		try {
		RFile.seek(RFile.length());
		RFile.writeInt(valor);
		return true;
		
	} catch (FileNotFoundException e) {
		System.out.println("ERROR");
		e.printStackTrace();
	} catch (IOException e) {
		System.out.println("ERROR de escritura");
		e.printStackTrace();
		
	}
	return 0;
		
	}
	
	
	public static boolean modificarValor(int valor, int lugar) {
	try {
		long posicion = (lugar-1)*TAMANIO;
	if (posicion>=RFile.length() || lugar <=0) {
		System.out.println("No existe valolr final");
		return false;	
	}
		RFile.seek(posicion);
		RFile.writeInt(valor);
		return true;
	}catch (IOException e) {
		e.printStackTrace();
	}
	
	
	}
		
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		int posicion, valor;
		while(!salir) {
			System.out.println("\n1. Leer fichero");
			System.out.println("2. Consultar una posicion");
			System.out.println("3. Añadir al final");
			System.out.println("4. Modificar valor");
			System.out.println("5. Salir");
			System.out.println("Escoge una opcion: ");
			switch(sc.nextInt()) {
			case 1:
				System.out.println("LEYENDO CONTENT FICHERO");
				leer();
				break;
			case 2:
				System.out.println("Consultando cosas");
				System.out.println("di la posicion a consultar (valor numerico): ");
				posicion = sc.nextInt();
				System.out.println("Valor en la posicion" + posicion + ": " + ((consultar(posicion)==-1)?"No":"talvez"));	
				break;
			case 3:
				System.out.println("AÑADIENMDO ELOEMENTO");
				System.out.println("di el valor numerico a añadir : ");
				valor = sc.nextInt();
				System.out.println(anadirFinal(valor)?"Valor añadido correctamente":"ERROR: Valor no añadido");
				break;
			case 4:
				System.out.println("MODIFICAR VALOR EN POSICION");
				System.out.println("di la posicion:  ");
				posicion = sc.nextInt();
				System.out.println("Indica la nueva");
				valor = sc.nextInt();
				System.out.println(modificarValor(valor,posicion)?"Valor modificado":"ERROR,no se pudo");
				break;	
			case 5:
			salir = true;
				break;
			default:
				System.out.println();
			
			}
			
		}
	}
	
}