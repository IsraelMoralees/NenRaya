import java.util.Scanner;

public class Juego {
    // Declaracion de las variables y objetos
    Tablero [] arrayMesas;

    Jugadores [] arrayJugadores;

    private void cantidadMesas (){
        Scanner leer=new Scanner(System.in);
        System.out.println("Cuantos juegos quieres a la vez?");
        int num = leer.nextInt();
        arrayMesas = new Tablero[num];
        int cont=1;
        for (int i = 0; i < arrayMesas.length; i++) {
            System.out.println("De cuanto quieres que sea el "+ cont + " tablero?");
            cont++;
            int numTab = leer.nextInt();
            arrayMesas[i]=new Tablero(numTab);
            arrayMesas[i].ElegirComiezo();
        }
    }

    private boolean finJuego(){
        int cont=0;
        for (int i = 0; i < arrayMesas.length; i++){
            if(arrayMesas[i].Fin()){
                cont++;
            }
        }
        if (cont==arrayMesas.length){
            return true;
        }
        return false;
    }

    public void partida(){
        cantidadMesas();
        do{
            for (int i = 0; i < arrayMesas.length; i++){
                arrayMesas[i].rellenar();
                arrayMesas[i].introducir();
                arrayMesas[i].CambiarTurno();
            }
        }while (!finJuego());
    }
}

/*

                CANTIDAD JUGADORES CON ARRAY
private void cantJugadores (){
        Scanner leer=new Scanner(System.in);
        System.out.println("Cuantos jugadores van a jugar?");
        int num = leer.nextInt();
        arrayJugadores = new Jugadores[num];
        int cont=1;
        for (int i = 0; i < arrayJugadores.length; i++) {
            System.out.println("Jugador "+ cont + " ,introduzca su nombre");
            nombre1 = leer.next();
            System.out.println("Indique cual quiere que sea su ficha");
            ficha1 = leer.next().charAt(0);
            arrayJugadores[i] = new Jugadores (nombre1, ficha1);
            System.out.println("El jugador "+ cont + " es " + arrayJugadores[i].getNombre() + " y su ficha es " + arrayJugadores[i].getFichas());
            cont++;
        }
    }
 */