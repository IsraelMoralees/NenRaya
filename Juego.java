import java.util.Scanner;

public class Juego {
    // Declaracion de las variables y objetos
    Jugadores j1 = new Jugadores("israel", 'X');
    Jugadores j2 = new Jugadores("pepe", 'O');
    Tablero [] arrayMesas;

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
                arrayMesas[i].ElegirComiezo();
                arrayMesas[i].rellenar();
                arrayMesas[i].introducir();
                arrayMesas[i].CambiarTurno();
            }
        }while (!finJuego());
    }
}