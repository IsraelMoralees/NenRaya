import java.util.Scanner;

public abstract class Juego {
        // Declaracion de las variables
        Jugadores j1 = new Jugadores("Israel", "X");
        Jugadores j2 = new Jugadores("Israel", "O");
        private int turno = 0;
        private int jugador=0;
        protected char arrayTablero[][];

        // CONSTRUCTORES
        public Juego() {
            this.turno = turno;
        }

        //Metodo para cambiar de turno
        public void CambiarTurno(){
            if(turno % 2 == 0){
                j1.getFichas();
                jugador=1;
            }else{
                jugador=2;
                j2.getFichas();
            }
        }

        // Metodo para elegir quien empieza
        public int ElegirComiezo(){
            Scanner leer=new Scanner(System.in);
            System.out.println("¿Quien quiere comenzar?");
            int num = leer.nextInt();

            if (num==1){
                turno=0;
            }else{
                turno=1;
            }
            return turno;
        }

        //Suma el turno despues de cada iteracion
        public void SumarTurnos() {
            turno++;
        }

        // Metodo para introducir casillas en el tablero
        public void introducir() {
            Scanner leer = new Scanner(System.in);
            int fila = 0, columna = 0;

            System.out.println("Jugador" + jugador + "es tu turno");
            System.out.println("Introduce fila");
            fila = leer.nextInt();
            System.out.println("Introduce columna");
            columna = leer.nextInt();
            if ((arrayTablero[fila][columna] == 'X') || (arrayTablero[fila][columna] == 'O')) {
                System.out.println("La fila " + fila + " y la columna " + columna + " Esta ocupada");
                introducir();
            } else {
                arrayTablero[fila][columna] = ficha;
            }
        }
}