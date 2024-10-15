package ficheros;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

public class Ejercicio8 {

    private static final char SEPARADOR = ',';
    private static final char COMILLA = '"';
    public final static String FICHEROTRABAJO = "ejercicio08.csv";
    
    private static void mostrarValores(String[] fields) {
        for (int i=0; i<fields.length; i++) {
            System.out.print( "\t-" + fields[i] ); 
        }
        System.out.println();
    }

	 public static void main(String[] args) {
		 CSVReader reader = null;
		 
		 try {
			reader = new CSVReader(new FileReader(Utilidades.getRutaDatos() + FICHEROTRABAJO), SEPARADOR, COMILLA);
			String[] nextLine = null;
			try {
				while((nextLine=reader.readNext())!=null) {
					mostrarValores(nextLine);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 }
}
