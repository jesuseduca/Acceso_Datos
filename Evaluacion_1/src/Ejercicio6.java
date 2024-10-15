import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import ejercicio6.MyObjectOutputStream;

public class Ejercicio6 {
	private static RandomAccessFile RFile;
	private static Scanner sc = new Scanner(System.in);
	private static ObjectOutputStream  oOS;
	
	private final static String DATOSFILEOUT = "FicheroSerializaPersonas.dat";
	
	public static void inicializar(){
		try {
		File file = new File(Ejercicio3.RUTA_DATOS + DATOSFILEOUT);
		if (file.exists() && file.length()>0) {
			 oOS = new MyObjectOutputStream(new FileOutputStream( file,  true));
			
		} else {
			 oOS = new ObjectOutputStream(new FileOutputStream( file,  true));

		}
		}catch (FileNotFoundException e){
			System.out.println("No se encuentra el fichero");
		} catch (IOException e){
			System.out.println("Error de entrada/salida");
		}
		}
	
	
	
	public static Persona obtenerDatos() {
		Persona persona = new Persona();
		
		System.out.println("DATOS DE USUARIO");
		System.out.println("\tNombre:");
		persona.setNombre(new StringBuilder(sc.nextLine()));
		System.out.println("\tPrimer Apellido");
		persona.setApellido1(new StringBuilder(sc.nextLine()));
		System.out.println("\tSegundo Apellido");
		persona.setApellido2(new StringBuilder(sc.nextLine()));
		System.out.println("\tFecha de Nacimiento (dd-MM-yyyy):");
		try {
			persona.setNacimiento(new SimpleDateFormat("dd-MM-yyyy").parse(sc.nextLine()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return persona;
		
	}
	
	public static void escribirObjeto(Persona persona) {
		
		
		try {
		
		oOS.writeObject(persona);
		
		} catch (FileNotFoundException e) {
			System.out.println("Error de fecha de nacimiento");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		
	}
	
	
	public static void LeerObjeto() {
		try {
			ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(new File(Ejercicio3.RUTA_DATOS+DATOSFILEOUT)));
			while(true) {
				try {
					System.out.println((Persona) oIS.readObject());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (EOFException e) {
	                break;
				}
				}
		} catch (IOException e) {
			System.out.println("Error de lectura");
			e.printStackTrace();
		}
		
	}
	
	
	public static void lee1YEscribePersonaV2() {
		try {
			ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(new File(Ejercicio3.RUTA_DATOS+DATOSFILEOUT)));
			while(true) {
				try {
					System.out.println((Persona) oIS.readObject());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (EOFException e) {
	                break;
				}
				}
			

			try {
			
			oOS.writeObject(persona);
			
			} catch (FileNotFoundException e) {
				System.out.println("Error de fecha de nacimiento");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Error");
				e.printStackTrace();
			}
			
			
		} catch (IOException e) {
			System.out.println("Error de lectura");
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		
		inicializar();
		escribirObjeto(obtenerDatos());
		escribirObjeto(obtenerDatos());
		LeerObjeto();
		try {
			oOS.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	
}
