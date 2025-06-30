public class Reserva {
    private String nomeHospede;
    private String tipoQuarto;
    private int numeroDias;
    private double valorDiaria;

    public Reserva(String nomeHospede, String tipoQuarto, int numeroDias, double valorDiaria) {
        this.nomeHospede = nomeHospede;
        this.tipoQuarto = tipoQuarto;
        this.numeroDias = numeroDias;
        this.valorDiaria = valorDiaria;
    }

    public String getNomeHospede() { return nomeHospede; }
    public String getTipoQuarto() { return tipoQuarto; }
    public int getNumeroDias() { return numeroDias; }
    public double getValorDiaria() { return valorDiaria; }

    public double calcularValorTotal() { return numeroDias * valorDiaria; }

    @Override
    public String toString() {
        return "Hóspede: " + nomeHospede +
               " | Quarto: " + tipoQuarto +
               " | Dias: " + numeroDias +
               " | Diária: R$ " + String.format("%.2f", valorDiaria) +
               " | Total: R$ " + String.format("%.2f", calcularValorTotal());
    }
}