package ejercicio6;
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

public class Ejercicio6 {
	private static RandomAccessFile RFile;
	private static Scanner sc = new Scanner(System.in);

	private final static String DATOSFILEOUT = "FicheroSerializaPersonas.dat";
	
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
		
		ObjectOutputStream datos = new ObjectOutputStream(new FileOutputStream(new File(Ejercicio3.RUTA_DATOS + DATOSFILEOUT), true));
		datos.writeObject(persona);
		datos.close();
		
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
			ObjectInputStream datos = new ObjectInputStream(new FileInputStream(new File(Ejercicio3.RUTA_DATOS+DATOSFILEOUT)));
			while(true) {
				try {
					System.out.println((Persona) datos.readObject());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}finally {
					datos.close();
				}
			}
		} catch (IOException e) {
			System.out.println("Error de lectura");
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		
		//escribirObjeto(obtenerDatos());
		escribirObjeto(obtenerDatos());
		LeerObjeto();
		

	}
	
	
	
	
}
