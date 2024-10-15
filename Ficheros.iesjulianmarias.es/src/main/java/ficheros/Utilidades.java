package ficheros;

public class Utilidades {
	public final static String RUTA_DATOS = System.getProperty("user.dir") +
			System.getProperty("file.separator") + "src" + 
			System.getProperty("file.separator") + "main" + 
			System.getProperty("file.separator") + "resources" + 
			System.getProperty("file.separator");

	public static String getRutaDatos() {
		return RUTA_DATOS;
	}
}
