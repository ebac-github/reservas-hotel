public class SistemaDeReservasDeHotel {
    public static void main(String[] args) {
        ServicoDeReservas servicoDeReservas = new ServicoDeReservas();
        MenuDeReservas menuDeReservas = new MenuDeReservas(servicoDeReservas);
        menuDeReservas.exibir();
    }
}