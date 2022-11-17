package datos;

import entradaDatos.Consola;
import excepciones.CadenaLargaExcepcion;
import excepciones.CadenaVaciaExcepcion;
import excepciones.NumeroNegativoExcepcion;
import interfaces.Comparador;
import java.util.Objects;

public class Inscriptos implements Comparador{

    private long dni;
    private int formaPago;
    private double montoCuento;
    private String apellido;
    private String nombre;
    private String telefono;
    private boolean estado;

    public Inscriptos() {
        this.dni = 0;
        this.formaPago = 0;
        this.montoCuento = 0;
        this.apellido = "";
        this.nombre = "";
        this.telefono = "";
        this.estado = false;
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

    public void setDni(long dni) throws NumeroNegativoExcepcion {
        if (dni < 0) {
            throw new NumeroNegativoExcepcion();
        }
        this.dni = dni;
    }

    public int getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(int formaPago) throws NumeroNegativoExcepcion{
        if (formaPago < 0) {
            throw new NumeroNegativoExcepcion();
        }
        this.formaPago = formaPago;
    }

    public double getMontoCuento() {
        return montoCuento;
    }

    public void setMontoCuento(double montoCuento) throws NumeroNegativoExcepcion {
        if (montoCuento < 0) {
            throw new NumeroNegativoExcepcion();
        }
        this.montoCuento = montoCuento;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) throws CadenaLargaExcepcion, CadenaVaciaExcepcion {
        if (apellido.trim().length() < 1) {
            throw new CadenaVaciaExcepcion();
        } else if (apellido.trim().length() <= 60) {
            throw new CadenaLargaExcepcion();
        }
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws CadenaLargaExcepcion, CadenaVaciaExcepcion {
        if (nombre.trim().length() < 1) {
            throw new CadenaVaciaExcepcion();
        } else if (nombre.trim().length() <= 60) {
            throw new CadenaLargaExcepcion();
        }
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) throws CadenaLargaExcepcion, CadenaVaciaExcepcion {
        if (telefono.trim().length() < 1) {
            throw new CadenaVaciaExcepcion();
        } else if (telefono.trim().length() <= 60) {
            throw new CadenaLargaExcepcion();
        }
        this.telefono = telefono;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public void cargarDatos() {
        cargarDNI();
        cargarApellido();
        cargarNombre();
        cargarFormaPago();
        cargarMontoCurso();
        cargarEstado();
    }
    
    public void cargarDNI() {
        long ax = 0;
        boolean flag = false;
        while (!flag) {
            try {
                System.out.print("DNI:");
                ax = Consola.readLong();
                setDni(ax);
                flag = true;
            } catch (NumeroNegativoExcepcion | NumberFormatException ex) {
                System.out.println("Error:" + ex.getMessage());
            }
        }
    }

    private void cargarApellido() {
        String ax = "";
        boolean flag = false;
        while (!flag) {
            try {
                System.out.print("Apellido:");
                ax = Consola.readLine();
                setApellido(ax);
                flag = true;
            } catch (CadenaVaciaExcepcion | CadenaLargaExcepcion ex) {
                System.out.println("Error:" + ex.getMessage());
            }
        }
    }

    private void cargarNombre() {
        String ax = "cat";
        boolean flag = false;
        while (!flag) {
            try {
                System.out.print("Nombre:");
                ax = Consola.readLine();
                setNombre(ax);
                flag = true;
            } catch (CadenaVaciaExcepcion | CadenaLargaExcepcion ex) {
                System.out.println("Error:" + ex.getMessage());
            }
        }
    }
    
    private void cargarMontoCurso() {
        double ax = 0;
        boolean flag = false;
        while (!flag) {
            try {
                System.out.print("Monto del Curso:");
                ax = Consola.readDouble();
                setMontoCuento(ax);
                flag = true;
            } catch (NumeroNegativoExcepcion | NumberFormatException ex) {
                System.out.println("Error:" + ex.getMessage());
            }
        }
    }
    
    private void cargarFormaPago() {
        int ax = 0;
        boolean flag = false;
        while (!flag) {
            try {
                System.out.print("Forma de Pago (1-Pagado/2-Deuda):");
                ax = Consola.readInt();
                setFormaPago(ax);
                flag = true;
            } catch (NumeroNegativoExcepcion | NumberFormatException ex) {
                System.out.println("Error:" + ex.getMessage());
            }
        }
    }
    
    private void cargarEstado() {
        String dat = "";
        do {
            System.out.printf("Estado del Reclamo (1.En gestion / 2.Solucionado):");
            dat = Consola.readLine();
        } while (!(dat.trim().length() > 0 && dat.trim().length() < 2));
        int value = Integer.parseInt(dat);
        if (value == 1) {
            setEstado(false);
        } else if (value == 2) {
            setEstado(true);
        }
    }
    
    public void modificarDatos() {
        
    }
    
    private void menuModificacion() {
        String space = " ";
        String cat = "*";
        int c = 37;
        System.out.println(cat.repeat(c));
        System.out.println("*" + space.repeat(9) + "MENU MODIFICACION" + space.repeat(9) + "*");
        System.out.println(cat.repeat(c));
        System.out.println("*1.Apellido" + space.repeat(c - 11) + "*");
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

    @Override
    public boolean igualQue(Object op2) {
        Inscriptos x = (Inscriptos) op2;
        return this.dni == x.getDni();
    }

    @Override
    public boolean menorQue(Object op2) {
        Inscriptos x = (Inscriptos) op2;
        return this.dni < x.getDni();
    }

    @Override
    public boolean menorIgualQue(Object op2) {
        Inscriptos x = (Inscriptos) op2;
        return this.dni <= x.getDni();
    }

    @Override
    public boolean mayorQue(Object op2) {
        Inscriptos x = (Inscriptos) op2;
        return this.dni >x.getDni();
    }

    @Override
    public boolean mayorIgualQue(Object op2) {
        Inscriptos x = (Inscriptos) op2;
        return this.dni >= x.getDni();
    }
    
}
