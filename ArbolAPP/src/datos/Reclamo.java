package datos;

import entradaDatos.Consola;
import excepciones.CadenaLargaExcepcion;
import excepciones.CadenaVaciaExcepcion;
import excepciones.NumeroNegativoExcepcion;
import interfaces.Comparador;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class Reclamo implements Comparador {

    private long dni;
    private String nombre;
    private String apellido;
    private String reclamo;
    private LocalDate fechaReclamo;
    private boolean estadoReclamo;

    public Reclamo() {
        this.dni = 0;
        this.nombre = "";
        this.apellido = "";
        this.reclamo = "";
        this.fechaReclamo = null;
        this.estadoReclamo = false;
    }

    public Reclamo(int dni, String nombre, String apellido, String reclamo, LocalDate fechaReclamo, boolean estadoReclamo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.reclamo = reclamo;
        this.fechaReclamo = fechaReclamo;
        this.estadoReclamo = estadoReclamo;
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

    public String getNombre()  {
        return nombre;
    }

    public void setNombre(String nombre) throws CadenaLargaExcepcion, CadenaVaciaExcepcion {
        if (nombre.trim().length() < 0){
            throw new CadenaVaciaExcepcion();
        } else if (apellido.trim().length() >= 60) {
                throw new CadenaLargaExcepcion();
        }
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) throws CadenaVaciaExcepcion, CadenaLargaExcepcion {
        if (apellido.trim().length() < 0){
            throw new CadenaVaciaExcepcion();
        } else if (apellido.trim().length() >= 60) {
                throw new CadenaLargaExcepcion();
        }
        this.apellido = apellido;
    }

    public String getReclamo() {
        return reclamo;
    }

    public void setReclamo(String reclamo) throws CadenaLargaExcepcion, CadenaVaciaExcepcion {
        if (reclamo.trim().length() < 0){
            throw new CadenaVaciaExcepcion();
        } else if (reclamo.trim().length() >= 200) {
                throw new CadenaLargaExcepcion();
        }
        this.reclamo = reclamo;
    }

    public LocalDate getFechaReclamo() {
        return fechaReclamo;
    }

    public void setFechaReclamo(LocalDate fechaReclamo) throws NumeroNegativoExcepcion {
        if (fechaReclamo.getDayOfMonth() < 0) {
            throw new NumeroNegativoExcepcion();
        } else if (fechaReclamo.getMonthValue() < 0) {
            throw new NumeroNegativoExcepcion();
        } else if (fechaReclamo.getYear() < 0) {
            throw new NumeroNegativoExcepcion();
        }
        this.fechaReclamo = fechaReclamo;
    }

    public boolean isEstadoReclamo() {
        return estadoReclamo;
    }

    public void setEstadoReclamo(boolean estadoReclamo) {
        this.estadoReclamo = estadoReclamo;
    }

    public void cargarDatos() {
        cargarApellido();
        cargarNombre();
        cargarReclamo();
        cargarFechaReclamo();
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
        String ax = "";
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

    private void cargarReclamo() {
        String ax = "";
        boolean flag = false;
        while (!flag) {
            try {
                System.out.print("Reclamo:");
                ax = Consola.readLine();
                setReclamo(ax);
                flag = true;
            } catch (CadenaVaciaExcepcion | CadenaLargaExcepcion ex) {
                System.out.println("Error:" + ex.getMessage());
            }
        }
    }

    private void cargarFechaReclamo() {
        boolean flag = false;
        while (!flag) {
            try {
                System.out.printf("Dia:");
                int axD = Consola.readInt();
                System.out.printf("Mes:");
                int axM = Consola.readInt();
                System.out.printf("Año:");
                int axA = Consola.readInt();
                LocalDate local = LocalDate.of(axA,axM,axD);
                setFechaReclamo(local);
                flag = true;
            } catch (NumeroNegativoExcepcion | NumberFormatException | DateTimeException ex) {
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
            setEstadoReclamo(false);
        } else if (value == 2) {
            setEstadoReclamo(true);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DNI:").append(this.dni).append(".").append("\n");
        sb.append("Apellido y Nombre:").append(this.apellido).append(" ").append(this.nombre).append(".").append("\n");
        sb.append("Estado del Reclamo:");
        if (!this.estadoReclamo) {
            sb.append("En gestion.").append("\n");
        } else {
            sb.append("Solucionado.").append("\n");
        }
        sb.append("Reclamo:").append(this.reclamo).append(".").append("\n");
        sb.append("\t\t").append("Fecha del Reclamo:").append(this.fechaReclamo).append(".").append("\n");
        return sb.toString();
    }

    @Override
    public boolean igualQue(Object op2) {
        Reclamo x = (Reclamo) op2;
        return this.dni == x.getDni();
    }

    @Override
    public boolean menorQue(Object op2) {
        Reclamo x = (Reclamo) op2;
        return this.dni < x.getDni();
    }

    @Override
    public boolean menorIgualQue(Object op2) {
        Reclamo x = (Reclamo) op2;
        return this.dni <= x.getDni();
    }

    @Override
    public boolean mayorQue(Object op2) {
        Reclamo x = (Reclamo) op2;
        return this.dni > x.getDni();
    }

    @Override
    public boolean mayorIgualQue(Object op2) {
        Reclamo x = (Reclamo) op2;
        return this.dni >= x.getDni();
    }
}
