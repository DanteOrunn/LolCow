package excepciones;

/**
 * La clase servira para capturar la excepcion en caso de que se ingrese un numero negativo
 * durante el ingreso de los datos.
 */
public class NumeroNegativoExcepcion extends Exception {

    public NumeroNegativoExcepcion() {
        super("Se ingreso un numero negativo");
    }

    public NumeroNegativoExcepcion(String message) {
        super(message);
    }

    public String getString() {
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }

}
