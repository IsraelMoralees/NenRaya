import java.util.Scanner;
public class Jugadores{

    // VARIABLES
    private String nombre;
    //protected enum Fichas{X,O};
    private char fichas;

    // CONSTRUCTORES
    public Jugadores(String nombre, char fichas) {
        this.nombre = nombre;
        this.fichas = fichas;
        // Fichas.valueOf(fichas);
    }

    public char getFichas() {
        return fichas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFichas(char fichas) {
        this.fichas = fichas;
    }
}
