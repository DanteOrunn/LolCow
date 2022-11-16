package excepciones;

/**
 * La clase captura la excepcion en caso de que la cadena ingresada este vacia
 */
public class CadenaVaciaExcepcion extends Exception{

    public CadenaVaciaExcepcion() {
        super("La cadena ingresada esta vacia");
    }

    public CadenaVaciaExcepcion(String message) {
        super(message);
    }

}
