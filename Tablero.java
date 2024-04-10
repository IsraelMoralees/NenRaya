public class Tablero {
        char juego [][];
        int turno=0;


    public char [][] IntDimensiones(int dimension){
        char juego [][] = new char[dimension][dimension];
        return juego;
    }

    // Metodo para mostrar el tablero del juego
    public void rellenar() {
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
    public void introducir(int fila, int columna) {
        if (turno % 2 == 0) {
            if ((juego[fila][columna] == 'X') || (juego[fila][columna] == 'O')) {
                System.out.println("La fila " + fila + " y la columna " + columna + " Esta ocupada");
                introducir(fila, columna);
            } else {
                juego[fila][columna] = 'X';
            }
        } else {
            if ((juego[fila][columna] == 'X') || (juego[fila][columna] == 'O')) {
                System.out.println("La fila " + fila + " y la columna " + columna + " Esta ocupada");
                introducir(fila, columna);
            } else {
                juego[fila][columna] = 'O';
            }
        }
    }
    public boolean Empate() {
        // Mira el empate
        if (turno == juego.length * juego.length) {
            System.out.println("Empate!");
            return true;
        }
        return false;
    }
    public boolean ComprobarFilas(char juego[][]){
        for (int i=0; i<juego.length; i++){
            int contX=0;
            int contO=0;
            for (int j=0; j<juego.length; j++){
                if (juego[i][j]=='X'){
                    contX++;
                }else if (juego[i][j]=='O'){
                    contO++;
                }
            }
            if (contO==juego.length){
                System.out.println("Jugador O gana!"); 
                return true;
            }else if (contX==juego.length) {
                System.out.println("Jugador X gana!");
                return true;
            }
        }
        return false;
    }
    public boolean ComprobarCol(char juego[][]){
        for (int i=0; i<juego.length; i++){
            int contX=0;
            int contO=0;
            for (int j=0; j<juego.length; j++){
                if (juego[j][i]=='X'){
                    contX++;
                }else if (juego[j][i]=='O'){
                    contO++;
                }
            }
            if (contO==juego.length){
                System.out.println("Jugador O gana!"); 
                return true;
            }else if (contX==juego.length) {
                System.out.println("Jugador X gana!");
                return true;
            }
        }
        return false;
    }
    public boolean ComprobarDiagonal(char juego[][]){
        for (int i=0; i<juego.length; i++){
            int contX=0;
            int contO=0;
            for (int j=0; j<juego.length; j++){
                if (juego[i+1][j+1]=='X'){
                    contX++;
                }else if (juego[i+1][j+1]=='O'){
                    contO++;
                }
            }
            if (contO==juego.length){
                System.out.println("Jugador O gana!"); 
                return true;
            }else if (contX==juego.length) {
                System.out.println("Jugador X gana!");
                return true;
            }
        }
        return false;
    }
    public boolean Fin (){
        if(ComprobarCol(juego)==true||ComprobarDiagonal(juego)==true||ComprobarFilas(juego)==true||Empate()==true){
            return true;
        }
        return false;
    }
}
