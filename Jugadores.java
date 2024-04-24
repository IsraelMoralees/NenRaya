import java.util.Scanner;
public class Jugadores extends Juego {

    // VARIABLES
    private String nombre;
    protected enum Fichas{X,O};
    protected Fichas fichas;

    // CONSTRUCTORES
    public Jugadores(String nombre, String fichas) {
        this.nombre = nombre;
        this.fichas = Fichas.valueOf(fichas);
    }

    public Fichas getFichas() {
        return fichas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFichas(Fichas fichas) {
        this.fichas = fichas;
    }
}
