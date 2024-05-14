import java.util.Scanner;
public class Adivina extends Juego {
    private int intentos=0;
    private int num;
    private int numAle = (int) (Math.random()*10);
    private boolean finJuego=false;
    public void Partida(){
        Scanner leer = new Scanner(System.in);
        System.out.println("Introduce un numero entre el 1 y el 10");
        num=leer.nextInt();
        intentos++;
        Fin();
    }
    public boolean Fin(){
        if(num==numAle){
            System.out.println("Felicidades!! has ganado, el numero era: "+ numAle + " el numero de intentos han sido: " + intentos);
            finJuego=true;
            return true;
        }
        return false;
    }

    public boolean Aux(){
        return finJuego;
    }
}
