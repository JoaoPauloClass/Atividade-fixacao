public class Sistema {
    

    public static void executar(){
        menu();
    }

    private static void menu() {
        int op;
        do {
            System.out.println("\n\nSISTEMA DO MUSEU");
            System.out.println("Selecione uma opção:");
            System.out.println("1) Cadastrar Obra");
            System.out.println("2) Buscar Obra");
            System.out.println("3) Excluir Obra");
            System.out.println("5) Listar Obras");
            System.out.println("6) Atualizar dados");
            System.out.println("0) Sair");
            op = Console.lerInt(">> ");

            switch (op) {
                case 1:
                    cadastrarObra();
                    break;
                case 2:
                    buscarObra();
                    break;
                // case 3:
                //     editarCarta();
                //     break;
                // case 4:
                //     excluirCarta();
                //     break;
                // case 5:
                //     listarCartas();
                //     break;
                // case 6:
                //     ListaCartas.excluirTodasCartas();
                //     System.out.println("Todas as cartas foram excluídas!");
                //     break;
                case 0:
                    System.out.println("Encerrando sistema.");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }      
        } while (op != 0);
    }

    private static void cadastrarObra() {
        int op;

        System.out.println("\n\nCADASTRAR OBRA");
        System.out.println("Selecione o tipo de obra:");
        System.out.println("1) Escultura");
        System.out.println("2) Pintura");
        System.out.println("3) Exposição");
        System.out.println("0) Cancelar");
        do {
            op = Console.lerInt(">> ");
            if (op == 0) {
                return;
            }
        } while (op > 3 || op < 1);

        String titulo;
        String artista;
        int ano;
        String tipo;
        int setor;

        titulo = Console.lerString("Título: ");
        artista = Console.lerString("Artista: ");
        ano = Console.lerInt("Ano de Criação: ");
        setor = Console.lerInt("Setor que está localizada: ");

        switch (op) {
            case 1:
                tipo = "Escultura";
                break;

            case 2:
                tipo = "Pintura";
                break;

            case 3:
                tipo = "Exposição";
                break;

            default:
                tipo = "N/A";
                break;
        }

        ListaObras.cadastrarObra(new Obra(titulo, artista, ano, tipo, setor));

    }

    private static void buscarObra(){
        String titulo;

        titulo = Console.lerString("Digite o título: ");
        Obra tempObra = ListaObras.buscarObra(titulo);

        if (tempObra == null) {
            System.out.println("Obra não encontrada ou lista vazia...");
        }else{
            tempObra.mostrarDados();
        }
    }
}
