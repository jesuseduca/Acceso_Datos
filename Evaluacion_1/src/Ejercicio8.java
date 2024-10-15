
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import ejercicio6.Ejercicio3;


public class Ejercicio8 {

    private static final String SEPARADOR = ",";
    private static final String COMILLA = "\"";
    public final static String FICHEROTRABAJO = "ejercicio08.csv";
    
    public static void main(String[] args) {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(Ejercicio3.RUTA_DATOS + FICHEROTRABAJO));
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(SEPARADOR);
                fields = eliminaComillas(fields);   
                mostrarValores(fields);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String[] eliminaComillas(String[] fields) {
        for (int i = 0; i < fields.length; i++) {
            fields[i] = fields[i].replace(COMILLA, "");
        }
        return fields;
    }

    private static void mostrarValores(String[] fields) {
        for (String field : fields) {
            System.out.print(field + " "); 
        }
        System.out.println();
    }
}
