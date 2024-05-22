import java.util.ArrayList;
import java.util.List;

public class ListaObras {

    private static List<Obra> listaObras = new ArrayList<>();

    public static List<Obra> getListaObras() {
        return listaObras;
    }

    public static void adicionarObra(Obra obra){
        listaObras.add(obra);
    }

    public static boolean removerObra(String titulo){
        Obra tempObra = buscarObra(titulo);

        return listaObras.remove(tempObra);
    }

    public static boolean listaVazia(){
        return listaObras.isEmpty();
    }

    public static Obra buscarObra(String titulo) {

        for(Obra tempObra : listaObras) {
            if (listaVazia()) {
                return null;
            }
            else if (tempObra.getTitulo().equals(titulo)) {
                return tempObra;
            }
        }

        return null;
    }


    public static void editarObraNome(String nome, String nomeNovo){
            Obra obra = buscarObra(nome);
            obra.setTitulo(nomeNovo);
    }

    public static void editarObraArtista(String nome, String artistaNovo){
        Obra obra = buscarObra(nome);
        obra.setArtista(artistaNovo);
    }

    public static void editarObraAno(String nome, int anoNovo){
        Obra obra = buscarObra(nome);
        obra.setAno(anoNovo);
    }

    public static void editarObraTipo(String nome, int tipo){
        Obra obra = buscarObra(nome);

        switch (tipo) {
            case 1:
                obra.setTipo("Escultura");
                break;

            case 2:
                obra.setTipo("Pintura");
                break;

            case 3:
                obra.setTipo("Esxposicao");
                break;
        
            default:
                break;
        }

    }

    public static void editarObraSetor(String nome, int setorNovo){
        Obra obra = buscarObra(nome);
        obra.setSetor(setorNovo);
    }


    
}
