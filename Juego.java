import java.util.Scanner;

public class Juego {
    // Declaracion de las variables y objetos
    Jugadores j1 = new Jugadores("israel", 'X');
    Jugadores j2 = new Jugadores("pepe", 'O');

    Tablero [] arrayMesas;

    protected boolean turno1;
    protected boolean turno2;

    private void cantidadMesas (){
        Scanner leer=new Scanner(System.in);
        System.out.println("Cuantos juegos quieres a la vez?");
        int num = leer.nextInt();
        arrayMesas = new Tablero[num];

        for (int i = 0; i < arrayMesas.length; i++) {
            System.out.println("De cuanto quieres que sea el primer tablero?");
            int numTab = leer.nextInt();
            arrayMesas[i]=new Tablero(numTab);
        }
    }

    //Metodo para cambiar de turno
    private boolean CambiarTurno() {
        if (turno1 == false) {
            turno1 = true;
            turno2 = false;
        } else {
            turno1 = false;
            turno2 = true;
        }
        return turno1;
    }

    // Metodo para elegir quien empieza
    private boolean ElegirComiezo(){
        Scanner leer=new Scanner(System.in);
        System.out.println("¿Quien quiere comenzar?");
        int num = leer.nextInt();
        if(num > 2){
            System.out.println("Error, introduce un numero entre 1 y 2");
            ElegirComiezo();
        }else{
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
        return false;
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
        ElegirComiezo();
        do{
            for (int i = 0; i < arrayMesas.length; i++){
                arrayMesas[i].rellenar();
                arrayMesas[i].introducir();
                CambiarTurno();
            }
        }while (!finJuego());
    }
}