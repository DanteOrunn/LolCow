package excepciones;

/**
 * La clase captura la excepcion en los casos en que la cadena de caracteres ingresada
 * supere una cantidad indicada.
 */
public class CadenaLargaExcepcion extends Exception{

    public CadenaLargaExcepcion() {
        super("La cadena supero el limite de caracteres");
    }

    public CadenaLargaExcepcion(String message) {
        super(message);
    }

}
