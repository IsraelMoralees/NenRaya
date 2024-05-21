import javax.xml.bind.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        //Crea el objeto logica del juego para poder llamar al metodo jugar
        LogicaJuego j1 = new LogicaJuego();
        try {
            JAXBContext context = JAXBContext.newInstance(Tablero.class);
            Unmarshaller um = context.createUnmarshaller();
            Tablero tablero = (Tablero) um.unmarshal(new File("Datos.xml"));

            System.out.println("Nombre1: " + tablero.getNombre1());
            System.out.println("Nombre2: " + tablero.getNombre2());
            System.out.println("FichaJ1: " + tablero.getFichaJ1());
            System.out.println("FichaJ2: " + tablero.getFichaJ2());
            System.out.println("Comienzo: " + tablero.getNumComienzo());
            System.out.println("Dimension: " + tablero.getDimension());
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        j1.Jugar();
    }
}
