import java.util.Scanner;

public class Juego {
    // Declaracion de las variables y objetos
    Jugadores j1 = new Jugadores("israel", 'X');
    Jugadores j2 = new Jugadores("pepe", 'O');
    protected boolean turno1=false;
    protected boolean turno2=false;

    //Metodo para cambiar de turno
    public boolean CambiarTurno(){
        if(turno1==false){
            turno1=true;
            turno2=false;
            return turno1;
        }else{
            turno2=true;
            turno1=false;
            return turno2;
        }
    }

    // Metodo para elegir quien empieza
    public boolean ElegirComiezo(){
        Scanner leer=new Scanner(System.in);
        System.out.println("¿Quien quiere comenzar?");
        int num = leer.nextInt();
        if (num==1){
            turno1=true;
            turno2=false;
            return turno1;
        }else{
            turno2=true;
            turno1=false;
            return turno2;
        }
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