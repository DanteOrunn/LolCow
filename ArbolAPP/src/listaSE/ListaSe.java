/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaSE;

import datos.Alumno;
import datos.Reclamo;

/**
 *
 * @author alumno
 */
public class ListaSe {

    private NodoL inicio;

    public ListaSe() {
        inicio = null;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public void insert(Reclamo rec) {
        NodoL nuevo = new NodoL(rec);
        if (isEmpty()) {
            inicio = nuevo;
        } else {
            nuevo.setPs(inicio);
        }
        inicio = nuevo;
    }

    public NodoL inicio() {
        return inicio;
    }

    public void print() {
        if (!isEmpty()) {
            NodoL p = inicio;
            while (p != null) {
                System.out.println(p.getDato());
                p = p.getPs();
            }
        } else {
            System.out.println("Lista Vacia");
        }

    }
    public boolean search(Object buscado){
        NodoL p = inicio;
            while (p != null) {
                if(p.getDato().igualQue(buscado))
                    return true;
                p = p.getPs();
            }
        return false;
    }
}
