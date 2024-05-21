import javax.xml.bind.annotation.*;
import java.util.Scanner;

@XmlRootElement(name = "Datos")
@XmlType(propOrder = {"nombre1", "nombre2", "fichaJ1", "fichaJ2", "numComienzo", "dimension", "empate", "arrayTablero", "turnoJ1", "turnoJ2", "contadorPartida", "finJuego"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Tablero extends Juego {
    @XmlElement(name = "nombre")
    private String nombre1;
    @XmlElement(name = "nombre2")
    private String nombre2;
    @XmlElement(name = "ficha")
    private char fichaJ1;
    @XmlElement(name = "ficha2")
    private char fichaJ2;
    @XmlElement(name = "comienzo")
    private int numComienzo;
    @XmlElement(name = "tamaño")
    private int dimension;

    private int empate = 0;
    protected char[][] arrayTablero;
    private boolean turnoJ1;
    private boolean turnoJ2;
    private int contadorPartida = 0;
    private boolean finJuego;


    // Getters y Setters
    public String getNombre1() { return nombre1; }
    public void setNombre1(String nombre1) { this.nombre1 = nombre1; }
    public String getNombre2() { return nombre2; }
    public void setNombre2(String nombre2) { this.nombre2 = nombre2; }
    public char getFichaJ1() { return fichaJ1; }
    public void setFichaJ1(String fichaJ1) { this.fichaJ1 = fichaJ1.charAt(0); }
    public char getFichaJ2() { return fichaJ2; }
    public void setFichaJ2(String fichaJ2) { this.fichaJ2 = fichaJ2.charAt(0); }
    public int getNumComienzo() { return numComienzo; }
    public void setNumComienzo(int numComienzo) { this.numComienzo = numComienzo; }
    public int getDimension() { return dimension; }
    public void setDimension(int dimension) { this.dimension = dimension; }

    // Constructores para el tablero
    public Tablero() {
    }
    public Tablero(String nombre1, String nombre2, char fichaJ1, char fichaJ2, int numComienzo, int dimension) {
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.fichaJ1 = fichaJ1;
        this.fichaJ2 = fichaJ2;
        this.numComienzo = numComienzo;
        this.dimension = dimension;
    }

    // Metodo para mostrar el tablero del juego
    private void rellenar() {
        for (int i = 0; i < arrayTablero.length; i++) {
            for (int j = 0; j < arrayTablero.length; j++) {
                if ((arrayTablero[i][j] == fichaJ1) || (arrayTablero[i][j] == fichaJ2)) {
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
        //dimension=leer.nextInt();
        arrayTablero = new char[dimension][dimension];
    }

    /* Metodo para elegir quien empieza
    private boolean ElegirComiezo() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Jugador 1,introduzca su nombre");
        nombre1 = leer.next();
        System.out.println("Indique cual quiere que sea su ficha");
        fichaJ1 = leer.next().charAt(0);

        System.out.println("Jugador 2,introduzca su nombre");
        nombre2 = leer.next();
        System.out.println("Indique cual quiere que sea su ficha");
        fichaJ2 = leer.next().charAt(0);

        System.out.println("Quien quiere comenzar,el 1 o el 2?");
        numComienzo = leer.nextInt();
        if (numComienzo > 2) {
            System.out.println("Error, introduce un numero entre 1 y 2");
            ElegirComiezo();
        } else {
            if (numComienzo == 1) {
                turnoJ1 = true;
                turnoJ2 = false;
                return turnoJ1;
            } else {
                turnoJ2 = true;
                turnoJ1 = false;
                return turnoJ2;
            }
        }
        return false;
    }
     */

    // Metodo para introducir casillas en el tablero
    private void introducir() {
            Scanner leer = new Scanner(System.in);
            int fila = 0, columna = 0;
            if (turnoJ1 ==true){
                System.out.println(nombre1 + " es tu turno ");
            }else if (turnoJ2 ==true){
                System.out.println(nombre2 + " es tu turno ");
            }
            System.out.println("Introduce fila");
            fila = leer.nextInt();
            System.out.println("Introduce columna");
            columna = leer.nextInt();
            if ((arrayTablero[fila][columna] == fichaJ1) || (arrayTablero[fila][columna] == fichaJ2)) {
                System.out.println("La fila " + fila + " y la columna " + columna + " Esta ocupada");
                introducir();
            } else {
                if (turnoJ1 ==true){
                    arrayTablero[fila][columna] = fichaJ1;
                }else if (turnoJ2 ==true){
                    arrayTablero[fila][columna] = fichaJ2;
                }
                empate++;
            }
    }
    //Metodo para cambiar de turno
    private boolean CambiarTurno() {
        if (turnoJ1 == false) {
            turnoJ1 = true;
            turnoJ2 = false;
        } else {
            turnoJ1 = false;
            turnoJ2 = true;
        }
        return turnoJ1;
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
    private boolean Filas() {
        for (int i = 0; i < arrayTablero.length; i++) {
            int cont1 = 0;
            int cont2 = 0;
            for (int j = 0; j < arrayTablero.length; j++) {
                if (arrayTablero[i][j] == fichaJ1) {
                    cont1++;
                } else if (arrayTablero[i][j] == fichaJ2) {
                    cont2++;
                }
            }
            if (cont2 == arrayTablero.length) {
                System.out.println(nombre1+" es el ganador!!");
                return true;
            } else if (cont1 == arrayTablero.length) {
                System.out.println(nombre2+" es el ganador!!");
                return true;
            }
        }
        return false;
    }

    // Comprueba las columnas
    private boolean Col() {
        for (int i = 0; i < arrayTablero.length; i++) {
            int cont1 = 0;
            int cont2 = 0;
            for (int j = 0; j < arrayTablero.length; j++) {
                if (arrayTablero[j][i] == fichaJ1) {
                    cont1++;
                } else if (arrayTablero[j][i] == fichaJ2) {
                    cont2++;
                }
            }
            if (cont2 == arrayTablero.length) {
                System.out.println(nombre1+" es el ganador!!");
                return true;
            } else if (cont1 == arrayTablero.length) {
                System.out.println(nombre2+" es el ganador!!");
                return true;
            }
        }
        return false;
    }
    
    // Comprueba las diagonales
    private boolean Diagonal() {
        int contXDiagonal1 = 0;
        int contODiagonal1 = 0;
        int contXDiagonal2 = 0;
        int contODiagonal2 = 0;

        for (int i = 0; i < arrayTablero.length; i++) {
            if (arrayTablero[i][i] == fichaJ1) {
                contXDiagonal1++;
            } else if (arrayTablero[i][i] == fichaJ2) {
                contODiagonal1++;
            }
            if (arrayTablero[i][arrayTablero.length - 1 - i] == fichaJ1) {
                contXDiagonal2++;
            } else if (arrayTablero[i][arrayTablero.length - 1 - i] == fichaJ2) {
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
        if (Col() == true || Filas() == true || Empate() == true || Diagonal() == true) {
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
            //ElegirComiezo();
            contadorPartida++;
        }
        rellenar();
        introducir();
        CambiarTurno();
        Fin();
    }
}
