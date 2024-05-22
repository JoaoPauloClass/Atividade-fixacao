import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class GerenciadorObras {
    
    private static final String ARQUIVO = "obras.txt";

    

    public static void atualizarSistema() throws IOException{
        //metodo para sincronizar o sistema com os dados cadastrados no banco
        String linha;
        try (FileReader fr = new FileReader(ARQUIVO);
            BufferedReader br = new BufferedReader(fr)) {

            while ((linha = br.readLine()) != null) {

                Obra obra = Obra.fromString(linha);
                ListaObras.adicionarObra(obra);
            }
        }

    }

    public static void atualizarDados() throws IOException{
        //metodo para sincronizar o banco com os dados do sistema
  
        try (FileWriter fw = new FileWriter(ARQUIVO, false);
            BufferedWriter bw = new BufferedWriter(fw)) {
            for (Obra tempObra : ListaObras.getListaObras()) {
                bw.write(tempObra.toString() + "\n");
        }
                    
   }

    }


    public static void apagarObra(String nome) throws IOException{
        String linha;
        
            try (
                FileReader fr = new FileReader(ARQUIVO);
                BufferedReader br = new BufferedReader(fr)) {

                while ((linha = br.readLine()) != null) {
                    String[] dadosObras = linha.split(", ");

                    if (dadosObras[0].equals(nome)) {
                        
                    }
                    
                }
            }
    }
    public static void salvarObra(Obra obra) throws IOException {

            try (FileWriter fw = new FileWriter(ARQUIVO, true);
                BufferedWriter bw = new BufferedWriter(fw)) {

                bw.write(obra.toString() + "\n");
            }

        }

}
