import java.util.Scanner;

public class MenuDeReservas {
    private final ServicoDeReservas servicoDeReservas;
    private final Scanner scanner;

    public MenuDeReservas(ServicoDeReservas servicoDeReservas) {
        this.servicoDeReservas = servicoDeReservas;
        this.scanner = new Scanner(System.in);
    }

    public void exibir() {
        int opcao;

        do {
            System.out.println("\n---> MENU <---");
            System.out.println("1. Nova reserva");
            System.out.println("2. Listar reservas");
            System.out.println("3. Buscar por nome do hóspede");
            System.out.println("4. Ordenar por número de dias (decrescente)");
            System.out.println("5. Sair");
            System.out.print("\nEscolha uma opção: ");
            opcao = lerInteiro();

            switch (opcao) {
                case 1 -> novaReserva();
                case 2 -> listarReservas();
                case 3 -> buscarReserva();
                case 4 -> ordenarReservas();
                case 5 -> System.out.println("Obrigado por utilizar o Sistema de Reservas de Hotel, até mais :)... encerrando o sistema!!!");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 5);
        scanner.close();
    }

    private void novaReserva() {
        if (servicoDeReservas.estaCheio()) {
            System.out.println("Limite de reservas atingido.");
            return;
        }

        System.out.print("Nome do hóspede: ");
        String nomeHospede = scanner.nextLine();

        String tipoQuarto = tipoDoQuarto();

        System.out.print("Número de dias: ");
        int quantidadeDias = lerInteiro();

        System.out.print("Valor da diária: ");
        double valorDiaria = lerDouble();

        if (quantidadeDias < 1 || valorDiaria <= 0) {
            System.out.println("Dados inválidos. A diária deve ser positiva e os dias maiores que 0.");
            return;
        }

        Reserva reserva = new Reserva(nomeHospede, tipoQuarto, quantidadeDias, valorDiaria);
        boolean adicionada = servicoDeReservas.adicionarReserva(reserva);

        if (adicionada) {
            System.out.println("Reserva cadastrada com sucesso!");
        }
    }

    private String tipoDoQuarto() {
        int opcao;
        String tipo = "";

        do {
            System.out.println("\nTipo do quarto: ");
            System.out.println("1. Standard");
            System.out.println("2. Luxo");
            System.out.println("3. Presidencial");
            System.out.print("\nEscolha uma opção: ");
            opcao = lerInteiro();

            switch (opcao) {
                case 1 -> tipo = "Standard";
                case 2 -> tipo = "Luxo";
                case 3 -> tipo = "Presidencial";
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao < 1 || opcao > 3);
        scanner.close();

        return tipo;
    }

    private void listarReservas() {
        if (!servicoDeReservas.temReservas()) {
            System.out.println("Nenhuma reserva cadastrada.");
            return;
        }
        Reserva[] reservas = servicoDeReservas.listarReservas();
        for (int i = 0; i < reservas.length; i++) {
            System.out.println(reservas[i]);
        }
    }

    private void buscarReserva() {
        System.out.print("Digite parte do nome do hóspede: ");
        String termo = scanner.nextLine();
        Reserva[] reservasEncontradas = servicoDeReservas.buscarPorNome(termo);

        if (reservasEncontradas.length == 0) {
            System.out.println("Nenhuma reserva encontrada para o nome informado.");
        } else {
            for (int i = 0; i < reservasEncontradas.length; i++) {
                System.out.println(reservasEncontradas[i]);
            }
        }
    }

    private void ordenarReservas() {
        servicoDeReservas.ordenarPorDiasDecrescente();
        System.out.println("Reservas ordenadas com sucesso!");
    }

    /*
        Lê uma linha do teclado.
        Verifica caractere por caractere se todos são dígitos (0 a 9).
        Se encontrar algum caractere que não seja um número, retorna -1.
        Caso contrário, faz o parse para int e retorna.
    */
    private int lerInteiro() {
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return -1;
            }
        }
        return Integer.parseInt(input);
    }

    /*
        Lê uma linha digitada.
        Tenta convertê-la para double.
        Se a conversão falhar, retorna -1.
     */
    private double lerDouble() {
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

}