import java.io.File;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	File dirActual = new File(System.getProperty("user.dir"));
	File [] hijos = dirActual.listFiles();
	System.out.println("Nombre del directorio de trabajo actual: " + dirActual.getAbsolutePath() + " tiene " + hijos.length + " ficheros o directorios ");
	
	for(File file: hijos) {
		System.out.println(file.getName() + " nombre " + (file.isFile()?"F":"D"));
	}
	}
	
}
