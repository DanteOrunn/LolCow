/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import entradaDatos.Consola;
import interfaces.Comparador;

/**
 *
 * @author alumno
 */
public class Alumno implements Comparador{
    private long dni;
    private String nombre,apellido;
    private long celular;
    private char condicion;
    
    public Alumno() {
        this.dni = 0;
        this.nombre = this.apellido = "";
        this.celular = 0;
        this.condicion = 'a';
    }

    public Alumno(long dni, String nombre, String apellido, long celular, char condicion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.condicion = condicion;
    }
    

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public char getCondicion() {
        return condicion;
    }

    public void setCondicion(char condicion) {
        this.condicion = condicion;
    }

    @Override
    public String toString() {
        return "Alumno{" + "dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", celular=" + celular + ", condicion=" + condicion + '}';
    }
    public void cargar(){
        System.out.print("Nombre> ");
        nombre=Consola.readLine();
        System.out.print("Apellido> ");
        apellido=Consola.readLine();
        System.out.print("Celular> ");
        celular=Consola.readLong();
        //System.out.print("Condicion A(Aprobado), R(Regular), D(Desaprobado)> ");
        //condicion=Consola.readChar();
    }
    public void cargarDNI(){
        System.out.print("DNI> ");
        dni=Consola.readLong();
    }
    @Override
    public boolean igualQue(Object op2) {
        Alumno alu=(Alumno)op2;
        return dni==alu.getDni();
    }

    @Override
    public boolean menorQue(Object op2) {
        Alumno alu=(Alumno)op2;
        return dni<alu.getDni();
    }

    @Override
    public boolean menorIgualQue(Object op2) {
        Alumno alu=(Alumno)op2;
        return dni<=alu.getDni();
    }

    @Override
    public boolean mayorQue(Object op2) {
        Alumno alu=(Alumno)op2;
        return dni>alu.getDni();
    }

    @Override
    public boolean mayorIgualQue(Object op2) {
        Alumno alu=(Alumno)op2;
        return dni>=alu.getDni();
    }
}
