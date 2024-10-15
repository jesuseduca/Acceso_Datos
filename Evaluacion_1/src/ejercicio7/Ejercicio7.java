package ejercicio7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Properties;
import java.util.Scanner;

import ejercicio6.MyObjectOutputStream;

public class Ejercicio7 {

	private static Properties conf = new Properties();
	private final static String FICHEROTRABAJO = "configuracion.props";
	private static ObjectOutputStream  oOS;
	
	public static void main(String[] args) {

		crearConfiguracion();
		System.out.println("DOCUMENTO ORIGINAL");
		leerConfiguracion();
		modificaConfiguracion();
		leerConfiguracion();
		
	}

	private static void modificaConfiguracion() {
		Scanner sc = new Scanner (System.in);
		
		System.out.println("MODIFICANDO CONFIGURACIÓN");
		System.out.println("user: ");
		String usuario = sc.nextLine();
		System.out.println("password");
		String password = sc.nextLine();
		System.out.println("server: ");
		String servidor = sc.nextLine();
		System.out.println("valor a sumar al puerto: ");
		int puerto = Integer.valueOf(sc.nextLine()) + 1;
		System.out.println("nuevo mes para la fecha");
		int mes = Integer.valueOf(sc.nextLine());

		boolean power = Boolean.valueOf(sc.nextLine());
		try {
			
		
		conf.load(new FileInputStream(Ejercicio3.RUTA_DATOS+FICHEROTRABAJO));
		conf.setProperty("user", usuario);
		conf.setProperty("password", password);
		conf.setProperty("server", servidor);
		conf.setProperty("port", String.valueOf(puerto));
		//Tomo la propiedad (String) la paso a parseo a LocalDate, le modifico el mes (withMonth) y la transformo en string
		conf.setProperty("date", String.valueOf(
				LocalDate.parse(conf.getProperty("date")).withMonth(mes)));
		//Cambio el valor del power
		conf.setProperty("power", String.valueOf(!(Boolean.valueOf(conf.getProperty("power")))));
		conf.store(new FileOutputStream(Ejercicio3.RUTA_DATOS+FICHEROTRABAJO), "fichero de configuracion");
		
		} catch (FileNotFoundException e) {
			System.out.println("generic error 1");
		} catch (IOException e) {
			System.out.println("Generic error 2");
		}
	}

	private static void leerConfiguracion() {
		try {
		conf.load(new FileInputStream(Ejercicio3.RUTA_DATOS+FICHEROTRABAJO));
		conf.list(System.out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void crearConfiguracion() {
		conf.setProperty("user", "usuario");
		conf.setProperty("password", "micontrasena");
		conf.setProperty("server", "localhost");
		conf.setProperty("port", "3306");
		conf.setProperty("date", "11-08-2022");
		conf.setProperty("power", "true");
		try {
		conf.store(new FileOutputStream(Ejercicio3.RUTA_DATOS+FICHEROTRABAJO), "Fichero de Configuración");
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}








}