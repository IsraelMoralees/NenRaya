
import java.util.Scanner;
public class LogicaJuego{
    // Declaracion de las variables y objetos
    Juego [] arrayMesas;

    private void RellenarArray (){
        Scanner leer = new Scanner(System.in);
        System.out.println("Cuantas mesas quieres tener");
        int num = leer.nextInt();
        arrayMesas=new Juego[num];
        for (int i=0;i < arrayMesas.length; i++){
            System.out.println("1. para N en raya, 2. para Adivina el numero");
            int num2 = leer.nextInt();
            if (num2==1){
                arrayMesas[i]=new Tablero();
            }else if (num2==2){
                arrayMesas[i]=new Adivina();
            }else{
                System.out.println("Tienes que introducir un numero entre 1 y 2");
                RellenarArray();
            }
        }
    }

    public void Jugar(){
        RellenarArray();
        for (int i=0;i < arrayMesas.length; i++){
            if (arrayMesas[i].Aux()){
            }else{
                arrayMesas[i].Partida();
            }
            if ((i==arrayMesas.length - 1)&&(!finJuego())){
                i=-1;
            }
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
}