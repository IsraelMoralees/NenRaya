import java.util.Scanner;
public class Tablero extends Juego {
    // VARIABLES
    private int empate=0;
    protected char arrayTablero[][];
    private boolean turno1;
    private boolean turno2;
    private char ficha1;
    private String nombre1;
    private String nombre2;
    private char ficha2;
    private int contadorPartida=0;
    private boolean finJuego;

    // Constructor para el tablero
    public Tablero() {
    }

    // Metodo para mostrar el tablero del juego
    public void rellenar() {
        for (int i = 0; i < arrayTablero.length; i++) {
            for (int j = 0; j < arrayTablero.length; j++) {
                if ((arrayTablero[i][j] == ficha1) || (arrayTablero[i][j] == ficha2)) {
                    System.out.print(arrayTablero[i][j]);
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private void TamañoMesa(){
        Scanner leer = new Scanner(System.in);
        System.out.println("De cuanto quieres que sea el tablero");
        int dimension=leer.nextInt();
        arrayTablero = new char[dimension][dimension];
    }

    // Metodo para introducir casillas en el tablero
    public void introducir() {
            Scanner leer = new Scanner(System.in);
            int fila = 0, columna = 0;
            if (turno1==true){
                System.out.println(nombre1 + " es tu turno ");
            }else if (turno2==true){
                System.out.println(nombre2 + " es tu turno ");
            }
            System.out.println("Introduce fila");
            fila = leer.nextInt();
            System.out.println("Introduce columna");
            columna = leer.nextInt();
            if ((arrayTablero[fila][columna] == ficha1) || (arrayTablero[fila][columna] == ficha2)) {
                System.out.println("La fila " + fila + " y la columna " + columna + " Esta ocupada");
                introducir();
            } else {
                if (turno1==true){
                    arrayTablero[fila][columna] = ficha1;
                }else if (turno2==true){
                    arrayTablero[fila][columna] = ficha2;
                }
                empate++;
            }
    }
    //Metodo para cambiar de turno
    public boolean CambiarTurno() {
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
    public boolean ElegirComiezo() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Jugador 1,introduzca su nombre");
        nombre1 = leer.next();

        System.out.println("Indique cual quiere que sea su ficha");
        ficha1 = leer.next().charAt(0);
        System.out.println("El jugador 1 es " + nombre1 + " y su ficha es " + ficha1);

        System.out.println("Jugador 2,introduzca su nombre");
        nombre2 = leer.next();

        System.out.println("Indique cual quiere que sea su ficha");
        ficha2 = leer.next().charAt(0);
        System.out.println("El jugador 1 es " + nombre2 + " y su ficha es " + ficha2);
        System.out.println("Quien quiere comenzar,el 1 o el 2?");
        int num = leer.nextInt();
        if (num > 2) {
            System.out.println("Error, introduce un numero entre 1 y 2");
            ElegirComiezo();
        } else {
            if (num == 1) {
                turno1 = true;
                turno2 = false;
                return turno1;
            } else {
                turno2 = true;
                turno1 = false;
                return turno2;
            }
        }
        return false;
    }
    // Comprueba el empate
    private boolean Empate() {
        if (empate == arrayTablero.length * arrayTablero.length) {
            System.out.println("Fin, el juego ha acabado en Empate!");
            return true;
        }
        return false;
    }

    // Comprueba las filas
    private boolean ComprobarFilas() {
        for (int i = 0; i < arrayTablero.length; i++) {
            int cont1 = 0;
            int cont2 = 0;
            for (int j = 0; j < arrayTablero.length; j++) {
                if (arrayTablero[i][j] == ficha1) {
                    cont1++;
                } else if (arrayTablero[i][j] == ficha2) {
                    cont2++;
                }
            }
            if (cont2 == arrayTablero.length) {
                System.out.println(nombre1+" gana!");
                return true;
            } else if (cont1 == arrayTablero.length) {
                System.out.println(nombre2+" gana!");
                return true;
            }
        }
        return false;
    }

    // Comprueba las columnas
    private boolean ComprobarCol() {
        for (int i = 0; i < arrayTablero.length; i++) {
            int cont1 = 0;
            int cont2 = 0;
            for (int j = 0; j < arrayTablero.length; j++) {
                if (arrayTablero[j][i] == ficha1) {
                    cont1++;
                } else if (arrayTablero[j][i] == ficha2) {
                    cont2++;
                }
            }
            if (cont2 == arrayTablero.length) {
                System.out.println(nombre1+" gana!");
                return true;
            } else if (cont1 == arrayTablero.length) {
                System.out.println(nombre2+" gana!");
                return true;
            }
        }
        return false;
    }
    
    // Comprueba la diagonal
    private boolean comprobarDiagonal() {
        int contXDiagonal1 = 0;
        int contODiagonal1 = 0;
        int contXDiagonal2 = 0;
        int contODiagonal2 = 0;

        for (int i = 0; i < arrayTablero.length; i++) {
            if (arrayTablero[i][i] == ficha1) {
                contXDiagonal1++;
            } else if (arrayTablero[i][i] == ficha2) {
                contODiagonal1++;
            }
            if (arrayTablero[i][arrayTablero.length - 1 - i] == ficha1) {
                contXDiagonal2++;
            } else if (arrayTablero[i][arrayTablero.length - 1 - i] == ficha2) {
                contODiagonal2++;
            }

            if (contODiagonal1 == arrayTablero.length || contODiagonal2 == arrayTablero.length) {
                System.out.println(nombre1+" gana!");
                return true;
            } else if (contXDiagonal1 == arrayTablero.length || contXDiagonal2 == arrayTablero.length) {
                System.out.println(nombre2+" gana!");
                return true;
            }
        }
        return false;
    }

    // Metodo que decide de que forma se gana
    public boolean Fin() {
        if (ComprobarCol() == true || ComprobarFilas() == true || Empate() == true || comprobarDiagonal() == true) {
            finJuego=true;
            return true;
        }
        finJuego=false;
        return false;
    }

    public boolean Aux(){
        return finJuego;
    }

    public void Partida(){
        if (contadorPartida==0){
            TamañoMesa();
            ElegirComiezo();
            contadorPartida++;
        }
        rellenar();
        introducir();
        CambiarTurno();
        Fin();
    }
}
