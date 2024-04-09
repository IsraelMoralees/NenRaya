import java.util.Scanner;

public class NenRaya {
    private static char[][] tablero;
    private static int dimension;
    private static int enLinea;
    private static char jugadorActual;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al juego de N en Raya.");
        System.out.print("Por favor, introduzca el tamaño del tablero: ");
        dimension = scanner.nextInt();

        System.out.print("Por favor, introduzca el número de símbolos en línea para ganar: ");
        enLinea = scanner.nextInt();

        tablero = new char[dimension][dimension];
        inicializarTablero();

        jugadorActual = 'X'; // Comienza el jugador 'X'

        boolean juegoTerminado = false;
        int movimientosRealizados = 0;

        while (!juegoTerminado && movimientosRealizados < dimension * dimension) {
            imprimirTablero();
            hacerMovimiento(scanner);
            juegoTerminado = verificarVictoria();
            cambiarTurno();
            movimientosRealizados++;
        }

        imprimirTablero();

        if (juegoTerminado) {
            System.out.println("¡Felicidades! El jugador " + jugadorActual + " ha ganado.");
        } else {
            System.out.println("¡Empate! El tablero está lleno.");
        }
    }

    public static void inicializarTablero() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    public static void imprimirTablero() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void hacerMovimiento(Scanner scanner) {
        boolean movimientoValido = false;

        while (!movimientoValido) {
            System.out.print("Turno del jugador " + jugadorActual + ". Introduzca la fila (0-" + (dimension - 1) + "): ");
            int fila = scanner.nextInt();

            System.out.print("Introduzca la columna (0-" + (dimension - 1) + "): ");
            int columna = scanner.nextInt();

            if (fila >= 0 && fila < dimension && columna >= 0 && columna < dimension && tablero[fila][columna] == '-') {
                tablero[fila][columna] = jugadorActual;
                movimientoValido = true;
            } else {
                System.out.println("Movimiento inválido. Inténtelo de nuevo.");
            }
        }
    }

    public static boolean verificarVictoria() {
        // Verificar filas
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j <= dimension - enLinea; j++) {
                boolean victoria = true;
                for (int k = 0; k < enLinea; k++) {
                    if (tablero[i][j + k] != jugadorActual) {
                        victoria = false;
                        break;
                    }
                }
                if (victoria) return true;
            }
        }

        // Verificar columnas
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j <= dimension - enLinea; j++) {
                boolean victoria = true;
                for (int k = 0; k < enLinea; k++) {
                    if (tablero[j + k][i] != jugadorActual) {
                        victoria = false;
                        break;
                    }
                }
                if (victoria) return true;
            }
        }

        // Verificar diagonales
        for (int i = 0; i <= dimension - enLinea; i++) {
            for (int j = 0; j <= dimension - enLinea; j++) {
                boolean victoria1 = true;
                boolean victoria2 = true;
                for (int k = 0; k < enLinea; k++) {
                    if (tablero[i + k][j + k] != jugadorActual) {
                            victoria1 = false;
                        }
                        if (tablero[i + k][j + (enLinea - 1) - k] != jugadorActual) {
                            victoria2 = false;
                        }
                    }
                    if (victoria1 || victoria2) return true;
                }
            }
            return false;
        }

        public static void cambiarTurno() {
            jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
        }
    }