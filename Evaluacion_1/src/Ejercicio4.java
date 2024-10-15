import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class Ejercicio4 {
	
	private final static String DATOSFILEIN = "imagen.jpg";
	private final static String DATOSFILEOUT = "imagen_copia_2.jpg";


	
	public static void main(String[] args) {
		try {
			
		
		FileInputStream fIS = new FileInputStream(new File(Ejercicio3.RUTA_DATOS+DATOSFILEIN));
		FileOutputStream fOS = new FileOutputStream(new File(Ejercicio3.RUTA_DATOS+DATOSFILEOUT));
	/*	
		int leido;
		
		
		while((leido = fIS.read())!=-1) {
			fOS.write(leido);
		}*/
		fOS.write(fIS.readAllBytes());
		fIS.close();
		fOS.close();
		
		
		} catch (FileNotFoundException e) {
			System.out.println("ERROR ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("otro error ");
			e.printStackTrace();
		}
	}

}
