/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaSE;

import datos.Reclamo;

/**
 *
 * @author alumno
 */
public class NodoL {
    private Reclamo dato;
    private NodoL ps;

    public NodoL(Reclamo dato) {
        this.dato = dato;
        ps=null;
    }

    public Reclamo getDato() {
        return dato;
    }

    public void setDato(Reclamo dato) {
        this.dato = dato;
    }

    public NodoL getPs() {
        return ps;
    }

    public void setPs(NodoL ps) {
        this.ps = ps;
    }
    
}
