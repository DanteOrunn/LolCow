package datos;

import java.util.Objects;

/**
 * documento, apellido y nombre, telefono, forma de pago (efectivo/tarjeta), monto del curso,
 * estado (pagado/deuda).
 */
public class Inscriptos {

    private long dni;
    private int formaPago;
    private double montoCuento;
    private String apellido;
    private String nombre;
    private String telefono;
    private boolean estado;

    public Inscriptos() {
    }

    public Inscriptos(long dni, int formaPago, double montoCuento, String apellido, String nombre, String telefono, boolean estado) {
        this.dni = dni;
        this.formaPago = formaPago;
        this.montoCuento = montoCuento;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.estado = estado;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public int getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(int formaPago) {
        this.formaPago = formaPago;
    }

    public double getMontoCuento() {
        return montoCuento;
    }

    public void setMontoCuento(double montoCuento) {
        this.montoCuento = montoCuento;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.dni ^ (this.dni >>> 32));
        hash = 67 * hash + this.formaPago;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.montoCuento) ^ (Double.doubleToLongBits(this.montoCuento) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.apellido);
        hash = 67 * hash + Objects.hashCode(this.nombre);
        hash = 67 * hash + Objects.hashCode(this.telefono);
        hash = 67 * hash + (this.estado ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inscriptos other = (Inscriptos) obj;
        if (this.dni != other.dni) {
            return false;
        }
        if (this.formaPago != other.formaPago) {
            return false;
        }
        if (Double.doubleToLongBits(this.montoCuento) != Double.doubleToLongBits(other.montoCuento)) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.telefono, other.telefono);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Inscriptos{");
        sb.append("dni=").append(dni);
        sb.append(", formaPago=").append(formaPago);
        sb.append(", montoCuento=").append(montoCuento);
        sb.append(", apellido=").append(apellido);
        sb.append(", nombre=").append(nombre);
        sb.append(", telefono=").append(telefono);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }
    
}
