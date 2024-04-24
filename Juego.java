import java.util.Scanner;

public abstract class Juego {
    // Declaracion de las variables y objetos
    Jugadores j1 = new Jugadores("Israel", 'X');
    Jugadores j2 = new Jugadores("Israel", 'O');

    private int turno = 0;
    protected int jugador=0;
    boolean turno1=false;
    boolean turno2=false;

    //Metodo para cambiar de turno
    public void CambiarTurno(){
        if(turno1==false){
            turno1=true;
            turno2=false;
        }else if(turno2==false){
            turno2=true;
            turno1=false;
        }
    }

    // Metodo para elegir quien empieza
    public int ElegirComiezo(){
        Scanner leer=new Scanner(System.in);
        System.out.println("¿Quien quiere comenzar?");
        int num = leer.nextInt();

        if (num==1){
            turno1=true;
            turno2=false;
        }else{
            turno2=true;
            turno1=false;
        }
        return turno;
    }

    //Suma el turno despues de cada iteracion
    public void SumarTurnos() {
        turno++;
    }



    /*  Segunda Opcion cambio de turno

        if(turno % 2 == 0){
            j1.getFichas();
            jugador=1;
        }else{
            jugador=2;
            j2.getFichas();
        }
        */
}