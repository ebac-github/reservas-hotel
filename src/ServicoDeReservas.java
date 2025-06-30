public class ServicoDeReservas {
    private static final int LIMITE_RESERVAS = 10;
    private final Reserva[] reservas = new Reserva[LIMITE_RESERVAS];
    private int totalReservas = 0;

    public boolean adicionarReserva(Reserva reserva) {
        reservas[totalReservas++] = reserva;
        return true;
    }

    public Reserva[] listarReservas() {
        Reserva[] reservasPreenchidas = new Reserva[totalReservas];
        for (int i = 0; i < totalReservas; i++) {
            reservasPreenchidas[i] = reservas[i];
        }
        return reservasPreenchidas;
    }

    public Reserva[] buscarPorNome(String termo) {
        Reserva[] reservasPreenchidas = new Reserva[totalReservas];
        int quantidadeDeReservasEncontradas = 0;
        for (int i = 0; i < totalReservas; i++) {
            if (reservas[i].getNomeHospede().toLowerCase().contains(termo.toLowerCase())) {
                reservasPreenchidas[quantidadeDeReservasEncontradas++] = reservas[i];
            }
        }
        Reserva[] reservasComNomeProcurado = new Reserva[quantidadeDeReservasEncontradas];
        for (int i = 0; i < quantidadeDeReservasEncontradas; i++) {
            reservasComNomeProcurado[i] = reservasPreenchidas[i];
        }
        return reservasComNomeProcurado;
    }

    public void ordenarPorDiasDecrescente() {
        for (int i = 0; i < totalReservas - 1; i++) {
            for (int j = i + 1; j < totalReservas; j++) {
                if (reservas[j].getNumeroDias() > reservas[i].getNumeroDias()) {
                    Reserva reservaTemporaria = reservas[i];
                    reservas[i] = reservas[j];
                    reservas[j] = reservaTemporaria;
                }
            }
        }
    }

    public boolean temReservas() {
        return totalReservas > 0;
    }

    public boolean estaCheio() {
        return totalReservas >= LIMITE_RESERVAS;
    }
}