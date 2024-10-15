import java.io.File;
import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Indica la ruta del archivo o directorio a buscar");
		String ruta = sc.nextLine();
		File BuscarDir = new File(ruta);
		File [] hijos = BuscarDir.listFiles();

		if(BuscarDir.exists()) {
			if (BuscarDir.isFile()) {
				System.out.println(" El archivo pesa " + BuscarDir.length() + (BuscarDir.canRead()?"se puede leer":"no se puede leer") + (BuscarDir.canWrite()?"Se puede modificar":"no se puede modificar"));
		} else
			for(File file: hijos) {
			System.out.println(file.getName() + " nombre " + (file.isFile()?"F":"D") + " con " + file.listFiles() + " archivos/directorios");
			infoFichero(file);
			}
		}
		else {
			System.out.println("no existe");
			
		 
		}
	}
	
		
	public static void infoFichero(File f) {
		System.out.println(
				(f.isFile()
				?
						f.length() +
						(f.canRead()?" r":" -") +
						(f.canWrite()?"w":"-") +
						(f.canExecute()?"x":"-")
				:"") );
	}
}
