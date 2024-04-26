public class Main {
    public static void main(String[] args) {
        Tablero t1 = new Tablero(3);
        Juego juego1 = new Juego();
        juego1.ElegirComiezo();
        do{
            t1.rellenar();
            t1.introducir();
            juego1.CambiarTurno();
        }while (!t1.Fin());
    }
}
