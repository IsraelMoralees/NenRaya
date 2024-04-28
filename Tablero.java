import java.util.Scanner;
public class Tablero extends Juego {

    // VARIABLES
    private int empate=0;
    protected char arrayTablero[][];

    // Constructor para el tablero
    public Tablero(int dimension) {
        arrayTablero = new char[dimension][dimension];
    }

    // Metodo para mostrar el tablero del juego
    public void rellenar() {
        for (int i = 0; i < arrayTablero.length; i++) {
            for (int j = 0; j < arrayTablero.length; j++) {
                if ((arrayTablero[i][j] == 'X') || (arrayTablero[i][j] == 'O')) {
                    System.out.print(arrayTablero[i][j]);
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // Metodo para introducir casillas en el tablero
    public void introducir() {
        Scanner leer = new Scanner(System.in);
        int fila = 0, columna = 0;
        if (turno1==true){
            System.out.println("Jugador " + j1.getNombre() + " es tu turno ");
        }else{
            System.out.println("Jugador " + j2.getNombre() + " es tu turno ");
        }
        System.out.println("Introduce fila");
        fila = leer.nextInt();
        System.out.println("Introduce columna");
        columna = leer.nextInt();
        if ((arrayTablero[fila][columna] == 'X') || (arrayTablero[fila][columna] == 'O')) {
            System.out.println("La fila " + fila + " y la columna " + columna + " Esta ocupada");
            introducir();
        } else {
            if (turno1==true){
                arrayTablero[fila][columna] = j1.getFichas();
            }else{
                arrayTablero[fila][columna] = j2.getFichas();
            }
            empate++;
        }
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
            int contX = 0;
            int contO = 0;
            for (int j = 0; j < arrayTablero.length; j++) {
                if (arrayTablero[i][j] == 'X') {
                    contX++;
                } else if (arrayTablero[i][j] == 'O') {
                    contO++;
                }
            }
            if (contO == arrayTablero.length) {
                System.out.println("Jugador O gana!");
                return true;
            } else if (contX == arrayTablero.length) {
                System.out.println("Jugador X gana!");
                return true;
            }
        }
        return false;
    }

    // Comprueba las columnas
    private boolean ComprobarCol() {
        for (int i = 0; i < arrayTablero.length; i++) {
            int contX = 0;
            int contO = 0;
            for (int j = 0; j < arrayTablero.length; j++) {
                if (arrayTablero[j][i] == 'X') {
                    contX++;
                } else if (arrayTablero[j][i] == 'O') {
                    contO++;
                }
            }
            if (contO == arrayTablero.length) {
                System.out.println("Jugador O gana!");
                return true;
            } else if (contX == arrayTablero.length) {
                System.out.println("Jugador X gana!");
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
            if (arrayTablero[i][i] == 'X') {
                contXDiagonal1++;
            } else if (arrayTablero[i][i] == 'O') {
                contODiagonal1++;
            }
            if (arrayTablero[i][arrayTablero.length - 1 - i] == 'X') {
                contXDiagonal2++;
            } else if (arrayTablero[i][arrayTablero.length - 1 - i] == 'O') {
                contODiagonal2++;
            }
        }

        if (contODiagonal1 == arrayTablero.length || contODiagonal2 == arrayTablero.length) {
            System.out.println("Jugador O gana!");
            return true;
        } else if (contXDiagonal1 == arrayTablero.length || contXDiagonal2 == arrayTablero.length) {
            System.out.println("Jugador X gana!");
            return true;
        }

        return false;
    }

    // Metodo que decide de que forma se gana
    public boolean Fin() {
        if (ComprobarCol() == true || ComprobarFilas() == true || Empate() == true || comprobarDiagonal() == true) {
            return true;
        }
        return false;
    }
}
