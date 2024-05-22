import java.util.ArrayList;
import java.util.List;

public class ListaObras {

    private static List<Obra> listaObras = new ArrayList<>();

    public static List<Obra> getListaObras() {
        return listaObras;
    }

    public static void cadastrarObra(Obra obra){
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


    
}
