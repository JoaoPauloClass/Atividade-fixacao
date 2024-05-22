public class Sistema {
    

    public static void executar(){
        menu();
    }

    private static void menu() {
        int op;
        boolean sincronizado = false;
        do {
            if (!sincronizado) {
                try {
                    GerenciadorObras.atualizarSistema();
                    System.out.println("Sincronizado.");
                    sincronizado = true;
                } catch (Exception e) {
                    System.out.println("ERRO! Não foi possivel sincronizar o banco de dados: " + e.getMessage());
                }
            }
            
            System.out.println("\n\nSISTEMA DO MUSEU");
            System.out.println("Selecione uma opção:");
            System.out.println("1) Cadastrar Obra");
            System.out.println("2) Buscar Obra");
            System.out.println("3) Editar Obra");
            System.out.println("4) Excluir Obra");
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
                case 3:
                    editarObra();
                    break;
                // case 4:
                //     excluirCarta();
                //     break;
                case 5:
                    listarObras();
                    break;
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

        System.out.println("Digite os campos **SEM ACENTOS E CARACTERES ESPECIAIS**");
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
                tipo = "Exposicao";
                break;

            default:
                tipo = "N/A";
                break;
        }
        Obra tempObra = new Obra(titulo, artista, ano, tipo, setor);
        ListaObras.adicionarObra(tempObra);
        try {
            GerenciadorObras.salvarObra(tempObra);
        } catch (Exception e) {
            System.out.println("ERRO! Não foi possivel salvar a obra no bando de dados: " + e.getMessage());
        }
    }

    private static void buscarObra(){
        String titulo;

        titulo = Console.lerString("Digite o título: ");
        Obra tempObra = ListaObras.buscarObra(titulo);

        if (tempObra == null) {
            System.out.println("Obra não encontrada ou lista vazia...");
        }else{
            System.out.println(tempObra.mostrarDados()); 
        }
    }

    private static void editarObra() {
        String nome;
        int op;
        do {
            System.out.println("\n\nEDITAR OBRA");
            nome = Console.lerString("Digite o nome da obra que deseja editar (digite SAIR para sair): ");

            if (ListaObras.buscarObra(nome) == null) {
                
                if (nome.equals("SAIR")) {
                    break;
                }else{
                   System.out.println("Obra não encontrada."); 
                }
            }

        } while (ListaObras.buscarObra(nome) == null);

        if (!nome.equals("SAIR")) {
            do {

                System.out.println("\nEDITAR OBRA -> " + nome);
                System.out.println("1) Editar Nome");
                System.out.println("2) Editar Artista");
                System.out.println("3) Editar Ano");
                System.out.println("4) Editar Tipo");
                System.out.println("5) Editar Setor");
                System.out.println("0) Sair");
                op = Console.lerInt(">> ");

                switch (op) {
                    case 0:
                        System.out.println("Saindo...");
                        break;

                    case 1:
                        editarObraNome(nome);
                        break;

                    case 2:
                        editarObraArtista(nome);
                        break;

                    case 3:
                        editarObraAno(nome);
                        break;

                    case 4:
                        editarObraTipo(nome);
                        break;

                    case 5:
                        editarObraSetor(nome);
                        break;

                    default:
                        System.out.println("Valor inválido, digite novamente");
                        break;
                }
                try {
                    GerenciadorObras.atualizarDados();
                    return;
                } catch (Exception e) {
                    System.out.println("Não foi possivel sincronizar os dados: " + e.getMessage());
                }
            } while (op != 0);
        }

    }
    
    private static void editarObraNome(String nome){
        String nomeNovo = Console.lerString("Digite o novo nome (SEM ACENTOS E CARACTERES ESPECIAIS): ");
        ListaObras.editarObraNome(nome, nomeNovo);
        System.out.println("Obra editada.");
    }

    private static void editarObraArtista(String nome){
        String artistaNovo = Console.lerString("Digite o novo artista: ");
        ListaObras.editarObraArtista(nome, artistaNovo);
        System.out.println("Obra editada.");
    }

    private static void editarObraAno(String nome){
        int anoNovo = Console.lerInt("Digite o novo ano: ");
        ListaObras.editarObraAno(nome, anoNovo);
        System.out.println("Obra editada.");
    }

    private static void editarObraTipo(String nome){
        int op;
        do {
            System.out.println("Selecione o novo tipo de obra:");
            System.out.println("1) Escultura");
            System.out.println("2) Pintura");
            System.out.println("3) Exposição");
            System.out.println("0) Cancelar");
            op = Console.lerInt(">> ");

            if (op < 1 || op > 3) {
                if (op == 0) {
                    return;
                } else {
                    System.out.println("Digite um valor válido.");
                }
            }
        } while (op < 1 || op > 3);
        
        ListaObras.editarObraTipo(nome, op);
        System.out.println("Obra editada.");

    }

    private static void editarObraSetor(String nome){
        int setorNovo = Console.lerInt("Digite o novo setor: ");
        ListaObras.editarObraSetor(nome, setorNovo);
        System.out.println("Obra editada.");
    }

    private static void listarObras(){

        for (Obra tempObra : ListaObras.getListaObras()) {
            System.out.println(tempObra.mostrarDados());
        }

    }


}
