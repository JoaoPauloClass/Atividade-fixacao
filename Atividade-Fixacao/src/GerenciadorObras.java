import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GerenciadorObras {
    
    private static final String ARQUIVO = "obras.txt";

    public static void salvarObra(Obra obra) throws IOException {

        try (FileWriter fw = new FileWriter(ARQUIVO, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(obra.toString() + "\n");
        }

    }

    public static void atualizar() throws IOException{
        String linha;
            try (FileReader fr = new FileReader(ARQUIVO);
                    BufferedReader br = new BufferedReader(fr)) {

                while ((linha = br.readLine()) != null) {

                    Obra obra = Obra.fromString(linha);
                    ListaObras.adicionarObra(obra);;
                }
            }

    }

    public static void apagarObra() throws IOException{
        String linha;
            try (FileReader fr = new FileReader(ARQUIVO);
                    BufferedReader br = new BufferedReader(fr)) {

                while ((linha = br.readLine()) != null) {
                    String[] dadosObras = linha.split(", ");
                    
                }
            }
    }


}
