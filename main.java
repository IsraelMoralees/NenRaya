public class main {
    public static void main(String[] args) {
        Jugadores j1 = new Jugadores("Israel", "X");
        Jugadores j2 = new Jugadores("Pepe", "O");
        Tablero t1 = new Tablero ();
        
        do {
            t1.IntDimensiones(3);
            t1.rellenar();
            t1.introducir();
            t1.SumarTurnos();
        } while (!t1.Fin());
        System.out.println();
        t1.rellenar();
    }
}