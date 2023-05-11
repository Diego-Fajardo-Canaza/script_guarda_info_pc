
import java.io.*;

public class DxdiagInfo {
    public static void main(String[] args) throws IOException {
        ProcessBuilder contruir = new ProcessBuilder("cmd.exe", "/c", "dxdiag", "/t", "dxdianInfo.txt");
        contruir.redirectErrorStream(true);
        Process proceso = contruir.start();

        // Espera a que el proceso termine
        try {
            proceso.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Lee el archivo de texto generado por dxdiag
        File archivo = new File("dxdianInfo.txt");
        BufferedReader leer = new BufferedReader(new FileReader(archivo));
        String linea;
        while ((linea = leer.readLine()) != null) {
            System.out.println(linea);
        }
        leer.close();
    }
}