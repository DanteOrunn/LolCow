package datos;

import entradaDatos.Consola;
import excepciones.*;
import interfaces.Comparador;

/**
 * Se debe de terminar la clase
 */
public class Libro {

    private int id;
    private char genero;
    private char estadoLibro;
    private float precio;
    private String titulo;
    private String autor;

    public Libro() {
        this.id = 0;
        this.genero = ' ';
        this.estadoLibro = ' ';
        this.precio = 0;
        this.titulo = "";
        this.autor = "";
    }

    public Libro(int id, char genero, char estadoLibro, float precio, String titulo, String autor) {
        this.id = id;
        this.genero = genero;
        this.estadoLibro = estadoLibro;
        this.precio = precio;
        this.titulo = titulo;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws NumeroNegativoExcepcion {
        if (id < 0) {
            throw new NumeroNegativoExcepcion();
        }
        this.id = id;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) throws CadenaLargaExcepcion, CadenaVaciaExcepcion {
        String ax = String.valueOf(genero);
        if (ax.trim().length() < 1) {
            throw new CadenaVaciaExcepcion();
        } else if (ax.trim().length() > 1) {
            throw new CadenaLargaExcepcion();
        }
        this.genero = genero;
    }

    public char getEstadoLibro() {
        return estadoLibro;
    }

    public void setEstadoLibro(char estadoLibro) throws CadenaVaciaExcepcion, CadenaLargaExcepcion {
        String ax = String.valueOf(estadoLibro);
        if (ax.trim().length() < 1) {
            throw new CadenaVaciaExcepcion();
        } else if (ax.trim().length() > 1) {
            throw new CadenaLargaExcepcion();
        }
        this.estadoLibro = estadoLibro;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) throws NumeroNegativoExcepcion {
        if (precio < 0) {
            throw new NumeroNegativoExcepcion();
        }
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) throws CadenaVaciaExcepcion, CadenaLargaExcepcion {
        if (titulo.trim().length() < 1) {
            throw new CadenaVaciaExcepcion();
        } else if (titulo.trim().length() > 60){
            throw new CadenaLargaExcepcion();
        }
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) throws CadenaVaciaExcepcion, CadenaLargaExcepcion {
        if (autor.trim().length() < 1) {
            throw new CadenaVaciaExcepcion();
        } else if (autor.trim().length() > 60) {
            throw new CadenaLargaExcepcion();
        }
        this.autor = autor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID Libro:").append(this.id).append("\n");
        return sb.toString();
    }

}
