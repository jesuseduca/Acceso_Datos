package dom;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ejercicio3 {
	
	public final static String RUTA_DATOS = System.getProperty("user.dir") +
			System.getProperty("file.separator") + "src" + System.getProperty("file.separator") +
			"data" + System.getProperty("file.separator");
	
	private final static String DATOSFILE = "3_Ejercicio.csv";
	public static void main(String[] args) {
		try {
			
			BufferedReader bfRd  = new BufferedReader(new FileReader(RUTA_DATOS+DATOSFILE));
			String linea;
			while ((linea = bfRd.readLine())!= null){
				System.out.println(linea);
			}
			bfRd.close();
			
			PrintWriter pW = new PrintWriter(new FileWriter(RUTA_DATOS+DATOSFILE, true));
			pW.println("Jose;Gómez;DAM;2");
			pW.flush();
		    pW.close();
		} catch (FileNotFoundException e) {
			System.out.println(" ERROR : fichero no existe ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(" ERROR : de lectura ");
			e.printStackTrace();
		}
	}

}
