public class Jugadores extends Juego{

    // VARIABLES
    private String nombre;
    private char fichas;

    // CONSTRUCTORES
    public Jugadores(String nombre, char fichas) {
        this.nombre = nombre;
        this.fichas = fichas;
    }

    public char getFichas() {
        return fichas;
    }

    public String getNombre() {
        return nombre;
    }
}
