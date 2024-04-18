import java.util.Scanner;
public class Jugadores {

    // VARIABLES
    private String nombre;
    private enum Fichas{X,O};
    private Fichas fichas;
    private int turno = 0;


    // CONSTRUCTORES
    public Jugadores(String nombre, String fichas) {
        this.nombre = nombre;
        this.fichas = Fichas.valueOf(fichas);
    }


    //Suma el turno despues de cada iteracion
    public void SumarTurnos() {
        turno++;
    }

    // Metodo para elegir quien empieza
    public void ElegirComiezo(){
        Scanner leer=new Scanner(System.in);
        System.out.println("¿Quien quiere comenzar?");
        int num = leer.nextInt();

        if (num==1){
            turno=0;
        }else{
            turno=1;
        }
    }

    //Metodo para cambiar de turno
    public void CambiarTurno(){
        char ficha=0;
        int jugador=0;
        
        if(turno % 2 == 0){
            ficha='X';
            jugador=1;
        }else{
            jugador=2;
            ficha='O';
        }
    }

    public Jugadores(Jugadores.Fichas fichas) {
        this.fichas = fichas;
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

}
