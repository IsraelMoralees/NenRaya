public class Jugadores{
    // VARIABLES
    private String nombre;
    private char fichas;
    protected boolean turno;

    public Jugadores(String nombre, char fichas) {
        this.nombre = nombre;
        this.fichas = fichas;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
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
