public class Obra {
    
    private String titulo;
    private String artista;
    private int ano;
    private String tipo;
    private int setor;

    public Obra(){}
    
    public Obra(String titulo, String artista, int ano, String tipo, int setor) {
        this.titulo = titulo;
        this.artista = artista;
        this.ano = ano;
        this.tipo = tipo;
        this.setor = setor;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getSetor() {
        return setor;
    }
    public void setSetor(int setor) {
        this.setor = setor;
    }

    public String mostrarDados(){

        return "\nTítulo: " + titulo +
                "\nArtista: " + artista +
                "\nAno de criação: " + ano +
                "\nTipo: " + tipo +
                "\nSetor: " + setor;
    }

    @Override
    public String toString() {
        return titulo + ", " + artista + ", " + ano + ", " + tipo + ", " + setor;
    }

    public static Obra fromString(String linha) {

        String[] dadosObras = linha.split(", ");

        return new Obra(dadosObras[0], 
                        dadosObras[1], 
                        Integer.parseInt(dadosObras[2]),
                        dadosObras[3],
                        Integer.parseInt(dadosObras[4]));

    }
}
