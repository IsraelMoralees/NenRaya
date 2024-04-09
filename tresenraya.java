import java.util.Scanner;

public class tresenraya {
    public static void main(String[] args) {
        char[][] juego;
        int turno = 0;
        int fila = 0;
        int columna = 0;
        int dimension = 0;

        System.out.println("Introduce la dimension del N en raya");
        Scanner leer=new Scanner(System.in);
        dimension=leer.nextInt();

        juego = new char[dimension][dimension];

        do {
            rellenar(juego);
            introducir(turno, fila, columna, juego);
            turno++;
        } while (!DecidirPartida(juego, turno, dimension));
        System.out.println();
        rellenar(juego);
    }

    // Metodo para mostrar el tablero del juego
    public static void rellenar(char juego[][]) {
        for (int i = 0; i < juego.length; i++) {
            for (int j = 0; j < juego.length; j++) {
                if ((juego[i][j] == 'X') || (juego[i][j] == 'O')) {
                    System.out.print(juego[i][j]);
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // Metodo introducir casillas en el tablero
    public static void introducir(int turno, int fila, int columna, char juego[][]) {
        Scanner leer = new Scanner(System.in);
        if (turno % 2 == 0) {
            System.out.println("Jugador 1 es tu turno");
            System.out.println("Introduce fila");
            fila = leer.nextInt();
            System.out.println("Introduce columna");
            columna = leer.nextInt();
            if ((juego[fila][columna] == 'X') || (juego[fila][columna] == 'O')) {
                System.out.println("La fila " + fila + " y la columna " + columna + " Esta ocupada");
                introducir(turno, fila, columna, juego);
            } else {
                juego[fila][columna] = 'X';
            }
        } else {
            System.out.println("Jugador 2 es tu turno");
            System.out.println("Introduce fila");
            fila = leer.nextInt();
            System.out.println("Introduce columna");
            columna = leer.nextInt();
            if ((juego[fila][columna] == 'X') || (juego[fila][columna] == 'O')) {
                System.out.println("La fila " + fila + " y la columna " + columna + " Esta ocupada");
                introducir(turno, fila, columna, juego);
            } else {
                juego[fila][columna] = 'O';
            }
        }
    }

    public static boolean DecidirPartida(char[][] juego, int dimension, int turno) {
        // Mira la victoria por columna o fila
        for (int i = 0; i < dimension; i++) {
            boolean rowWin = true;
            boolean colWin = true;
            for (int j = 0; j < dimension - 1; j++) {
                if (juego[i][j]!= juego[i][j + 1]) {
                    rowWin = false;
                }
                if (juego[j][i]!= juego[j + 1][i]) {
                    colWin = false;
                }
            }
            if (rowWin || colWin) {
                if (juego[i][0] == 'X') {
                    System.out.println("El jugador 1 es el ganador!!");
                    return true;
                } else if (juego[i][0] == 'O') {
                    System.out.println("El jugador 2 es el ganador!!");
                    return true;
                }
            }
        }
    
        // Mira si las diagonales ganan
        boolean diagWin1 = true;
        boolean diagWin2 = true;
        for (int i = 0; i < dimension - 1; i++) {
            if (juego[i][i]!= juego[i + 1][i + 1]) {
                diagWin1 = false;
            }
            if (juego[i][dimension - i - 1]!= juego[i + 1][dimension - i - 2]) {
                diagWin2 = false;
            }
        }
        if (diagWin1 || diagWin2) {
            if (juego[0][0] == 'X') {
                System.out.println("El jugador 1 es el ganador!!");
                return true;
            } else if (juego[0][0] == 'O') {
                System.out.println("El jugador 2 es el ganador!!");
                return true;
            }
        }
    
        // Mira el empate
        int contadorFichas= 0;
        boolean fin= false;

        for (int i= 0; i< juego.length && !fin; i++) {
            for (int j= 0; j< juego.length && !fin; j++) {
                if (juego[i][j]!= '.') {
                    contadorFichas++;
                } else {
                    fin= true;
                }
            }
        }
        if (contadorFichas == dimension * dimension) {
            System.out.println("Empate!");
            return true;
        }
    
        return false;
    }
}
