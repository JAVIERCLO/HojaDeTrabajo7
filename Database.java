import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Database {

        public void leerData(String nombreArchivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            br.readLine();

            while ((linea = br.readLine()) != null) {
                // Expresión regular para dividir por comas que NO están dentro de comillas
                String[] datos = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                if (datos.length < 10) {
                    System.err.println("Línea con datos insuficientes: " + linea);
                    continue;
                }
            }
        }
    }
}
