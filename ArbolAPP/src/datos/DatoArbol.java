/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import interfaces.Comparador;
import listaSE.NodoL;

/**
 *
 * @author alumno
 */
public class DatoArbol implements Comparador{
    private long dni;
    private NodoL dir;

    public DatoArbol(long dni, NodoL dir) {
        this.dni = dni;
        this.dir = dir;
    }

    public DatoArbol(long dni) {
        this.dni = dni;
        this.dir = null;
    }
    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public NodoL getDir() {
        return dir;
    }

    public void setDir(NodoL dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        return "DatoArbol{" + "dni=" + dni + ", dir=" + dir.getDato() + '}';
    }
    //como el dato del NodoL es object serian asi los metodos

    @Override
    public boolean igualQue(Object op2) {
        DatoArbol dat=(DatoArbol)op2;
        return dni== dat.getDni();
    }

    /*
    @Override
    public boolean igualQue(Object op2) {
        DatoArbol dat=(DatoArbol)op2;
        return dir.getDato().igualQue(dat.getDir().getDato());
    }*/

    @Override
    public boolean menorQue(Object op2) {
        DatoArbol dat=(DatoArbol)op2;
        return dni< dat.getDni();}

    @Override
    public boolean menorIgualQue(Object op2) {
        DatoArbol dat=(DatoArbol)op2;
        return dir.getDato().menorIgualQue(dat.getDir().getDato());
    }

    @Override
    public boolean mayorQue(Object op2) {
        DatoArbol dat=(DatoArbol)op2;
        return dni> dat.getDni();
    }

    @Override
    public boolean mayorIgualQue(Object op2) {
        DatoArbol dat=(DatoArbol)op2;
        return dni >= dat.getDni();
    }
    
}
